package com.forcelate.utils.impl;

import com.forcelate.utils.EnvironmentUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnvironmentUtilsImpl implements EnvironmentUtils {
    private static final String PROFILE_DEVELOPMENT = "dev";
    private static final String PROFILE_PRODUCTION = "prod";

    private final Environment environment;

    @Override
    public List<String> getActiveProfiles() {
        return Arrays.asList(this.environment.getActiveProfiles());
    }

    @Override
    public boolean isDevelopmentMode() {
        return isMode(PROFILE_DEVELOPMENT);
    }

    @Override
    public boolean isProductionMode() {
        return isMode(PROFILE_PRODUCTION);
    }

    // ================================================================================================================
    // Private Methods
    // ================================================================================================================
    private boolean isMode(String mode) {
        List<String> activeProfiles = getActiveProfiles();
        if (Objects.nonNull(activeProfiles)) {
            String activeProfile = activeProfiles.get(0);
            return Objects.nonNull(activeProfile) && activeProfile.equalsIgnoreCase(mode);
        } else {
            return false;
        }
    }
}
