package br.com.zupacademy.guzzo.mercadolivre.enuns;

public enum StatusGatewayPagSeguro implements StatusGatewayConverter {
	SUCESSO {
		@Override
		public StatusTransacao converterParaStatusTransacao() {
			return StatusTransacao.SUCESSO;
		}
	},
	ERRO {
		@Override
		public StatusTransacao converterParaStatusTransacao() {
			return StatusTransacao.FALHA;
		}
	};

}
