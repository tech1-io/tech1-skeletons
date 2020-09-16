package com.forcelate.service.impl;

import com.forcelate.domain.User;
import com.forcelate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void postConstruct() {
        this.users.add(User.builder()
                        .id(1L)
                        .username("username1")
                        .age(14)
                        .build());
        this.users.add(User.builder()
                .id(2L)
                .username("username2")
                .age(25)
                .build());
    }

    @Override
    public User findOne(Long userId) {
        LOGGER.info("UserService: execute findOne(userId) method");
        return this.users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        LOGGER.info("UserService: execute findAll() method");
        return this.users;
    }

    @Override
    public void add() {
        LOGGER.info("UserService: execute add() method");
        this.users.add(User.builder()
                .id(3L)
                .username("username3")
                .age(34)
                .build());
    }
}
