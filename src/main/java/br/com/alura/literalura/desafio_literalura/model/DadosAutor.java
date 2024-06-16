package br.com.alura.literalura.desafio_literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor (@JsonAlias("nome") String nomeAutor,
                          @JsonAlias("nascimento") Integer nascimento,
                          @JsonAlias("falecimento") Integer falecimento){
}
