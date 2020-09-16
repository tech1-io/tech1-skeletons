package io.tech1.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("io.tech1.resource")
@EnableWebMvc
public class ApplicationResourceBeans {
}
