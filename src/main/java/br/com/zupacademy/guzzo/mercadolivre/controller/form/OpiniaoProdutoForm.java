package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.guzzo.mercadolivre.model.OpiniaoProduto;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;
import br.com.zupacademy.guzzo.mercadolivre.model.Usuario;

public class OpiniaoProdutoForm {

	@Min(1)
	@Max(5)
	private Long nota;

	@NotBlank
	private String titulo;

	@NotBlank
	@Length(max = 500)
	private String descricao;

	public OpiniaoProdutoForm(@Min(1) @Max(5) Long nota, @NotBlank String titulo, @NotBlank String descricao) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public OpiniaoProduto converterParaOpiniaoProduto(Produto produto, Usuario usuario) {
		return new OpiniaoProduto(nota, titulo, descricao, produto, usuario);
	}
}
