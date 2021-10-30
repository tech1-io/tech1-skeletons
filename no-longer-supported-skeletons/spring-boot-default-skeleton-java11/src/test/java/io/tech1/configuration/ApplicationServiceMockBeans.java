package io.tech1.configuration;

import io.tech1.service.UserService;
import io.tech1.utils.EnvironmentUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class ApplicationServiceMockBeans {

    // Services
    @Bean
    public UserService userService() {
        return mock(UserService.class);
    }

    // Utils
    @Bean
    public EnvironmentUtils environmentUtils() {
        return mock(EnvironmentUtils.class);
    }
}
