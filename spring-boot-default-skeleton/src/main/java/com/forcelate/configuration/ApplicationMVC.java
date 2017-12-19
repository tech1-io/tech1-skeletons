package com.forcelate.configuration;

import com.forcelate.properties.nested.Cors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Slf4j
@Configuration
@EnableWebMvc
public class ApplicationMVC extends WebMvcConfigurerAdapter {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        Cors cors = applicationProperties.getAppConfigs().getCors();
        if (cors.getEnabled()) {
            LOGGER.info("Spring configuration: CORS mappings enabled");
            registry.addMapping(cors.getPathPattern())
                    .allowedOrigins(cors.getAllowedOrigins())
                    .allowedMethods(cors.getAllowedMethods())
                    .exposedHeaders(cors.getExposedHeaders())
                    .allowCredentials(cors.getAllowCredentials());
        } else {
            LOGGER.info("Spring configuration: CORS mappings disabled");
        }
    }

}
