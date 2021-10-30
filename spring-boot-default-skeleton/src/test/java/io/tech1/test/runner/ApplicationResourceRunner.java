package io.tech1.test.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.tech1.configuration.ApplicationResourceBeans;
import io.tech1.configuration.ApplicationServiceMockBeans;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebAppConfiguration
@ExtendWith({ SpringExtension.class, MockitoExtension.class })
@ContextConfiguration(classes = {
        ApplicationResourceBeans.class,
        ApplicationServiceMockBeans.class
})
public abstract class ApplicationResourceRunner extends AbstractRunner {
    protected final ObjectMapper mapper = new ObjectMapper();

    protected MockMvc mvc;

    public void beforeByResource(Object object) {
        mvc = MockMvcBuilders
                .standaloneSetup(object)
                .build();
    }
}
