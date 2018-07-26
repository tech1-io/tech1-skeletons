package com.forcelate.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EnvironmentUtils {

    private final Environment environment;

    @Autowired
    public EnvironmentUtils(Environment environment) {
        this.environment = environment;
    }

    public List<String> getActiveProfiles() {
        return Arrays.asList(this.environment.getActiveProfiles());
    }
}
