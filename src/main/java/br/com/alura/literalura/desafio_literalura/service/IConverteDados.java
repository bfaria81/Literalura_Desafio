package br.com.alura.literalura.desafio_literalura.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> tClass);
}
