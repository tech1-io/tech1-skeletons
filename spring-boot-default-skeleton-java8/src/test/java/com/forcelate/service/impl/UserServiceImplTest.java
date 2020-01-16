package com.forcelate.service.impl;

import com.forcelate.domain.User;
import com.forcelate.service.UserService;
import com.forcelate.test.RandomUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static com.forcelate.test.RandomUtils.randomLong;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class UserServiceImplTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired private UserService componentUnderTest;

    @Test
    public void findOne() {
        // Arrange
        Long userId = 1L;

        // Act
        User user = componentUnderTest.findOne(userId);

        // Assert
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(userId);
        assertThat(user.getUsername()).isEqualTo("username1");
        assertThat(user.getAge()).isEqualTo(14);
    }

    @Test
    public void findOneNullCase() {
        // Arrange
        Long userId = 2L + randomLong();

        // Act
        User user = componentUnderTest.findOne(userId);

        // Assert
        assertThat(user).isNull();
    }

    @Test
    public void findAllPlusAddInOneCaseNoProperMockingPossible() {
        // Act
        List<User> users = componentUnderTest.findAll();

        // Assert
        assertThat(users).isNotNull();
        assertThat(users).hasSize(2);

        // Act
        componentUnderTest.add();

        // Assert
        List<User> usersAfterMutations = componentUnderTest.findAll();
        assertThat(usersAfterMutations).isNotNull();
        assertThat(usersAfterMutations).hasSize(3);
    }
}
