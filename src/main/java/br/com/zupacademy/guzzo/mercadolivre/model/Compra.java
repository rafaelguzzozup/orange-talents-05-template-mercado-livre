package br.com.zupacademy.guzzo.mercadolivre.model;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import br.com.zupacademy.guzzo.mercadolivre.enuns.StatusCompra;
import br.com.zupacademy.guzzo.mercadolivre.enuns.StatusTransacao;
import br.com.zupacademy.guzzo.mercadolivre.enuns.TipoPagamento;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String uuid;

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

	@OneToMany(mappedBy = "compra")
	private Set<Transacao> transacoes;

	@Deprecated
	public Compra() {

	}

	public Compra(Produto produto, Usuario comprador, @Positive Integer quantidade, TipoPagamento tipoPagamento) {

		this.produto = produto;
		this.comprador = comprador;
		this.quantidade = quantidade;
		this.tipoPagamento = tipoPagamento;

		this.uuid = UUID.randomUUID().toString();
		this.status = StatusCompra.INICIADA;
		this.precoProdutoUnitario = produto.getValor();
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public String getUuid() {
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

	public Set<Transacao> getTransacoes() {
		return transacoes;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", uuid=" + uuid + ", quantidade=" + quantidade + ", tipoPagamento=" + tipoPagamento
				+ ", status=" + status + ", precoProdutoUnitario=" + precoProdutoUnitario + ", produto=" + produto
				+ ", comprador=" + comprador + ", transacoes=" + transacoes + "]";
	}

	public boolean possuiTransacaoComSucesso() {
		long TransacaoComSucesso = this.transacoes.stream()
				.filter(transacao -> transacao.getStatus().equals(StatusTransacao.SUCESSO)).count();
		return TransacaoComSucesso > 0 ? true : false;
	}

	public boolean possuiTransacao(Transacao transacao) {
		return this.transacoes.contains(transacao);
	}

}
