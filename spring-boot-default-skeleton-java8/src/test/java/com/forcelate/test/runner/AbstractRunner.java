package com.forcelate.test.runner;

import com.forcelate.properties.AppConfigs;
import com.forcelate.properties.nested.Cors;

public abstract class AbstractRunner {

    protected AppConfigs appConfigs() {
        AppConfigs appConfigs = new AppConfigs();
        // CORS
        Cors cors = new Cors();
        cors.setEnabled(true);
        appConfigs.setCors(cors);
        return appConfigs;
    }
}
