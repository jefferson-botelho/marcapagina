package com.marcapagina.aplicacao.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

import static com.marcapagina.aplicacao.comum.Utils.*;

@Data
public class Leitura {

    private int idUsuario;
    private int idLivro;
    private Livro livro;
    private RegistroPaginaLida ultimaPaginaLida;
    private List<RegistroPaginaLida> registroPaginaLida;
    private BigDecimal percentualLido;
    private LocalDateTime dataInicioLeitura;
    private LocalDateTime dataFimLeitura;
    private int ritmoLeitura;
    private LocalDate previsaoDeConclusao;

    @Builder
    public Leitura(
            @NonNull int idUsuario,
            @NonNull int idLivro,
            @NonNull Livro livro,
            List<RegistroPaginaLida> registroPaginaLida,
            @NonNull LocalDateTime dataInicioLeitura,
            LocalDateTime dataFimLeitura
    ) {
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.livro = livro;
        this.ultimaPaginaLida = retornarUltimoRegistroDePaginaLida(registroPaginaLida);
        this.registroPaginaLida = registroPaginaLida;
        this.percentualLido = calcularPercentualLido(this.livro.getQtdPaginas(), this.ultimaPaginaLida);
        this.dataInicioLeitura = dataInicioLeitura;
        this.dataFimLeitura = dataFimLeitura;
        this.ritmoLeitura = calcularRitmoDeLeitura(dataInicioLeitura, this.ultimaPaginaLida);
        this.previsaoDeConclusao = calcularPrevisaoDeConclusao(this.ritmoLeitura, this.livro.getQtdPaginas(), this.ultimaPaginaLida);
    }

    private RegistroPaginaLida retornarUltimoRegistroDePaginaLida(List<RegistroPaginaLida> registro) {
        Collections.sort(registro);
        return !registro.isEmpty() ? registro.get(registro.size() - 1) : null;
    }

    private BigDecimal calcularPercentualLido(int qtdPaginas, RegistroPaginaLida ultimoRegistro) {
        return calcularPercentual(qtdPaginas, ultimoRegistro.getUltimaPaginaLida());
    }

    private int calcularRitmoDeLeitura(LocalDateTime dataInicioLeitura, RegistroPaginaLida ultimoRegistro) {
        int qtdDiasLendo = (int) dataInicioLeitura.until(ultimoRegistro.getDataRegistro(), ChronoUnit.DAYS);
        int numeroUltimaPaginaLida = ultimoRegistro.getUltimaPaginaLida();

        return numeroUltimaPaginaLida / qtdDiasLendo;
    }

    private LocalDate calcularPrevisaoDeConclusao(int ritmoLeitura, int qtdPaginas, RegistroPaginaLida ultimoRegistro) {
        int paginasRestantes = qtdPaginas - ultimoRegistro.getUltimaPaginaLida();
        int previsaoEmDias = paginasRestantes / ritmoLeitura;

        return LocalDate.now().plusDays(previsaoEmDias);
    }
}
