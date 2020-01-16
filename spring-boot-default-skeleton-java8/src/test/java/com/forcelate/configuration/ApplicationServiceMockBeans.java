package com.forcelate.configuration;

import com.forcelate.service.UserService;
import com.forcelate.utils.EnvironmentUtils;
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
