package com.forcelate.configuration;

import com.forcelate.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class ApplicationServiceMockBeans {

    @Bean
    public UserService userService() {
        return mock(UserService.class);
    }
}
