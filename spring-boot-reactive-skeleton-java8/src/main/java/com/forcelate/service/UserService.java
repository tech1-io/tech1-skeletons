package com.forcelate.service;

import com.forcelate.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> findOne(Long userId);
    Flux<User> findAll();
    void add();
}
