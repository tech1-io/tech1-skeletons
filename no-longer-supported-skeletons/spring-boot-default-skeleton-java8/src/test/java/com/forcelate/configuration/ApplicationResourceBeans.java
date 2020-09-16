package com.forcelate.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.forcelate.resource")
@EnableWebMvc
public class ApplicationResourceBeans {
}
