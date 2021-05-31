package br.com.zupacademy.guzzo.mercadolivre.compartilhado;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.zupacademy.guzzo.mercadolivre.controller.dto.DetalheOpiniaoDto;
import br.com.zupacademy.guzzo.mercadolivre.model.OpiniaoProduto;

public class Opinioes {
	private List<DetalheOpiniaoDto> opinioes;
	private Double mediaNotas;
	private Integer totalNotas;

	public Opinioes(Set<OpiniaoProduto> opinioesProduto) {
		this.opinioes = opinioesProduto.stream()
				.map(opiniao -> new DetalheOpiniaoDto(opiniao.getTitulo(), opiniao.getDescricao()))
				.collect(Collectors.toList());

		OptionalDouble notas = opinioesProduto.stream().mapToDouble(opiniao -> opiniao.getNota()).average();
		if (notas.isPresent()) {
			this.mediaNotas = notas.getAsDouble();
		}

		this.totalNotas = opinioesProduto.size();
	}

	public List<DetalheOpiniaoDto> getOpinioes() {
		return opinioes;
	}

	public Double getMediaNotas() {
		return mediaNotas;
	}

	public Integer getTotalNotas() {
		return totalNotas;
	}

}
