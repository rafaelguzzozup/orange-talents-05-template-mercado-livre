package br.com.zupacademy.guzzo.mercadolivre.model;

public interface RetornoGatewayForm {
	Transacao converterParaTransacao(Compra compra);
}
