package br.com.zupacademy.guzzo.mercadolivre.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.mercadolivre.config.security.UsuarioLogado;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.NovoProdutoForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid NovoProdutoForm form, @AuthenticationPrincipal UsuarioLogado usuario) {
		Produto produto = form.converterParaProduto(em);
		em.persist(produto);
	}

}
