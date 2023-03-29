package com.veterinaria.veterinariaback.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JwtIdTokenCredentialsHolderTest {

    @InjectMocks
    private JwtIdTokenCredentialsHolder jwtIdTokenCredentialsHolder;

    @Test
    public void setIdToken() {
        String idToken = "example_token";
        jwtIdTokenCredentialsHolder.setIdToken(idToken);
        Assertions.assertEquals(idToken,jwtIdTokenCredentialsHolder.getIdToken());
    }
}
