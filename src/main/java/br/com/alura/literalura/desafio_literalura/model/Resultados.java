package br.com.alura.literalura.desafio_literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Resultados(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") List<DadosAutor> autorList,
                         @JsonAlias("languages") List<String> linguagem,
                         @JsonAlias("subjects") List<String> genero,
                         @JsonAlias("download_count") Integer numeroDownloads) {
}
