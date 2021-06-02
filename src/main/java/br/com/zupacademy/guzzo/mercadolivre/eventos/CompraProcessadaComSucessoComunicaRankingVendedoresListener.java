package br.com.zupacademy.guzzo.mercadolivre.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.guzzo.mercadolivre.component.ServicoExternoFake;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.RankingVendedoresFakeForm;
import br.com.zupacademy.guzzo.mercadolivre.model.Compra;

@Component
public class CompraProcessadaComSucessoComunicaRankingVendedoresListener
		implements ApplicationListener<CompraProcessadaComSucesso> {

	@Autowired
	private ServicoExternoFake servicoExternoFake;

	@Override
	public void onApplicationEvent(CompraProcessadaComSucesso event) {
		Compra compra = event.getCompra();
		String retornoApi = servicoExternoFake.notificaRankingVendedores(
				new RankingVendedoresFakeForm(compra.getId(), compra.getProduto().getDono().getId()));
		System.out.println("Evento Comunica Ranking Vendedores - retorno =" + retornoApi);
	}

}
