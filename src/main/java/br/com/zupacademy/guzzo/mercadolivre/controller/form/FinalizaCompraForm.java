package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import br.com.zupacademy.guzzo.mercadolivre.enuns.TipoPagamento;
import br.com.zupacademy.guzzo.mercadolivre.model.Compra;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;
import br.com.zupacademy.guzzo.mercadolivre.model.Usuario;

public class FinalizaCompraForm {
	@Positive
	@NotNull
	private Integer quantidade;

	@NotNull
	private TipoPagamento tipoPagamento;

	public FinalizaCompraForm(Integer quantidade, TipoPagamento tipoPagamento) {
		this.quantidade = quantidade;
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public Compra converterParaCompra(Produto produto, Usuario comprador) {
		return new Compra(produto, comprador, quantidade, tipoPagamento);
	}

}
