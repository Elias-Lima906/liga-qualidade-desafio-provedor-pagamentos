package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DadosRecebimento {
	public final String status;
	public final BigDecimal valor;
	public final BigDecimal valorRecebido;
	public final LocalDate dataRecebimento;

	public DadosRecebimento(String status, BigDecimal valor, BigDecimal valorRecebido, LocalDate dataRecebimento  ) {
		this.status = status;
		this.valor = valor;
		this.valorRecebido  = valorRecebido;
		this.dataRecebimento = dataRecebimento;
	}

}
