package br.com.zupacademy.guzzo.mercadolivre.controller.dto;

public class DetalheCaracteristicasDto {

	private String nome;
	private String descricao;

	public DetalheCaracteristicasDto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
