package io.tech1.properties.nested;

import lombok.Data;

@Data
public class Cors {
    private Boolean enabled;
    private String pathPattern;
    private String[] allowedOrigins;
    private String[] allowedMethods;
    private String[] allowedHeaders;
    private String[] exposedHeaders;
    private Boolean allowCredentials;
}
