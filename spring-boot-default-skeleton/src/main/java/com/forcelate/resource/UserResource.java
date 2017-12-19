package com.forcelate.resource;

import com.forcelate.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserResource {

    @GetMapping
    public List<User> users() {
        LOGGER.info("API: Users");
        return Arrays.asList(
                User.builder()
                        .id(1)
                        .username("username1")
                        .age(20)
                        .build(),
                User.builder()
                        .id(2)
                        .username("username2")
                        .age(25)
                        .build()
        );
    }
}
