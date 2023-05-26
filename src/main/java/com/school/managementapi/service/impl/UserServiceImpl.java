package com.school.managementapi.service.impl;

import com.school.managementapi.domain.User;
import com.school.managementapi.domain.UserPrincipal;
import com.school.managementapi.repository.UserRepository;
import com.school.managementapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User finUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User register(User user) {
        String encodedPassword = encodePassword(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        logger.info("registration for new user {}", user.getUsername());
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found by username: " + username);
        } else {
            UserPrincipal userPrincipal = new UserPrincipal(user);
            logger.info("Returning found user by username: {}", username);
            return userPrincipal;
        }
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
