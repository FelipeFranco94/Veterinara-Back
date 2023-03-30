package com.veterinaria.veterinariaback;

import com.veterinaria.veterinariaback.config.SwaggerConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class VeterinariaBackApplicationTests {

	@InjectMocks
	private VeterinariaBackApplication veterinariaBackApplication;

	@Mock
	private FilterRegistrationBean<SwaggerConfig.FiltrosCors> filterRegistrationBean;

	@Test
	public void testCorsFilterRegistration() {
		VeterinariaBackApplication application = new VeterinariaBackApplication();
		FilterRegistrationBean<SwaggerConfig.FiltrosCors> registrationBean = application.corsFilterRegistration();

		assertNotNull(registrationBean);
		assertEquals(registrationBean, registrationBean);
		assertArrayEquals(new String[] {"/*"}, registrationBean.getUrlPatterns().toArray());
		assertEquals(Ordered.HIGHEST_PRECEDENCE, registrationBean.getOrder());
	}
}