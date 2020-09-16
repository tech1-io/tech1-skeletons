package com.forcelate.resource;

import com.forcelate.utils.EnvironmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoResource implements InfoContributor {

    private final EnvironmentUtils environmentUtils;

    @Autowired
    public InfoResource(EnvironmentUtils environmentUtils) {
        this.environmentUtils = environmentUtils;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> details = new HashMap<>();
        details.put("activeProfiles", environmentUtils.getActiveProfiles());
        builder.withDetails(details);
    }
}
