package br.com.zupacademy.guzzo.mercadolivre.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.guzzo.mercadolivre.component.GeradorDeSenhaUsuario;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Email
	@Column(unique = true)
	private String login;

	@NotNull
	@NotBlank
	@Size(min = 6)
	private String senha;

	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Deprecated
	public Usuario() {

	}

	public Usuario(@NotNull @NotBlank @Email String login, @NotNull @NotBlank @Size(min = 6) String senha) {
		this.login = login;
		this.senha = GeradorDeSenhaUsuario.geradorSenha(senha);
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

}
