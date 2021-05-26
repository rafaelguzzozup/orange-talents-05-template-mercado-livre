package br.com.zupacademy.guzzo.mercadolivre.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.zupacademy.guzzo.mercadolivre.model.Usuario;
import br.com.zupacademy.guzzo.mercadolivre.repository.UsuarioRepository;

@Component
public class UsersService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Usuario usuario = usuarioRepository.findByLogin(username)
				.orElseThrow(() -> new UsernameNotFoundException("Dados inválidos!"));

		return new UsuarioLogado(usuario);
	}

}
