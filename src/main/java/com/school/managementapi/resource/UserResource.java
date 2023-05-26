package com.school.managementapi.resource;

import com.school.managementapi.domain.User;
import com.school.managementapi.domain.UserPrincipal;
import com.school.managementapi.dto.UserDto;
import com.school.managementapi.mapper.ModelMapper;
import com.school.managementapi.security.JWTTokenProvider;
import com.school.managementapi.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.school.managementapi.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class UserResource {
    private final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody User user) {
        logger.info("registering new user with username: {}", user.getUsername());
        User newUser = userServiceImpl.register(user);
        UserDto userDto = modelMapper.map(newUser, UserDto.class);
        return new ResponseEntity<>(userDto, OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody User user) {
        logger.info("Login with username: {}", user.getUsername());
        authenticate(user.getUsername(), user.getPassword());
        User loginUser = userServiceImpl.finUserByUsername(user.getUsername());
        UserDto userDto = modelMapper.map(loginUser, UserDto.class);
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return new ResponseEntity<>(userDto, jwtHeader, OK);
    }

    private HttpHeaders getJwtHeader(UserPrincipal user) {
        HttpHeaders headers= new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
