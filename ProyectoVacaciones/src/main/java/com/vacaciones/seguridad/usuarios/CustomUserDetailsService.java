package com.vacaciones.seguridad.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.repositorios.EmpleadoRepository;

/**
 * Servicio para obtener los detalles de un usuario del sistema
 * @author rafael.alonso.ext
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
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
