package com.marcapagina.aplicacao.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@AllArgsConstructor
public class Imagem {

    public String dir;

    public void salvarImagem(long idImagem, String imagem) {
        String[] splitBase64 = imagem.split(",");
        File arquivo = montarArquivo(idImagem, splitBase64);
        byte[] imagemByte = DatatypeConverter.parseBase64Binary(splitBase64[1]);

        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(arquivo))){
            outputStream.write(imagemByte);
        } catch (Exception e) {
            log.error("Erro ao salvar a imagem", e);
        }
    }


    private File montarArquivo(long idImagem, String[] imagem) {
        String extensao;
        switch (imagem[0]) {
            case "data:image/jpeg;base64":
                extensao = ".jpeg";
                break;
            case "data:image/png;base64":
                extensao = ".png";
                break;
            default:
                extensao = ".jpg";
                break;
        }

        Path caminhoDasFotos = Paths.get(dir);

        if (!Files.exists(caminhoDasFotos)) {
            try {
                Files.createDirectories(caminhoDasFotos);
            } catch (IOException ex) {
                throw new IllegalStateException("Erro ao tentar criar diretório " + dir, ex);
            }
        }

        String path = dir + "/" + idImagem + extensao;
        return new File(path);
    }
}
