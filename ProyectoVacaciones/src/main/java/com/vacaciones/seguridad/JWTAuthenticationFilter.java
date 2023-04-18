package com.vacaciones.seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vacaciones.seguridad.usuarios.CustomUserDetailsImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Clase para la gestión de la autenticación en el sistema basado en 
 * usuario y contrasena y con el uso de bearer tokens con JWT
 * @author rafael.alonso.ext
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	/**
	 * Este método intenta la autenticación en el sistema leyendo las credenciales
	 * del objeto request recibido
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// Creacion de credenciales de Autorización
		AuthCredentials authCredentials = new AuthCredentials();
		
		try {
			//Obtención de valores de autenticación desde el objeto request
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
		}
		catch(IOException e){
			
		}
		//Creación de un token basado en las credenciales de tipo usuario y contrasena
		UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
				authCredentials.getEmail(),
				authCredentials.getPassword(),
				authCredentials.getAuthorities());
		//Intento de autenticación
		return getAuthenticationManager().authenticate(usernamePAT);
	}

	/**
	 * Este método se ejecutará si las credenciales de usuario resultaron ser válidas,
	 * creará un Bearer token basado en dichas credenciales
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//Se crea un objeto de detalles de usuario basado en los resultados de la autenticación previa
		CustomUserDetailsImpl cudi = (CustomUserDetailsImpl)authResult.getPrincipal();
		List<SimpleGrantedAuthority> authList = (ArrayList<SimpleGrantedAuthority>)cudi.getAuthorities();
		//Se genera un token basado en los detalles y se agrega a las cabeceras como un bearer token 
		String token = TokenUtils.createToken(cudi.getName(), cudi.getUsername(), authList);
		response.addHeader("Authorization", "Bearer " + token);
		response.getWriter().flush();
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
}
