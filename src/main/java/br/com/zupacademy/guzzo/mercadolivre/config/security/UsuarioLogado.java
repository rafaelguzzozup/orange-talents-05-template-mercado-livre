package br.com.zupacademy.guzzo.mercadolivre.config.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.zupacademy.guzzo.mercadolivre.model.Usuario;

public class UsuarioLogado implements UserDetails {

	private Usuario usuario;
	private User springUserDetails;

	public UsuarioLogado(Usuario usuario) {
		this.usuario = usuario;
		this.springUserDetails = new User(usuario.getLogin(), usuario.getSenha(), List.of());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return springUserDetails.getAuthorities();
	}

	@Override
	public String getPassword() {
		return springUserDetails.getPassword();
	}

	@Override
	public String getUsername() {
		return springUserDetails.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
