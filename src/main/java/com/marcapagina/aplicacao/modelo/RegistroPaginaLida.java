package com.marcapagina.aplicacao.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
public class RegistroPaginaLida implements Comparable<RegistroPaginaLida> {

    @NonNull private Integer idUsuario;
    @NonNull private Integer idLivro;
    @NonNull private Integer ultimaPaginaLida;
    @NonNull private LocalDateTime dataRegistro;

    @Override
    public int compareTo(RegistroPaginaLida registro) {
        return this.dataRegistro.compareTo(registro.dataRegistro);
    }
}
