package com.schoolmanagement.authservice.service;

import com.schoolmanagement.authservice.entity.User;

public interface UserService {
    User save(User user);
    User findUserByUserName(String userName);
}
