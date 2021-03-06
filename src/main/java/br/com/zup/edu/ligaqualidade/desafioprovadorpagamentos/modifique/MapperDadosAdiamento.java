package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;

public class MapperDadosAdiamento {

	private static final int ID_TRANSACAO_INDEX = 0;
	private static final int TAXA_VALOR_ADIANTAMENTO_INDEX = 1;

	public static DadosRecebimentoAdiantado map(String infoAdiantamento) {
		if (infoAdiantamento == null || infoAdiantamento.isEmpty()) {
			throw new IllegalArgumentException("infoTransacao nao pode ser vazio");
		}
		String[] info = infoAdiantamento.split(",");
		if (info.length != 2) {
			throw new IllegalArgumentException("infoTransacao esta mal formatada");
		}

		return new DadosRecebimentoAdiantado(
				Integer.parseInt(info[ID_TRANSACAO_INDEX]),
				new BigDecimal(info[TAXA_VALOR_ADIANTAMENTO_INDEX])
		);
	}
}
