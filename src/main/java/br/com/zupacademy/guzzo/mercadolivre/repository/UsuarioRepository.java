package br.com.zupacademy.guzzo.mercadolivre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.guzzo.mercadolivre.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String login);
}
