package com.vacaciones.seguridad.usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.repositorios.EmpleadoRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final EmpleadoRepository empleadoRepository;
	
	public CustomUserDetailsService(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Empleado empleado = empleadoRepository.findByEmail(username);
		if(empleado==null) {
			throw new UsernameNotFoundException("No encontrado");
		}
		return new CustomUserDetailsImpl(empleado);
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_"+empleado.getRol().getDescripcion()));
//		return new User(empleado.getEmail(), empleado.getContrasena(), authorities);
	}

}
