package br.com.zupacademy.guzzo.mercadolivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.mercadolivre.config.security.TokenManager;
import br.com.zupacademy.guzzo.mercadolivre.controller.dto.TokenDto;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenManager tokenManager;

	@PostMapping("/token")
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {

		try {

			UsernamePasswordAuthenticationToken dadosLogin = form.converter();
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			String token = tokenManager.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));

		} catch (AuthenticationException ex) {
			return ResponseEntity.badRequest().build();
		}

	}
}
