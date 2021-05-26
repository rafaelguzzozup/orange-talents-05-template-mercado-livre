package br.com.zupacademy.guzzo.mercadolivre.component;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeSenhaUsuario {
	public static String geradorSenha(String senha) {
		return new BCryptPasswordEncoder().encode(senha);
	}
}
