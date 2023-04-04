package com.vacaciones.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login")
					.allowedOrigins("http://localhost:4200")
					.allowedMethods("*")
					.allowedHeaders("*");
				
				registry.addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("*");
			}
		};
	}
}
