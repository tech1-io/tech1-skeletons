package com.forcelate.configuration;

import com.forcelate.properties.nested.Cors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.CorsRegistry;

@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableWebFlux
public class ApplicationMVC implements WebFluxConfigurer {

    private final ApplicationProperties applicationProperties;

    @Bean
    public WebFluxConfigurer corsConfigurer(){
        return new WebFluxConfigurer() {
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
        };
    }
}
