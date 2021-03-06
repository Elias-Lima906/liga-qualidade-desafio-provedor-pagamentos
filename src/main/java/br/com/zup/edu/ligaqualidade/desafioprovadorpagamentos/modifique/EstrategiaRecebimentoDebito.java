package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;

public class EstrategiaRecebimentoDebito extends EstrategiaRecebimento {
    private static final String STATUS = "pago";

    @Override
    protected String getStatus() {
        return STATUS;
    }

    @Override
    protected BigDecimal getTaxa() {
        return new BigDecimal(0.1D);
    }

    @Override
    protected long getDiasParaRecebimento() {
        return 0L;
    }
}
