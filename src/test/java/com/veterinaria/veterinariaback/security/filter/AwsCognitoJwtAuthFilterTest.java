package com.veterinaria.veterinariaback.security.filter;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.proc.BadJOSEException;
import com.veterinaria.veterinariaback.security.AwsCognitoIdTokenProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class AwsCognitoJwtAuthFilterTest {

    @Test
    void doFilter() throws ServletException, IOException, ParseException, BadJOSEException, JOSEException {
        String invalidToken = "invalid_token";
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        AwsCognitoIdTokenProcessor cognitoIdTokenProcessor = mock(AwsCognitoIdTokenProcessor.class);
        when(cognitoIdTokenProcessor.authenticate(request)).thenThrow(new BadJOSEException("Invalid token"));
        AwsCognitoJwtAuthFilter filter = new AwsCognitoJwtAuthFilter(cognitoIdTokenProcessor);

        filter.doFilter(request, response, filterChain);

        verify(cognitoIdTokenProcessor, times(1)).authenticate(request);
        verify(filterChain, times(1)).doFilter(request, response);
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }

    @Test
    public void testDoFilterNextFilter() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        AwsCognitoIdTokenProcessor cognitoIdTokenProcessor = mock(AwsCognitoIdTokenProcessor.class);
        AwsCognitoJwtAuthFilter filter = new AwsCognitoJwtAuthFilter(cognitoIdTokenProcessor);

        filter.doFilter(request, response, filterChain);

        verify(filterChain, times(1)).doFilter(request, response);
    }
}