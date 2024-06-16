package br.com.alura.literalura.desafio_literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record Resultados(@JsonAlias("titulo") String titulo,
                         @JsonAlias("autores") List<DadosAutor> autorList,
                         @JsonAlias("linguagem") List<String> linguagem,
                         @JsonAlias("contador_download") Integer numeroDownloads) {
}
