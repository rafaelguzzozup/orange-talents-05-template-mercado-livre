package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import br.com.zupacademy.guzzo.mercadolivre.enuns.StatusGatewayPagSeguro;
import br.com.zupacademy.guzzo.mercadolivre.model.Compra;
import br.com.zupacademy.guzzo.mercadolivre.model.RetornoGatewayForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Transacao;

public class PagseguroGatewayForm implements RetornoGatewayForm {

	private String idTransacao;
	private StatusGatewayPagSeguro status;

	public PagseguroGatewayForm(String idTransacao, StatusGatewayPagSeguro status) {
		super();

		this.idTransacao = idTransacao;
		this.status = status;
	}

	public Transacao converterParaTransacao(Compra compra) {
		return new Transacao(idTransacao, status.converterParaStatusTransacao(), compra);
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public StatusGatewayPagSeguro getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "PagseguroGatewayForm [idTransacao=" + idTransacao + ", status=" + status + "]";
	}

}
