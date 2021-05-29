package br.com.zupacademy.guzzo.mercadolivre.component;

public interface Mailer {

	void send(String corpo, String assunto, String nomeRemetente, String de, String para);

}
