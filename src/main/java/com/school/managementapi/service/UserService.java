package com.school.managementapi.service;

import com.school.managementapi.domain.User;

public interface UserService {
    User finUserByUsername(String username);
    User register(User user);
}
