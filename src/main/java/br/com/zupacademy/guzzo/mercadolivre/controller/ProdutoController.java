package br.com.zupacademy.guzzo.mercadolivre.controller;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.guzzo.mercadolivre.component.UploaderFake;
import br.com.zupacademy.guzzo.mercadolivre.config.security.UsuarioLogado;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.NovaImagemForm;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.NovoProdutoForm;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.OpiniaoProdutoForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UploaderFake uploaderFake;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid NovoProdutoForm form,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {
		Produto produto = form.converterParaProduto(em, usuarioLogado.getUsuario());
		em.persist(produto);
	}

	@PostMapping("/{id}/imagens")
	@Transactional
	public void cadastrarImagemProduto(@PathVariable Long id, @Valid NovaImagemForm form,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {

		Produto produto = validaProdutoIdUrl(id);

		if (!produto.getUsuario().equals(usuarioLogado.getUsuario())) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Este produto não pertece ao usuário informado!");
		}

		Set<String> imgs = uploaderFake.envia(form.getImagens());
		produto.associaImagens(imgs);
		em.merge(produto);
	}

	@PostMapping("/{id}/opiniao")
	@Transactional
	public void cadastrarOpiniao(@PathVariable Long id,@Valid @RequestBody OpiniaoProdutoForm form,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {

		Produto produto = validaProdutoIdUrl(id);
		em.persist(form.converterParaOpiniaoProduto(produto, usuarioLogado.getUsuario()));

	}

	@Transactional
	private Produto validaProdutoIdUrl(Long id) {
		Produto produto = em.find(Produto.class, id);

		if (produto == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado com id " + id);
		}

		return produto;
	}

}
