package com.forcelate.properties.nested;

import lombok.Data;

@Data
public class Cors {
    private boolean enabled;
    private String pathPattern;
    private String[] allowedOrigins;
    private String[] allowedMethods;
    private String[] exposedHeaders;
    private boolean allowCredentials;
}
