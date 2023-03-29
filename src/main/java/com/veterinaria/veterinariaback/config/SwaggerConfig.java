package com.veterinaria.veterinariaback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.veterinaria.veterinariaback.config.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Veterinaria XYZ API",
                "API de Veterinaria",
                "1.0",
                "https://veterinariaxyz.com",
                new Contact("Felipe Franco", "https://softcaribbean.com", "affranco@softcaribbean.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

    @Component
    public static class FiltrosCors extends GenericFilterBean {

        private static final String OPTIONS = "OPTIONS";


        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setHeader("Access-Control-Allow-Origin",
                    "*");
            httpResponse.setHeader("Access-Control-Allow-Credentials",
                    "true");
            httpResponse
                    .setHeader("Access-Control-Max-Age", "3600");
            httpResponse.setHeader("Access-Control-Allow-Methods",
                    "POST, GET, OPTIONS, DELETE, PUT");
            httpResponse.setHeader("Access-Control-Allow-Headers",
                    "x-requested-with, Content-Type, Authorization");

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            if (OPTIONS.equalsIgnoreCase(httpRequest.getMethod())) {
                httpResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                chain.doFilter(request, response);
            }
        }

    }
}
