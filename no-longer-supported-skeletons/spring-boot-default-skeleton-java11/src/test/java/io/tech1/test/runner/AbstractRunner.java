package io.tech1.test.runner;

import io.tech1.properties.AppConfigs;
import io.tech1.properties.nested.Cors;

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
