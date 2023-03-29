package com.veterinaria.veterinariaback.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class JwtConfigurationTest {

    @InjectMocks
    private JwtConfiguration jwtConfiguration = new JwtConfiguration();

    @Test
    void testGetters() {
        jwtConfiguration.setUserNameField("username");
        jwtConfiguration.setConnectionTimeout(1000);
        jwtConfiguration.setReadTimeout(1000);
        jwtConfiguration.setHttpHeader("X-Custom-Auth");

        assertEquals("username", jwtConfiguration.getUserNameField());
        assertEquals(1000, jwtConfiguration.getConnectionTimeout());
        assertEquals(1000, jwtConfiguration.getReadTimeout());
        assertEquals("X-Custom-Auth", jwtConfiguration.getHttpHeader());
    }
}