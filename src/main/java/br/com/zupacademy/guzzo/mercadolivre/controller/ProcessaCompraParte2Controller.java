package br.com.zupacademy.guzzo.mercadolivre.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.guzzo.mercadolivre.controller.form.PagseguroGatewayForm;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.PaypalGatewayForm;
import br.com.zupacademy.guzzo.mercadolivre.eventos.CompraProcessadaComSucesso;
import br.com.zupacademy.guzzo.mercadolivre.eventos.CompraProcessadaSemSucesso;
import br.com.zupacademy.guzzo.mercadolivre.model.Compra;
import br.com.zupacademy.guzzo.mercadolivre.model.RetornoGatewayForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Transacao;
import br.com.zupacademy.guzzo.mercadolivre.repository.CompraRepository;

@RestController
@RequestMapping("/processa-compra")
public class ProcessaCompraParte2Controller {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@PersistenceContext
	private EntityManager em;

	@PostMapping("/pagseguro/{idCompra}")
	@Transactional
	public String processaCompraPagseguro(@PathVariable String idCompra,
			@RequestBody @Valid PagseguroGatewayForm form) {

		return processaCompra(idCompra, form);
	}

	@PostMapping("/paypal/{idCompra}")
	@Transactional
	public String processaCompraPaypal(@PathVariable String idCompra, @RequestBody @Valid PaypalGatewayForm form) {

		return processaCompra(idCompra, form);
	}

	private String processaCompra(String idCompra, RetornoGatewayForm form) {
		Compra compra = compraRepository.findByUuid(idCompra).get();
		Transacao transacao = form.converterParaTransacao(compra);

		if (compra.possuiTransacaoComSucesso() || compra.possuiTransacao(transacao)) {
			applicationEventPublisher.publishEvent(new CompraProcessadaSemSucesso(this, compra));

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Transação já processada ou compra já possui transação com sucesso !");

		}

		applicationEventPublisher.publishEvent(new CompraProcessadaComSucesso(this, compra));
		em.persist(transacao);
		return compra.toString();
	}

}
