package br.com.zupacademy.guzzo.mercadolivre.controller.dto;

public class DetalheOpiniaoDto {

	private String titulo;
	private String descricao;

	public DetalheOpiniaoDto(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

}
