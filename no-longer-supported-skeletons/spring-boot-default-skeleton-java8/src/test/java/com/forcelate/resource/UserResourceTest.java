package com.forcelate.resource;

import com.forcelate.domain.User;
import com.forcelate.service.UserService;
import com.forcelate.test.InitializationUtils;
import com.forcelate.test.RandomUtils;
import com.forcelate.test.runner.ApplicationResourceRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserResourceTest extends ApplicationResourceRunner {

    // Services
    @Autowired private UserService userService;

    // Resource
    @Autowired private UserResource resourceUnderTest;

    @Before
    public void before() {
        beforeByResource(resourceUnderTest);
        reset(userService);
    }

    @After
    public void after() {
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void findOne() throws Exception {
        // Arrange
        User user = InitializationUtils.entity(User.class);
        Long userId = user.getId();
        when(userService.findOne(eq(userId))).thenReturn(user);

        // Act
        mvc.perform(get("/api/user/" + userId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Assert
        verify(userService).findOne(eq(userId));
    }

    @Test
    public void findAll() throws Exception {
        // Act
        mvc.perform(get("/api/user").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Assert
        verify(userService).findAll();
    }

    @Test
    public void add() throws Exception {
        // Act
        mvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Assert
        verify(userService).add();
    }
}
