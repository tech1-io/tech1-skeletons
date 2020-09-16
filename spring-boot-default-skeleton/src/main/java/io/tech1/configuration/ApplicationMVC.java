package io.tech1.configuration;

import io.tech1.properties.nested.Cors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static java.util.Arrays.asList;

@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableWebMvc
public class ApplicationMVC implements WebMvcConfigurer {

    private final ApplicationProperties applicationProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        Cors cors = applicationProperties.getAppConfigs().getCors();
        if (cors.getEnabled()) {
            LOGGER.info("Spring configuration: CORS mappings enabled");

            LOGGER.info("CORS, pathPatter `{}`", cors.getPathPattern());
            LOGGER.info("CORS, allowedOrigins `{}`", asList(cors.getAllowedOrigins()));
            LOGGER.info("CORS, allowedMethods `{}`", asList(cors.getAllowedMethods()));
            LOGGER.info("CORS, allowedHeaders `{}`", asList(cors.getAllowedHeaders()));
            LOGGER.info("CORS, exposedHeaders `{}`", asList(cors.getExposedHeaders()));
            LOGGER.info("CORS, allowCredentials `{}`", cors.getAllowCredentials());

            registry.addMapping(cors.getPathPattern())
                    .allowedOrigins(cors.getAllowedOrigins())
                    .allowedMethods(cors.getAllowedMethods())
                    .allowedHeaders(cors.getAllowedHeaders())
                    .exposedHeaders(cors.getExposedHeaders())
                    .allowCredentials(cors.getAllowCredentials());
        } else {
            LOGGER.info("Spring configuration: CORS mappings disabled");
        }
    }
}

