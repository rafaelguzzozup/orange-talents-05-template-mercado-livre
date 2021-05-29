package br.com.zupacademy.guzzo.mercadolivre.component;

import org.springframework.stereotype.Component;

import br.com.zupacademy.guzzo.mercadolivre.model.PerguntaProduto;

@Component
public class EnviadorDeEmailFake {

	public void enviaEmailPerguntaProduto(PerguntaProduto perguntaProduto) {
		System.out.println("Enviando email para o vendedor! " + perguntaProduto.getProduto().getDono().getLogin());
		System.out.println("Contato: " + perguntaProduto.getUsuario().getLogin());
		System.out.println("Assunto: " + perguntaProduto.getTitulo());

	}
}
