package br.com.zupacademy.guzzo.mercadolivre.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.zupacademy.guzzo.mercadolivre.compartilhado.Opinioes;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;

public class DetalheProdutoDto {

	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Set<String> imagens;
	private Set<String> perguntas;
	//private List<DetalheCaracteristicasDto> caracteristicas;
	private Set<Map<String,String>> caracteristicas;
	
	private Double mediaNotas;
	private Integer totalNotas;
	private Set<DetalheOpiniaoDto> opinioes;

	public DetalheProdutoDto(Produto produto) {
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getValor();

		this.imagens = produto.mapeiaImagens(imagen -> imagen.getLink());
		
		this.perguntas = produto.mapeiaPerguntas(pergunta -> pergunta.getTitulo());

		this.caracteristicas = produto.mapeiaCaracteristicas(caracteristica -> {
			return Map.of("nome", caracteristica.getNome(), "descricao", caracteristica.getDescricao());
		});

		//this.caracteristicas = produto.getCaracteristicas().stream().map(caracteristica -> new DetalheCaracteristicasDto(caracteristica.getNome(), caracteristica.getDescricao())) .collect(Collectors.toList());
	
		Opinioes opinioes = new Opinioes(produto.getOpinioes());
		this.mediaNotas = opinioes.getMediaNotas();
		this.totalNotas = opinioes.getTotalNotas();
		this.opinioes = opinioes
				.mapeiaOpinioes(opiniao -> new DetalheOpiniaoDto(opiniao.getTitulo(), opiniao.getDescricao()));
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

	public Set<String> getImagens() {
		return imagens;
	}

	public Set<String> getPerguntas() {
		return perguntas;
	}

	public Set<Map<String, String>> getCaracteristicas() {
		return caracteristicas;
	}

	public Double getMediaNotas() {
		return mediaNotas;
	}

	public Integer getTotalNotas() {
		return totalNotas;
	}

	public Set<DetalheOpiniaoDto> getOpinioes() {
		return opinioes;
	}

}
