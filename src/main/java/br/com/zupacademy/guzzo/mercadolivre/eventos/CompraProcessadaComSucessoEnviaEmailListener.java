package br.com.zupacademy.guzzo.mercadolivre.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.guzzo.mercadolivre.component.Emails;

@Component
public class CompraProcessadaComSucessoEnviaEmailListener implements ApplicationListener<CompraProcessadaComSucesso> {

	@Autowired
	private Emails emails;

	@Override
	public void onApplicationEvent(CompraProcessadaComSucesso event) {
		emails.vendaComSucessoComprador(event.getCompra());
	}

}
