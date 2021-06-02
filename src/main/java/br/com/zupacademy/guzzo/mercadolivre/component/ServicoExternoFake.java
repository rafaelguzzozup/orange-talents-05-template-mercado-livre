package br.com.zupacademy.guzzo.mercadolivre.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zupacademy.guzzo.mercadolivre.controller.form.NotaFiscalFakeForm;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.RankingVendedoresFakeForm;
import feign.Headers;

@FeignClient(url = "localhost:8080/api/fake/", name = "api-fake")
public interface ServicoExternoFake {

	@PostMapping(value = "/nota-fiscal")
	@Headers("Content-Type: application/json")
	String notificaNotaFiscal(@RequestBody NotaFiscalFakeForm form);
	
	
	@PostMapping(value = "/ranking-vendedores")
	@Headers("Content-Type: application/json")
	String notificaRankingVendedores(@RequestBody RankingVendedoresFakeForm form);
}
