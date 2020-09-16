package io.tech1.service;

import io.tech1.domain.User;

import java.util.List;

public interface UserService {
    User findOne(Long userId);
    List<User> findAll();
    void add();
}
