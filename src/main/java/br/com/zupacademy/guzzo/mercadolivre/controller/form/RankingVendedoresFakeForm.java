package br.com.zupacademy.guzzo.mercadolivre.controller.form;

public class RankingVendedoresFakeForm {

	private Long idCompra;
	private Long idVendedor;

	public RankingVendedoresFakeForm(Long idCompra, Long idVendedor) {
		super();
		this.idCompra = idCompra;
		this.idVendedor = idVendedor;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	@Override
	public String toString() {
		return "RankingVendedoresFakeForm [idCompra=" + idCompra + ", idVendedor=" + idVendedor + "]";
	}

}
