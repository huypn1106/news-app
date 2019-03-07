package com.deadk.awsproject.service;

import com.deadk.awsproject.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
