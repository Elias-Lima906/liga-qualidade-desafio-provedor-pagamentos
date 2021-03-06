package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimento;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Interface de Estrategia (Strategy Pattern) para Recebiveis
 */
public abstract class EstrategiaRecebimento {



    /**
     *
     * @param valor
     * @param data
     * @return
     */
    public DadosRecebimento executar(BigDecimal valor, LocalDate data){
        return new DadosRecebimento(getStatus(), valor, getValorAposDesconto(valor), data.plusDays(getDiasParaRecebimento()));
    }

    private BigDecimal getValorAposDesconto(BigDecimal valorOriginal){
        return valorOriginal.multiply(getTaxa());
    }

    protected abstract String getStatus();
    protected abstract BigDecimal getTaxa();
    protected abstract long getDiasParaRecebimento();
}
