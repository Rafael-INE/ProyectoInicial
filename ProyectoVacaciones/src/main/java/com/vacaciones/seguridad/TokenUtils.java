package com.vacaciones.seguridad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.vacaciones.repositorios.EmpleadoRepository;
import com.vacaciones.seguridad.usuarios.CustomUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	private final static String ACCESS_TOKEN_SECRET = "DHUSN2KSOSKnsuwksoanduwni129nn82";
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
	@Autowired
	static EmpleadoRepository empleadoRepository;

	public static String createToken(String nombre, String email, List<SimpleGrantedAuthority> authList) {
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		System.out.println("AUTORIDADES" + authList);
		List<String> lista = new ArrayList<>();
		for(SimpleGrantedAuthority rol: authList) {
			lista.add(rol.getAuthority().toString());
		}
		Map<String, Object> extra = new HashMap<>();
		extra.put("roles", lista);

		return Jwts.builder().setSubject(email).setExpiration(expirationDate).addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())).compact();
	}

	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		try {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
				.build()
				.parseClaimsJws(token)
				.getBody();
		
		String email = claims.getSubject();
		List<String> rolesEntrada= (List<String>) claims.get("roles");
		List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		for(String rol: rolesEntrada) {
			roles.add(new SimpleGrantedAuthority(rol));
		}
		return new UsernamePasswordAuthenticationToken(email, null, roles);
		
		}catch(JwtException e){
			return null;
		}
		
		}
	}
