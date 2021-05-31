package br.com.zupacademy.guzzo.mercadolivre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class OpiniaoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Min(1)
	@Max(5)
	private Long nota;

	@NotBlank
	private String titulo;

	@NotBlank
	@Length(max = 500)
	private String descricao;

	@NotNull
	@ManyToOne
	private Produto produto;

	@NotNull
	@ManyToOne
	private Usuario usuario;

	@Deprecated
	public OpiniaoProduto() {

	}

	public OpiniaoProduto(@Min(1) @Max(5) Long nota, @NotBlank String titulo, @NotBlank String descricao,
			Produto produto, Usuario usuario) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.produto = produto;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public Long getNota() {
		return nota;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Produto getProduto() {
		return produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
