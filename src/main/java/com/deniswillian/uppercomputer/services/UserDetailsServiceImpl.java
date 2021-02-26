package com.deniswillian.uppercomputer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.security.UserSS;

// Class que implementa as regras de negocio relacionado ao contrato do Spring Security com UserDetail
//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private Funcionario repo;

	
	
	/*
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Preciso realizar a requisição para email
		Funcionario f1 = repo.findByEmail(email);
		if (f1 == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(f1.getCd_func(), f1.getEmail_func(), f1.getSenha(), f1.getPerfis());
	}
	*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
