package br.com.zupacademy.guzzo.mercadolivre.component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class GeradorDeSenhaUsuario {
	public static String geradorSenha(String senha) {
		MessageDigest md;
		String myHash = senha;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] digest = md.digest();
			myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return myHash;

	}
}
