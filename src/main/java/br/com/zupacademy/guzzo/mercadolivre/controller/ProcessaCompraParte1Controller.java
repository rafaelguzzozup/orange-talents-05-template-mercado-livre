package br.com.zupacademy.guzzo.mercadolivre.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.guzzo.mercadolivre.component.Emails;
import br.com.zupacademy.guzzo.mercadolivre.config.security.UsuarioLogado;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.FinalizaCompraForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Compra;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;

@RestController
public class ProcessaCompraParte1Controller {

	@Autowired
	private Emails emails;

	@PersistenceContext
	private EntityManager em;

	@PostMapping("produtos/{id}/finaliza-compra")
	@Transactional
	public ResponseEntity<?> processaCompra(@PathVariable Long id, @RequestBody @Valid FinalizaCompraForm form,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {

		Produto produto = em.find(Produto.class, id);

		if (produto == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado com id " + id);
		}

		if ((produto.getQuantidade() - form.getQuantidade()) >= 0) {
			produto.abateEstoque(form.getQuantidade());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"A quantidade informada é superior que o produto possui! ");
		}

		Compra compra = form.converterParaCompra(produto, usuarioLogado.getUsuario());
		String urlRedirect = compra.getTipoPagamento().getRedirect(compra.getUuid());
		emails.novaVenda(compra);
		em.merge(produto);
		em.persist(compra);
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body(urlRedirect);

	}

}
