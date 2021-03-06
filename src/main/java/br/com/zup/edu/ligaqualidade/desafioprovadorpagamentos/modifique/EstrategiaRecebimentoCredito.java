package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;

public class EstrategiaRecebimentoCredito extends EstrategiaRecebimento {

    private static final String STATUS = "aguardando_liberacao_fundos";

    @Override
    protected String getStatus() {
        return STATUS;
    }

    @Override
    protected BigDecimal getTaxa() {
        return new BigDecimal(0.3D);
    }

    @Override
    protected long getDiasParaRecebimento() {
        return 30L;
    }
}
