package com.marcapagina.aplicacao.impl;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Slf4j
public class Imagem {

    public static void salvarImagem(long idImagem, String imagem) {
        byte[] imagemConvertida = converterImagem(imagem);
        File arquivo = montarArquivo(idImagem);
        try {
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(arquivo));
            outputStream.write(imagemConvertida);
        } catch (Exception e) {
            log.error("Erro ao salvar a imagem", e);
        }
    }

    private static byte[] converterImagem(String imagem) {
        return DatatypeConverter.parseBase64Binary(imagem);
    }

    private static File montarArquivo(long idImagem) {
        String path = "./src/main/resources/fotos/" + idImagem + ".jpg";
        return new File(path);
    }
}
