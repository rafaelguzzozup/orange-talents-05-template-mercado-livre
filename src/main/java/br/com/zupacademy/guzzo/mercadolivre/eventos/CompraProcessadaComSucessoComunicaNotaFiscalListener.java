package br.com.zupacademy.guzzo.mercadolivre.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.guzzo.mercadolivre.component.ServicoExternoFake;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.NotaFiscalFakeForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Compra;

@Component
public class CompraProcessadaComSucessoComunicaNotaFiscalListener
		implements ApplicationListener<CompraProcessadaComSucesso> {

	@Autowired
	private ServicoExternoFake servicoExternoFake;

	@Override
	public void onApplicationEvent(CompraProcessadaComSucesso event) {
		Compra compra = event.getCompra();
		String retornoNf = servicoExternoFake
				.notificaNotaFiscal(new NotaFiscalFakeForm(compra.getId(), compra.getComprador().getId()));

		System.out.println("Evento Comunica Nota Fiscal - retorno =" + retornoNf);

	}

}
