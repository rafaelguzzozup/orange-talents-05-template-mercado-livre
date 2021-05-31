package br.com.zupacademy.guzzo.mercadolivre.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.guzzo.mercadolivre.controller.dto.DetalheProdutoDto;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;

@RestController
public class DetalheProdutoController {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@GetMapping("/produtos/{id}/detalhe")
	public DetalheProdutoDto detalhesDoProduto(@PathVariable Long id) {
		Produto produto = em.find(Produto.class, id);

		if (produto == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado com id " + id);
		}

		return new DetalheProdutoDto(produto);
	}
}
