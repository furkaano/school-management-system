package com.schoolmanagement.authservice.service;

import com.schoolmanagement.authservice.entity.User;
import com.schoolmanagement.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        // Encrypt the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        Optional<User> userOptional = userRepository.findByUsername(userName);
        return userOptional.orElse(null);
    }
}
