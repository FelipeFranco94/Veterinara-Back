/*
package com.veterinaria.veterinariaback.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

class FiltrosCorsTest {

    private FiltrosCors filtrosCors;
    private MockHttpServletRequest mockRequest;
    private MockHttpServletResponse mockResponse;
    private FilterChain filterChain;

    @BeforeEach
    void setUp() {
        filtrosCors = new FiltrosCors();
        mockRequest = new MockHttpServletRequest();
        mockResponse = new MockHttpServletResponse();
        filterChain = new MockFilterChain();
    }

    @Test
    void doFilter_ShouldSetCorsHeaders() throws IOException, ServletException {
        filtrosCors.doFilter(mockRequest, mockResponse, filterChain);
        assertThat(mockResponse.getHeader("Access-Control-Allow-Origin")).isEqualTo("*");
        assertThat(mockResponse.getHeader("Access-Control-Allow-Credentials")).isEqualTo("true");
        assertThat(mockResponse.getHeader("Access-Control-Max-Age")).isEqualTo("3600");
        assertThat(mockResponse.getHeader("Access-Control-Allow-Methods")).isEqualTo("POST, GET, OPTIONS, DELETE, PUT");
        assertThat(mockResponse.getHeader("Access-Control-Allow-Headers")).isEqualTo("x-requested-with, Content-Type, Authorization");
    }
}*/
