package br.com.zupacademy.guzzo.mercadolivre.controller.form;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NovaImagemForm {

	@NotNull
	@Size(min = 1)
	private Set<MultipartFile> imagens = new HashSet<>();

	public void setImagens(Set<MultipartFile> imagens) {
		this.imagens = imagens;
	}

	public Set<MultipartFile> getImagens() {
		return this.imagens;
	}

}
