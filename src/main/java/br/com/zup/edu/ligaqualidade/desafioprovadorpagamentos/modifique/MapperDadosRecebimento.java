package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimento;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MapperDadosRecebimento {

    //[status,valorOriginal,valorASerRecebidoDeFato,dataEsperadoRecebimento]
    private static final int STATUS_INDEX = 0;
    private static final int VALOR_ORGINAL_INDEX = 1;
    private static final int VALOR_RECEBIDO_INDEX = 2;
    private static final int DATA_RECEBIMENTO_INDEX = 3;

    /**
     *
     * @param infoRecebimento
     * @return
     */
    public static String[] map(DadosRecebimento infoRecebimento){
        String[] saida = new String[4];
        saida[STATUS_INDEX] = infoRecebimento.status;
        saida[VALOR_ORGINAL_INDEX] = infoRecebimento.valor.toString();
        saida[VALOR_RECEBIDO_INDEX] = infoRecebimento.valorRecebido.toString();
        saida[DATA_RECEBIMENTO_INDEX] = infoRecebimento.dataRecebimento.toString();
        return saida;
    }
}
