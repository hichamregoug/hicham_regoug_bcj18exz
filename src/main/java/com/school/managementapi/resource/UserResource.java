package com.school.managementapi.resource;

import com.school.managementapi.domain.User;
import com.school.managementapi.dto.UserDto;
import com.school.managementapi.mapper.ModelMapper;
import com.school.managementapi.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class UserResource {
    private final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody User user) {
        logger.info("registering new user with username: {}", user.getUsername());
        User newUser = userServiceImpl.register(user);
        UserDto userDto = modelMapper.map(newUser, UserDto.class);
        return new ResponseEntity<>(userDto, OK);
    }
}
