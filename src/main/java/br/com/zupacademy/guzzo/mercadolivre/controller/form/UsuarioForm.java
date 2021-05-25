package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.guzzo.mercadolivre.model.Usuario;

public class UsuarioForm {

	@NotNull
	@NotBlank
	@Email
	private String login;

	@NotNull
	@NotBlank
	@Size(min = 6)
	private String senha;
	
	
	
	public UsuarioForm(@NotNull @NotBlank @Email String login, @NotNull @NotBlank @Size(min = 6) String senha) {
		this.login = login;
		this.senha = senha;
	}



	public Usuario converterParaUsuario() {
		return new Usuario(login, senha);
	}

}
