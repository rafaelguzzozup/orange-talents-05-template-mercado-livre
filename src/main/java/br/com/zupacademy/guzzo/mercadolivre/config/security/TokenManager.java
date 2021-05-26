package br.com.zupacademy.guzzo.mercadolivre.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenManager {

	@Value("${mercadolivre.jwt.expiration}")
	private String expiration;

	@Value("${mercadolivre.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authenticate) {

		UserDetails logado = (UserDetails) authenticate.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

		return Jwts.builder()
				.setIssuer("Api desafio Mercado livre")
				.setSubject(logado.getUsername())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getUsername(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return String.valueOf(claims.getSubject());
	}

}
