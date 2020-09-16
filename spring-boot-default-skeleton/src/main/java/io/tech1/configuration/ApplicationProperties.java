package io.tech1.configuration;

import io.tech1.properties.AppConfigs;
import io.tech1.properties.Logging;
import io.tech1.properties.Server;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

@ConfigurationProperties
@Data
public class ApplicationProperties implements PriorityOrdered {
    private Logging logging;
    private Server server;
    private AppConfigs appConfigs;

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
