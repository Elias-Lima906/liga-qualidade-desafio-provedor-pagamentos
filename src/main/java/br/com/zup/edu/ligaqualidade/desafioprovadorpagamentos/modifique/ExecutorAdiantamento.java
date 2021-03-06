package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.util.List;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public class ExecutorAdiantamento {

	public static List<DadosTransacao> executar(List<DadosTransacao> listaDadosTransacao,
			List<DadosRecebimentoAdiantado> dadosRecebimentoAdiantado) {

		for (int i = 0; i <= listaDadosTransacao.size(); i++) {
			for (int j = 0; j <= i; j++) {

				if (dadosRecebimentoAdiantado.get(j).idTransacao == listaDadosTransacao.get(i).id) {
					DadosTransacao transacao = listaDadosTransacao.get(i);
					transacao = new DadosTransacao(transacao.valor, transacao.metodo.DEBITO, transacao.numero,
							transacao.nome, transacao.validade.minusDays(30), transacao.cvv, transacao.id);
				}
			}
		}
		
		return listaDadosTransacao;
	}
}
