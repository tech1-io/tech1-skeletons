package io.tech1.utils.impl;

import io.tech1.utils.EnvironmentUtils;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static io.tech1.test.RandomUtils.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith({ SpringExtension.class, MockitoExtension.class })
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
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

    private final Environment environment;
    private final EnvironmentUtils componentUnderTest;

    @BeforeEach
    void before() {
        reset(this.environment);
    }

    @AfterEach
    void after() {
        verifyNoMoreInteractions(this.environment);
    }

    @Test
    public void getActiveProfiles() {
        // Arrange
        Integer size = randomSmallInteger();
        String[] expectedActualProfiles = randomArrayOfStrings(size);
        when(this.environment.getActiveProfiles()).thenReturn(expectedActualProfiles);

        // Act
        List<String> actualActiveProfiles = this.componentUnderTest.getActiveProfiles();

        // Assert
        verify(this.environment).getActiveProfiles();
        assertThat(actualActiveProfiles).isEqualTo(asList(expectedActualProfiles));
    }

    @Test
    public void isDevelopmentModeTrue() {
        // Arrange
        String profile1 = "dev";
        String profile2 = randomString();
        String profile3 = randomString();
        String[] profiles = { profile1, profile2, profile3 };
        when(this.environment.getActiveProfiles()).thenReturn(profiles);

        // Act
        boolean developmentMode = this.componentUnderTest.isDevelopmentMode();

        // Assert
        verify(this.environment).getActiveProfiles();
        assertThat(developmentMode).isTrue();
    }

    @Test
    public void isDevelopmentModeFalse() {
        // Arrange
        String profile1 = randomString();
        String profile2 = randomString();
        String profile3 = randomString();
        String[] profiles = { profile1, profile2, profile3 };
        when(this.environment.getActiveProfiles()).thenReturn(profiles);

        // Act
        boolean developmentMode = this.componentUnderTest.isDevelopmentMode();

        // Assert
        verify(this.environment).getActiveProfiles();
        assertThat(developmentMode).isFalse();
    }

    @Test
    public void isProductionModeTrue() {
        // Arrange
        String profile1 = "prod";
        String profile2 = randomString();
        String profile3 = randomString();
        String[] profiles = { profile1, profile2, profile3 };
        when(this.environment.getActiveProfiles()).thenReturn(profiles);

        // Act
        boolean productionMode = this.componentUnderTest.isProductionMode();

        // Assert
        verify(this.environment).getActiveProfiles();
        assertThat(productionMode).isTrue();
    }

    @Test
    public void isProductionModeFalse() {
        // Arrange
        String profile1 = randomString();
        String profile2 = randomString();
        String profile3 = randomString();
        String[] profiles = { profile1, profile2, profile3 };
        when(this.environment.getActiveProfiles()).thenReturn(profiles);

        // Act
        boolean productionMode = this.componentUnderTest.isProductionMode();

        // Assert
        verify(this.environment).getActiveProfiles();
        assertThat(productionMode).isFalse();
    }
}
