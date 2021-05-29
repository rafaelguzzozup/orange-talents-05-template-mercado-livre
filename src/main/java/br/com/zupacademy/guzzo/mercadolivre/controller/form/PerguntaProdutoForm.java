package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.guzzo.mercadolivre.model.PerguntaProduto;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;
import br.com.zupacademy.guzzo.mercadolivre.model.Usuario;

public class PerguntaProdutoForm {

	@NotBlank
	private String titulo;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PerguntaProdutoForm(@NotBlank String titulo) {
		this.titulo = titulo;
	}

	public PerguntaProduto converterParaPerguntaProduto(Produto produto, Usuario usuario) {
		return new PerguntaProduto(titulo, produto, usuario);
	}

}
