package br.com.zupacademy.guzzo.mercadolivre.controller.form;

public class NotaFiscalFakeForm {

	private Long idCompra;
	private Long idComprador;

	public NotaFiscalFakeForm(Long idCompra, Long idComprador) {
		super();
		this.idCompra = idCompra;
		this.idComprador = idComprador;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public Long getIdComprador() {
		return idComprador;
	}

	@Override
	public String toString() {
		return "NotaFiscalFakeForm [idCompra=" + idCompra + ", idComprador=" + idComprador + "]";
	}

}
