package br.com.zupacademy.guzzo.mercadolivre.enuns;

import java.util.UUID;

public enum TipoPagamento {
	PAGSEGURO {
		@Override
		public String getRedirect(UUID uuid) {
			return "pagseguro.com?returnId={" + uuid.toString() + "}&redirectUrl={urlRetornoAppPosPagamento}";
		}
	},
	PAYPAL {
		@Override
		public String getRedirect(UUID uuid) {
			return "paypal.com?buyerId={" + uuid.toString() + "}&redirectUrl={urlRetornoAppPosPagamento}";
		}
	};

	public abstract String getRedirect(UUID uuid);

}
