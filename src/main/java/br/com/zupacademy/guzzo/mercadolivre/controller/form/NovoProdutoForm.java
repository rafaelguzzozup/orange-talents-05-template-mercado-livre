package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.guzzo.mercadolivre.model.Categoria;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;
import br.com.zupacademy.guzzo.mercadolivre.validator.ExisteId;

public class NovoProdutoForm {

	@NotBlank
	private String nome;

	@NotNull
	@DecimalMin(value = "00.00", inclusive = false)
	private BigDecimal valor;

	@NotNull
	@Min(0)
	private Long quantidade;

	@NotBlank
	@Length(max = 1000)
	private String descricao;

	@NotNull
	@ExisteId(entidade = Categoria.class, atributo = "id")
	private Long idCategoria;

	@Size(min = 3)
	private Set<NovaCaracteristicaForm> caracteristicas;

	public NovoProdutoForm(@NotBlank String nome,
			@NotNull @DecimalMin(value = "00.00", inclusive = false) BigDecimal valor, @NotNull @Min(0) Long quantidade,
			@NotBlank @Length(max = 1000) String descricao, @NotNull Long idCategoria,
			@Size(min = 3) Set<NovaCaracteristicaForm> caracteristicas) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.idCategoria = idCategoria;
		this.caracteristicas = caracteristicas;
	}
	
	public Produto converterParaProduto(EntityManager em) {
		Categoria categoria = em.find(Categoria.class, idCategoria);
		return new Produto(nome, valor, quantidade, descricao, categoria, caracteristicas);
	}

	@Override
	public String toString() {
		return "NovoProdutoForm [nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + ", descricao="
				+ descricao + ", idCategoria=" + idCategoria + ", caracteristicas=" + caracteristicas + "]";
	}

}
