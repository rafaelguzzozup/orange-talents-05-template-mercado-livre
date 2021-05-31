package br.com.zupacademy.guzzo.mercadolivre.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import br.com.zupacademy.guzzo.mercadolivre.enuns.StatusCompra;
import br.com.zupacademy.guzzo.mercadolivre.enuns.TipoPagamento;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@Positive
	@NotNull
	private Integer quantidade;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;

	@Enumerated(EnumType.STRING)
	private StatusCompra status;

	private BigDecimal precoProdutoUnitario;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Usuario comprador;

	public Compra(Produto produto, Usuario comprador, @Positive Integer quantidade, TipoPagamento tipoPagamento) {

		this.produto = produto;
		this.comprador = comprador;
		this.quantidade = quantidade;
		this.tipoPagamento = tipoPagamento;

		this.uuid = UUID.randomUUID();
		this.status = StatusCompra.INICIADA;
		this.precoProdutoUnitario = produto.getValor();
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Long getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public StatusCompra getStatus() {
		return status;
	}

	public BigDecimal getPrecoProdutoUnitario() {
		return precoProdutoUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	public Usuario getComprador() {
		return comprador;
	}

}
