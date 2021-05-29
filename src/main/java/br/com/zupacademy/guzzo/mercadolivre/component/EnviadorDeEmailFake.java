package br.com.zupacademy.guzzo.mercadolivre.component;

import org.springframework.stereotype.Component;

@Component
public class EnviadorDeEmailFake implements Mailer {

	@Override
	public void send(String corpo, String assunto, String nomeRemetente, String de, String para) {
		System.out.println(corpo);
		System.out.println(assunto);
		System.out.println(nomeRemetente);
		System.out.println(de);
		System.out.println(para);
	}

}
