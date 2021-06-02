package br.com.zupacademy.guzzo.mercadolivre.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusGatewayPayPal implements StatusGatewayConverter {
	SUCESSO(1) {
		@Override
		public StatusTransacao converterParaStatusTransacao() {
			return StatusTransacao.SUCESSO;
		}
	},
	FALHA(0) {
		@Override
		public StatusTransacao converterParaStatusTransacao() {
			return StatusTransacao.FALHA;
		}
	};

	private int status;

	private StatusGatewayPayPal(int status) {
		this.status = status;
	}

	@JsonValue
	public int getStatus() {
		return status;
	}

	@JsonCreator
	public static StatusGatewayPayPal getStatusConvertido(int status) {
		for (StatusGatewayPayPal statusGatewayPayPal : StatusGatewayPayPal.values()) {
			if (statusGatewayPayPal.status == status) {
				return statusGatewayPayPal;
			}
		}

		throw new IllegalArgumentException("Não encontrado constant que referencia o valor =" + status);
	}

}
