package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import br.com.zupacademy.guzzo.mercadolivre.model.CaracteristicaProduto;
import br.com.zupacademy.guzzo.mercadolivre.model.Produto;

public class NovaCaracteristicaForm {

	private String nome;
	private String descricao;

	public NovaCaracteristicaForm(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public CaracteristicaProduto converterParaCaracteristica(Produto produto) {
		return new CaracteristicaProduto(nome, descricao, produto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NovaCaracteristicaForm other = (NovaCaracteristicaForm) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
