package com.forcelate.resource;

import com.forcelate.domain.User;
import com.forcelate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserResource {

    private final UserService userService;

    @GetMapping("/{userId}")
    public User findOne(@PathVariable("userId") long userId) {
        return this.userService.findOne(userId);
    }

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void add() {
        this.userService.add();
    }
}
