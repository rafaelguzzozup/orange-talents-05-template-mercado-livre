package br.com.zupacademy.guzzo.mercadolivre.component;

import org.springframework.stereotype.Component;

@Component
public class EnviadorDeEmailFake implements Mailer {

	@Override
	public void send(String corpo, String assunto, String nomeRemetente, String de, String para) {
		System.out.println("corpo =" + corpo);
		System.out.println("assunto =" + assunto);
		System.out.println("nomeRemetente =" + nomeRemetente);
		System.out.println("de =" + de);
		System.out.println("para =" + para);
	}

}
