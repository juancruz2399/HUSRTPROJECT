package com.HUSRTbdBiomedica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.HUSRTbdBiomedica.app.Dao.IUsuarioDao;
import com.HUSRTbdBiomedica.app.entity.Usuario;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao UsuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String cedula) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = UsuarioDao.findByCedula(cedula);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return new CustomUserDetails(usuario);
	}
	

}
