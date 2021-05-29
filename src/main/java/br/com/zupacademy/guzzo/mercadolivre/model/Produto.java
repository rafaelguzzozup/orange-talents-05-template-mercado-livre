package br.com.zupacademy.guzzo.mercadolivre.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.guzzo.mercadolivre.controller.form.NovaCaracteristicaForm;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotNull
	@DecimalMin(value = "00.00", inclusive = false)
	@Positive
	private BigDecimal valor;

	@NotNull
	@Min(0)
	private Long quantidade;

	@NotBlank
	@Length(max = 1000)
	private String descricao;

	@NotNull
	@ManyToOne
	private Categoria categoria;

	@NotNull
	@ManyToOne
	private Usuario dono;

	@NotNull
	@Size(min = 3)
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private Set<CaracteristicaProduto> caracteristicas;

	// @NotNull
	// @Size(min = 1)
	@OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
	private Set<ImagemProduto> imagens = new HashSet<>();

	@Deprecated
	public Produto() {

	}

	public Produto(@NotBlank String nome, @NotNull @DecimalMin(value = "00.00", inclusive = false) BigDecimal valor,
			@NotNull @Min(0) Long quantidade, @NotBlank @Length(max = 1000) String descricao, Categoria categoria,
			Usuario dono, @Size(min = 3) Set<NovaCaracteristicaForm> caracteristicas) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.categoria = categoria;
		this.dono = dono;
		this.caracteristicas = caracteristicas.stream()
				.map(caracteristica -> caracteristica.converterParaCaracteristica(this)).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Set<CaracteristicaProduto> getCaracteristicas() {
		return caracteristicas;
	}

	public Usuario getDono() {
		return dono;
	}

	public void associaImagens(Set<String> imgs) {
		Set<ImagemProduto> imagens = imgs.stream().map(img -> new ImagemProduto(this, img)).collect(Collectors.toSet());
		this.imagens.addAll(imagens);
	}

}
