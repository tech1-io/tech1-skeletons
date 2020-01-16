package com.forcelate.test.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcelate.configuration.ApplicationResourceBeans;
import com.forcelate.configuration.ApplicationServiceMockBeans;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
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
