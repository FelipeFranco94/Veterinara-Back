package com.veterinaria.veterinariaback;

import com.veterinaria.veterinariaback.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@EnableCaching
@EnableWebMvc
public class VeterinariaBackApplication  {


	public static void main(String[] args) {
		SpringApplication.run(VeterinariaBackApplication.class);
	}

	@Bean
	public FilterRegistrationBean<SwaggerConfig.FiltrosCors> corsFilterRegistration() {
		FilterRegistrationBean<SwaggerConfig.FiltrosCors> registrationBean = new FilterRegistrationBean<>(new SwaggerConfig.FiltrosCors());
		registrationBean.setName("filtros CORS");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return registrationBean;
	}
}
