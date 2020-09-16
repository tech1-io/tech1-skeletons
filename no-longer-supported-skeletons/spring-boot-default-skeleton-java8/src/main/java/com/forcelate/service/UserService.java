package com.forcelate.service;

import com.forcelate.domain.User;

import java.util.List;

public interface UserService {
    User findOne(Long userId);
    List<User> findAll();
    void add();
}
