package com.forcelate.utils;

import java.util.List;

public interface EnvironmentUtils {
    List<String> getActiveProfiles();
    boolean isDevelopmentMode();
    boolean isProductionMode();
}
