package com.vacaciones.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuración para el CORS (Cross Origin Resource Sharing)
 * permite la comunicación entre backend y frontend
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@Configuration
public class AppConfig {

	/**
	 * Método que retorna un WebMvcConfigurer, usado para la gestión de CORS 
	 * y cabeceras permitidas y expuestas en diferentes orígeners
	 * @return WebMvcConfigurer
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login")
					.allowedOrigins("http://localhost:4200")
					.allowedMethods("*")
					.exposedHeaders("*");
				
				registry.addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("*")
				.allowedHeaders("*");
			}
		};
	}
}
