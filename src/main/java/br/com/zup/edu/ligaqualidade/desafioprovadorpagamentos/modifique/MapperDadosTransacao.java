package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MapperDadosTransacao {

    private static final int VALOR_INDEX = 0;
    private static final int METODO_PAGAMENTO_INDEX = 1;
    private static final int NUMERO_CARTAO_INDEX = 2;
    private static final int NOME_CARTAO_INDEX = 3;
    private static final int VALIDADE_INDEX = 4;
    private static final int CVV_INDEX = 5;
    private static final int ID_TRANSACAO_INDEX = 6;

    /**
     *
     * @param infoTransacao
     * @return
     */
    public static DadosTransacao map(String infoTransacao){
        if(infoTransacao == null || infoTransacao.isEmpty()){
            throw new IllegalArgumentException("infoTransacao nao pode ser vazio");
        }
        String[] info = infoTransacao.split(",");
        if(info.length != 7){
            throw new IllegalArgumentException("infoTransacao esta mal formatada");
        }
        return new DadosTransacao(
                new BigDecimal(info[VALOR_INDEX]),
                MetodoPagamento.valueOf(info[METODO_PAGAMENTO_INDEX]),
                info[NUMERO_CARTAO_INDEX],
                info[NOME_CARTAO_INDEX],
                LocalDate.parse(info[VALIDADE_INDEX], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                Integer.parseInt(info[CVV_INDEX]),
                Integer.parseInt(info[ID_TRANSACAO_INDEX])
        );
    }
}
