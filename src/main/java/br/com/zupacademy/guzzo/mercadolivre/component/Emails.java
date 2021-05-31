package br.com.zupacademy.guzzo.mercadolivre.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zupacademy.guzzo.mercadolivre.model.Compra;
import br.com.zupacademy.guzzo.mercadolivre.model.PerguntaProduto;

@Service
public class Emails {

	@Autowired
	private Mailer mailer;

	public void novaPergunta(PerguntaProduto pergunta) {
		mailer.send("<html>...</html>", "Nova pergunta...", pergunta.getUsuario().getLogin(), "novapergunta@teste.com",
				pergunta.getDonoProduto().getLogin());
	}

	public void novaVenda(Compra compra) {
		mailer.send("<html>...</html>", "Nova Venda...", compra.getComprador().getLogin(), "novapergunta@teste.com",
				compra.getProduto().getDono().getLogin());
	}
}
