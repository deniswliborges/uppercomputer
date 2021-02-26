package com.deniswillian.uppercomputer.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.deniswillian.uppercomputer.enums.Perfil;

// Class muito importante pois implementa o UserDetails que atende o contrato do Spring Security
public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSS() {
	}

	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	// Validando a coleção de Autorização
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	// Validando a senha
	@Override
	public String getPassword() {
		return senha;
	}

	// Validando o email
	@Override
	public String getUsername() {
		return email;
	}

	// Validando se a conta não esta expirada
	@Override
	public boolean isAccountNonExpired() {
		// Nesta parte podemos criar os metodos com as regras de negócio relacionado ao tempo de expiração da conta
		return true;
	}

	// Validando se a conta esta Bloqueada
	@Override
	public boolean isAccountNonLocked() {
		// Nesta parte podemos criar os metodos com as regras de negócio relacionado para conta ficar Bloqueada
		return true;
	}

	// Validando se a credencial não esta expirada
	@Override
	public boolean isCredentialsNonExpired() {
		// Nesta parte podemos criar os metodos com as regras de negócio relacionado se as credenciais não estão expiradas
		return true;
	}

	// Validando se o user esta ativo/Habilitado
	@Override
	public boolean isEnabled() {
		// Nesta parte podemos criar os metodos com as regras de negócio relacionado ao colaborador que não esta ativo na empresa
		return true;
	}
	
	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
