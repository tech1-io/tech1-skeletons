package com.forcelate.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@ComponentScan("com.forcelate.resource")
@EnableWebFlux
public class ApplicationResourceBeans {
}
