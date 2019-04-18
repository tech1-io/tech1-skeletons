package com.forcelate.service.impl;

import com.forcelate.domain.User;
import com.forcelate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public Mono<User> findOne(Long userId) {
        LOGGER.info("UserService: execute findOne(userId) method");
        return Mono.just(Objects.requireNonNull(this.users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null)));
    }

    @Override
    public Flux<User> findAll() {
        LOGGER.info("UserService: execute findAll() method");
        return Flux.fromIterable(this.users);
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
