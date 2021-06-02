package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import br.com.zupacademy.guzzo.mercadolivre.enuns.StatusGatewayPayPal;
import br.com.zupacademy.guzzo.mercadolivre.model.Compra;
import br.com.zupacademy.guzzo.mercadolivre.model.RetornoGatewayForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Transacao;

public class PaypalGatewayForm implements RetornoGatewayForm {
	private String idTransacao;
	private StatusGatewayPayPal status;

	public PaypalGatewayForm(String idCompra, String idTransacao, StatusGatewayPayPal status) {
		super();
		this.idTransacao = idTransacao;
		this.status = status;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public StatusGatewayPayPal getStatus() {
		return status;
	}

	public Transacao converterParaTransacao(Compra compra) {
		return new Transacao(idTransacao, status.converterParaStatusTransacao(), compra);
	}

	@Override
	public String toString() {
		return "PaypalGatewayForm [idTransacao=" + idTransacao + ", status=" + status + "]";
	}

}
