package br.com.zupacademy.guzzo.mercadolivre.component;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploaderFake {

	public Set<String> envia(Set<MultipartFile> imagens) {
		return imagens.stream().map(imagem -> "http://www.sitefake.io/" + imagem.getOriginalFilename().replace("\s", "_"))
				.collect(Collectors.toSet());
	}

}
