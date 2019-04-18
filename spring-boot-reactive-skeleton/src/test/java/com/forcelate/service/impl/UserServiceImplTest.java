package com.forcelate.service.impl;

import com.forcelate.domain.User;
import com.forcelate.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static com.forcelate.test.RandomUtils.randomLong;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class UserServiceImplTest {


    @Configuration
    static class ContextConfiguration {

        @Bean
        UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void findAllUsers() {
        Flux<User> users = userService.findAll();

        StepVerifier.create(users)
                .recordWith(ArrayList::new)
                .expectNextCount(2)
                .consumeRecordedWith(results -> {
                    assertThat(results).hasSize(2);
                    assertThat(results)
                            .extracting(User::getId)
                            .contains(
                                    1L, 2L);
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void findOneById() {
        Mono<User> user = userService.findOne(1L);

        StepVerifier.create(user)
                .expectNextMatches(results -> {
                    assertThat(results.getId()).isEqualTo(1L);
                    return true;
                });
    }

    @Test
    public void findOneNullCase() {
        Mono<User> user = userService.findOne(1L);

        StepVerifier.create(user)
                .expectNextMatches(results -> {
                    assertThat(results.getId()).isEqualTo(1L + randomLong());
                    return false;
                });
    }
}
