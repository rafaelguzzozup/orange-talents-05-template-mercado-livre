package br.com.zupacademy.guzzo.mercadolivre.enuns;

public enum TipoPagamento {
	PAGSEGURO {
		@Override
		public String getRedirect(String uuid) {
			return "pagseguro.com?returnId={" + uuid.toString() + "}&redirectUrl={urlRetornoAppPosPagamento}";
		}
	},
	PAYPAL {
		@Override
		public String getRedirect(String uuid) {
			return "paypal.com?buyerId={" + uuid.toString() + "}&redirectUrl={urlRetornoAppPosPagamento}";
		}
	};

	public abstract String getRedirect(String uuid);

}
