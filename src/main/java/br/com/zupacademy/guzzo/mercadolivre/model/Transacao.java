package br.com.zupacademy.guzzo.mercadolivre.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.guzzo.mercadolivre.enuns.StatusTransacao;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idTransacao;

	@Enumerated(EnumType.STRING)
	private StatusTransacao status;
	private LocalDateTime dataTransacao;

	@ManyToOne
	private Compra compra;

	@Deprecated
	public Transacao() {

	}

	public Transacao(String idTransacao, StatusTransacao status, Compra compra) {
		this.idTransacao = idTransacao;
		this.status = status;
		this.compra = compra;
		this.dataTransacao = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", idTransacao=" + idTransacao + ", status=" + status + ", dataTransacao="
				+ dataTransacao + "]";
	}

	public Long getId() {
		return id;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public StatusTransacao getStatus() {
		return status;
	}

	public LocalDateTime getDataTransacao() {
		return dataTransacao;
	}

	public Compra getCompra() {
		return compra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTransacao == null) ? 0 : idTransacao.hashCode());
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
		Transacao other = (Transacao) obj;
		if (idTransacao == null) {
			if (other.idTransacao != null)
				return false;
		} else if (!idTransacao.equals(other.idTransacao))
			return false;
		return true;
	}

}
