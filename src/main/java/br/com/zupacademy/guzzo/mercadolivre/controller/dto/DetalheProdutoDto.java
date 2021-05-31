package br.com.zupacademy.guzzo.mercadolivre.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.guzzo.mercadolivre.compartilhado.Opinioes;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;

public class DetalheProdutoDto {

	private String nome;
	private String descricao;
	private BigDecimal preco;
	private List<String> imagens;
	private List<String> perguntas;
	private List<DetalheCaracteristicasDto> caracteristicas;

	private Double mediaNotas;
	private Integer totalNotas;
	private List<DetalheOpiniaoDto> opinioes;

	public DetalheProdutoDto(Produto produto) {
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getValor();

		this.imagens = produto.getImagens().stream().map(imagen -> imagen.getLink()).collect(Collectors.toList());
		this.perguntas = produto.getPerguntas().stream().map(pergunta -> pergunta.getTitulo())
				.collect(Collectors.toList());
		this.caracteristicas = produto.getCaracteristicas().stream()
				.map(caracteristica -> new DetalheCaracteristicasDto(caracteristica.getNome(),
						caracteristica.getDescricao()))
				.collect(Collectors.toList());

		Opinioes opinioes = new Opinioes(produto.getOpinioes());
		this.mediaNotas = opinioes.getMediaNotas();
		this.totalNotas = opinioes.getTotalNotas();
		this.opinioes = opinioes.getOpinioes();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public List<String> getImagens() {
		return imagens;
	}

	public List<String> getPerguntas() {
		return perguntas;
	}

	public List<DetalheCaracteristicasDto> getCaracteristicas() {
		return caracteristicas;
	}

	public Double getMediaNotas() {
		return mediaNotas;
	}

	public Integer getTotalNotas() {
		return totalNotas;
	}

	public List<DetalheOpiniaoDto> getOpinioes() {
		return opinioes;
	}

}
