package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimento;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

public class ExecutorTransacao {

	private static EstrategiaRecebimentoDebito estrategiaRecebimentoDebito = new EstrategiaRecebimentoDebito();
	private static EstrategiaRecebimentoCredito estrategiaRecebimentoCredito = new EstrategiaRecebimentoCredito();

	private static Map<MetodoPagamento, EstrategiaRecebimento> resolver = new HashMap<>();

	{
		resolver.put(MetodoPagamento.DEBITO, estrategiaRecebimentoDebito);
		resolver.put(MetodoPagamento.CREDITO, estrategiaRecebimentoCredito);
	}

	public static List<DadosRecebimento> executar(List<String> infoTransacoes, List<String> infoAdiantamentos) {
		List<DadosTransacao> listaDadosTransacao = infoTransacoes.stream()
				.map(infoTransacao -> MapperDadosTransacao.map(infoTransacao)).collect(Collectors.toList());
		List<DadosRecebimentoAdiantado> dadosRecebimentoAdiantado = infoAdiantamentos.stream()
				.map(infoAdiantamento -> MapperDadosAdiamento.map(infoAdiantamento)).collect(Collectors.toList());

		List<DadosRecebimento> retorno = new ArrayList<>();

		List<DadosTransacao> dadosALteradosComAdiantamento = ExecutorAdiantamento.executar(listaDadosTransacao,
				dadosRecebimentoAdiantado);

		for (DadosTransacao dadosComAdiantamento : listaDadosTransacao) {
			retorno.add(resolver.get(dadosComAdiantamento.metodo).executar(dadosComAdiantamento.valor,
					dadosComAdiantamento.validade));
		}

		return retorno;

	}

}
