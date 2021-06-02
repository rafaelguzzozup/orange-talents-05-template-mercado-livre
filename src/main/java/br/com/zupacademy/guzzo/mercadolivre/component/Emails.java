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

	public void vendaComSucessoComprador(Compra compra) {
		mailer.send("Ual!! vc comprou o super produto " + compra.getProduto().getNome() + " Parabens!!",
				"Compra efetuada com sucesso", "meumercadolivre", "meumercadolivre@teste.com",
				compra.getComprador().getLogin());
	}

	public void vendaSucessoComprador(Compra compra) {
		mailer.send(
				"Infelizmente ocorreu um problema com a sua compra acesse http://"
						+ compra.getTipoPagamento().getRedirect(compra.getUuid()),
				"Compra efetuada sem sucesso", "meumercadolivre", "meumercadolivre@teste.com",
				compra.getComprador().getLogin());
	}

}
