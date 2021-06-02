package br.com.zupacademy.guzzo.mercadolivre.eventos;

import org.springframework.context.ApplicationEvent;

import br.com.zupacademy.guzzo.mercadolivre.model.Compra;

public class CompraProcessadaComSucesso extends ApplicationEvent {

	private Compra compra;

	public CompraProcessadaComSucesso(Object source, Compra compra) {
		super(source);
		this.compra = compra;
	}

	public Compra getCompra() {
		return compra;
	}

}
