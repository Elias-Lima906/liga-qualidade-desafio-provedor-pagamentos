package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimento;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExecutorTransacao {

    private static EstrategiaRecebimentoDebito estrategiaRecebimentoDebito = new EstrategiaRecebimentoDebito();
    private static EstrategiaRecebimentoCredito estrategiaRecebimentoCredito = new EstrategiaRecebimentoCredito();

    private static Map<MetodoPagamento, EstrategiaRecebimento> resolver = new HashMap<>();

    {
        resolver.put(MetodoPagamento.DEBITO,estrategiaRecebimentoDebito);
        resolver.put(MetodoPagamento.CREDITO,estrategiaRecebimentoCredito);
    }


    public static List<DadosRecebimento> executar(List<String> infoTransacoes, List<String> infoAdiantamentos){
        List<DadosTransacao> listaDadosTransacao = infoTransacoes.stream().map(infoTransacao -> MapperDadosTransacao.map(infoTransacao)).collect(Collectors.toList());

        List<DadosRecebimento> retorno = new ArrayList<>();

        for (DadosTransacao dadosTransacao : listaDadosTransacao) {
            retorno.add(resolver.get(dadosTransacao.metodo).executar(dadosTransacao.valor,dadosTransacao.validade));
        }

        //TODO implementar adiantamento como nova Estratégia

        return retorno;

    }

}
