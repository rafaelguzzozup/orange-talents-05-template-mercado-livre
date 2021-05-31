package br.com.zupacademy.guzzo.mercadolivre.compartilhado;

import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.zupacademy.guzzo.mercadolivre.model.OpiniaoProduto;

public class Opinioes {
	private Set<OpiniaoProduto> opinioes;

	public Opinioes(Set<OpiniaoProduto> opinioesProduto) {
		this.opinioes = opinioesProduto;

	}

	// <T> -> representa o tipo, Set<T> representa o retorno
	public <T> Set<T> mapeiaOpinioes(Function<OpiniaoProduto, T> funcaoMapeadora) {
		return this.opinioes.stream().map(funcaoMapeadora).collect(Collectors.toSet());

	}

	public Double getMediaNotas() {
		OptionalDouble mediaNotas = this.opinioes.stream().mapToDouble(opiniao -> opiniao.getNota()).average();
		return mediaNotas.orElse(0.0);
	}

	public Integer getTotalNotas() {
		return this.opinioes.size();
	}

}
