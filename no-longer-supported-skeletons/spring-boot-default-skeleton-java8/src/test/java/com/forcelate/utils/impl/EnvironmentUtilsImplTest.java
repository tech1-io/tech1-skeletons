package com.forcelate.utils.impl;

import com.forcelate.utils.EnvironmentUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static com.forcelate.test.RandomUtils.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class EnvironmentUtilsImplTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        Environment environment() {
            return mock(Environment.class);
        }

        @Bean
        EnvironmentUtils environmentUtils() {
            return new EnvironmentUtilsImpl(environment());
        }
    }

    @Autowired private Environment environment;

    @Autowired private EnvironmentUtils componentUnderTest;

    @Test
    public void getActiveProfiles() {
        // Arrange
        Integer size = randomSmallInteger();
        String[] expectedActualProfiles = randomArrayOfStrings(size);
        when(environment.getActiveProfiles()).thenReturn(expectedActualProfiles);

        // Act
        List<String> actualActiveProfiles = componentUnderTest.getActiveProfiles();

        // Assert
        assertThat(actualActiveProfiles).isEqualTo(asList(expectedActualProfiles));
    }

    @Test
    public void isDevelopmentModeTrue() {
        // Arrange
        String profile1 = "dev";
        String profile2 = randomString();
        String profile3 = randomString();
        String[] profiles = { profile1, profile2, profile3 };
        when(environment.getActiveProfiles()).thenReturn(profiles);

        // Act
        boolean developmentMode = componentUnderTest.isDevelopmentMode();

        // Assert
        assertThat(developmentMode).isTrue();
    }

    @Test
    public void isDevelopmentModeFalse() {
        // Arrange
        String profile1 = randomString();
        String profile2 = randomString();
        String profile3 = randomString();
        String[] profiles = { profile1, profile2, profile3 };
        when(environment.getActiveProfiles()).thenReturn(profiles);

        // Act
        boolean developmentMode = componentUnderTest.isDevelopmentMode();

        // Assert
        assertThat(developmentMode).isFalse();
    }

    @Test
    public void isProductionModeTrue() {
        // Arrange
        String profile1 = "prod";
        String profile2 = randomString();
        String profile3 = randomString();
        String[] profiles = { profile1, profile2, profile3 };
        when(environment.getActiveProfiles()).thenReturn(profiles);

        // Act
        boolean productionMode = componentUnderTest.isProductionMode();

        // Assert
        assertThat(productionMode).isTrue();
    }

    @Test
    public void isProductionModeFalse() {
        // Arrange
        String profile1 = randomString();
        String profile2 = randomString();
        String profile3 = randomString();
        String[] profiles = { profile1, profile2, profile3 };
        when(environment.getActiveProfiles()).thenReturn(profiles);

        // Act
        boolean productionMode = componentUnderTest.isProductionMode();

        // Assert
        assertThat(productionMode).isFalse();
    }
}
