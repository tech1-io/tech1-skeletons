package io.tech1.service.impl;

import io.tech1.domain.User;
import io.tech1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static io.tech1.test.RandomUtils.randomLong;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({ SpringExtension.class })
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImplTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        UserService userService() {
            return new UserServiceImpl();
        }
    }

    private final UserService componentUnderTest;

    @Test
    public void findOne() {
        // Arrange
        Long userId = 1L;

        // Act
        User user = this.componentUnderTest.findOne(userId);

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
        User user = this.componentUnderTest.findOne(userId);

        // Assert
        assertThat(user).isNull();
    }

    @Test
    public void findAllPlusAddInOneCaseNoProperMockingPossible() {
        // Act
        List<User> users = this.componentUnderTest.findAll();

        // Assert
        assertThat(users).isNotNull();
        assertThat(users).hasSize(2);

        // Act
        this.componentUnderTest.add();

        // Assert
        List<User> usersAfterMutations = this.componentUnderTest.findAll();
        assertThat(usersAfterMutations).isNotNull();
        assertThat(usersAfterMutations).hasSize(3);
    }
}
