package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	@NotBlank
	@Email
	private String login;

	@NotBlank
	private String senha;

	public LoginForm(@NotBlank @Email String login, @NotBlank String senha) {
		this.login = login;
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, senha);
	}

}
