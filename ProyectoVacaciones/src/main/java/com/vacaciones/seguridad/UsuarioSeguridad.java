package com.vacaciones.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

/**
 * Clase de configuración para la seguridad de la aplicación
 * @author rafael.alonso.ext
 *
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class UsuarioSeguridad {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JWTAuthorizationFilter jAuthorF;
	
	
	/**
	 * @param http Parámetro para configurar los accesos y peticiones http
	 * @param authManager Gestor de autenticación
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		//Se crea un nuevo filtro de Autenticación y se asocia a login para tomar las credenciales
		JWTAuthenticationFilter jwtAuthen = new JWTAuthenticationFilter();
		jwtAuthen.setAuthenticationManager(authManager);
		jwtAuthen.setFilterProcessesUrl("/login");
	
		//Se deshabilita csrf, se hace que todas las peticiones sean con autenticación salvo la 
		//búsqueda de usuario en el login
		
		//Se filtran las peticiones por el gestor de Autenticación y el de Autorización
		return http
				.csrf().disable()
				.cors()
				.and()
				.authorizeHttpRequests()
				.requestMatchers("/empleados/find/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(jwtAuthen)
				.addFilterBefore(jAuthorF, UsernamePasswordAuthenticationFilter.class)
				.build();
		
		
	}
	
	/**
	 * Método para generar un manager de autenticación basado en user y password
	 * @param http Objeto de seguridad http
	 * @return La configuración http
	 * @throws Exception
	 */
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}
	
	/**
	 * Método auxiliar para codificar las contrasenas
	 * @return Codificador de contrasenas
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
