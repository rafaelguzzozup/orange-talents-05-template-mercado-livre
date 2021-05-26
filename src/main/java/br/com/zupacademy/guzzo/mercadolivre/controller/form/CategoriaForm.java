package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.guzzo.mercadolivre.model.Categoria;
import br.com.zupacademy.guzzo.mercadolivre.validator.ExisteId;
import br.com.zupacademy.guzzo.mercadolivre.validator.UnicoRegistro;

public class CategoriaForm {

	@NotBlank
	@UnicoRegistro(entidade = Categoria.class, atributo = "nome")
	private String nome;

	@ExisteId(entidade = Categoria.class, atributo = "id")
	private Long idCategoriaMae;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaForm(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public Categoria converterParaCategoria() {
		return new Categoria(nome);
	}
	
	public Long getIdCategoriaMae() {
		return idCategoriaMae;
	}

}
