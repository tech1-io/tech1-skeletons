package io.tech1.properties;

import io.tech1.properties.nested.Cors;
import io.tech1.properties.nested.SecureConfig;
import lombok.Data;

@Data
public class AppConfigs {
    private Cors cors;
    private SecureConfig secureConfig;
}
