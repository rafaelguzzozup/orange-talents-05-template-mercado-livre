package br.com.zupacademy.guzzo.mercadolivre.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.mercadolivre.controller.form.NotaFiscalFakeForm;
import br.com.zupacademy.guzzo.mercadolivre.controller.form.RankingVendedoresFakeForm;

@RestController
@RequestMapping("/api/fake")
public class ApiExternaFakeController {

	@PostMapping("/nota-fiscal")
	public String notaFiscal(@RequestBody NotaFiscalFakeForm form) {
		return form.toString();
	}

	@PostMapping("/ranking-vendedores")
	public String rankingVendedores(@RequestBody RankingVendedoresFakeForm form) {
		return form.toString();
	}

}
