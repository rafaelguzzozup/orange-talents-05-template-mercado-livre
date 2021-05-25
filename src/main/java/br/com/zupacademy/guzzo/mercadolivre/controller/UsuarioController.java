package br.com.zupacademy.guzzo.mercadolivre.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.mercadolivre.controller.form.UsuarioForm;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@Valid @RequestBody UsuarioForm form) {
		entityManager.persist(form.converterParaUsuario());
		return ResponseEntity.ok().build();
	}
}
