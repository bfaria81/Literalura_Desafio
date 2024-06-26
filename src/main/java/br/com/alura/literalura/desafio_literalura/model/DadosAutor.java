package br.com.alura.literalura.desafio_literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor (@JsonAlias("name") String nomeAutor,
                          @JsonAlias("birth_year") Integer nascimento,
                          @JsonAlias("death_year") Integer falecimento){
}
