package com.marcapagina.aplicacao.comum;

import com.marcapagina.aplicacao.exception.ExcecaoDeNegocio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    public static BigDecimal calcularPercentual(Integer valorReferencia, Integer valorASerCalculado) {
        if (valorReferencia == null || valorASerCalculado == null) {
            throw new ExcecaoDeNegocio(
                    String.format(
                            "Valores não podem ser nulos. Valor Referência: %d. Valor a ser calculado: %d.",
                            valorReferencia,
                            valorASerCalculado
                    )
            );
        }

        BigDecimal total = BigDecimal.valueOf(valorReferencia);
        BigDecimal valor = BigDecimal.valueOf(valorASerCalculado);
        BigDecimal cem = BigDecimal.valueOf(100);

        return valor.divide(total, RoundingMode.HALF_EVEN).multiply(cem);
    }
}
