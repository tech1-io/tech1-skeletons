package com.forcelate.properties;

import com.forcelate.properties.nested.Cors;
import com.forcelate.properties.nested.SecureConfig;
import lombok.Data;

@Data
public class AppConfigs {
    private Cors cors;
    private SecureConfig secureConfig;
}
