package br.com.zupacademy.guzzo.mercadolivre.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class PerguntaProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	private LocalDateTime dataCriacao;

	@NotNull
	@ManyToOne
	private Produto produto;

	@NotNull
	@ManyToOne
	private Usuario usuario;

	@Deprecated
	public PerguntaProduto() {

	}

	public PerguntaProduto(@NotBlank String titulo, @NotNull Produto produto, @NotNull Usuario usuario) {
		this.titulo = titulo;
		this.produto = produto;
		this.usuario = usuario;
		this.dataCriacao = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Produto getProduto() {
		return produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
