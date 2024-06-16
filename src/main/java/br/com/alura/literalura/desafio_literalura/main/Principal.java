package br.com.alura.literalura.desafio_literalura.main;

import br.com.alura.literalura.desafio_literalura.model.Autor;
import br.com.alura.literalura.desafio_literalura.model.DadosLivros;
import br.com.alura.literalura.desafio_literalura.model.Livro;
import br.com.alura.literalura.desafio_literalura.repository.AutorRepositorio;
import br.com.alura.literalura.desafio_literalura.repository.LivroRepositorio;
import br.com.alura.literalura.desafio_literalura.service.ConverteDados;
import br.com.alura.literalura.desafio_literalura.service.RequisicaoAPI;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private RequisicaoAPI requisicaoAPI = new RequisicaoAPI();
    private String urlAPI = "https://gutendex.com/books/";
    private ConverteDados converteDados = new ConverteDados();
    private AutorRepositorio autorRepositorio;
    private LivroRepositorio livroRepositorio;
    private List<Livro> livros;
    private List<Autor> autores;

    public Principal(LivroRepositorio livroRepositorio, AutorRepositorio autorRepositorio){
        this.autorRepositorio = autorRepositorio;
        this.livroRepositorio = livroRepositorio;
    }

    public void showMenu(){

        var opcao = -1;
        while (opcao != 0){
            var menu = """
                    ***-----------------------------***
                       Buscadoe de Livres Literalura   
                    ***-----------------------------***
                    
                    Selecione uma opção:
                    
                    1 - Buscar um livro 
                    2 - Consultar livros buscados
                    3 - Consultar autores
                    4 - Consultar autores de um ano específico
                    5 - Consulta livros por linguagem
                    
                    0 - Sair
                    """;
            try{
                System.out.println(menu);
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e){
                System.out.println("Digite uma opção válida!");
            }

            switch (opcao){
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    consultarLivro();
                    break;
                case 3:
                    consultarAutor();
                    break;
                case 4:
                    consultarAutoresPorAno();
                    break;
                case 5:
                    consultarLivrosPorLinguagem();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
            }
        }
    }

    private DadosLivros getDadosLivro(){
        System.out.println("Digite o nome de um livro:");
        var busca = scanner.nextLine().toLowerCase().replace(" ","%20");
        var json = requisicaoAPI.getData(urlAPI + "?search=" + busca);

        DadosLivros dadosLivros = converteDados.obterDados(json, DadosLivros.class);
        return dadosLivros;
    }

    private void buscarLivro() {
        DadosLivros dadosLivros = getDadosLivro();
        try {
            Livro livro = new Livro(dadosLivros.resultados().get(0));
            Autor autor = new Autor(dadosLivros.resultados().get(0).autorList().get(0));

            System.out.println("""
                    livro[
                        titulo: %s
                        autor: %s
                        linguagem: %s
                        numeroDownloads: %s
                        ]
                    """.formatted(livro.getTitulo(),
                    livro.getAutor(),
                    livro.getLinguagem(),
                    livro.getNumeroDownloads().toString()));

            livroRepositorio.save(livro);
            autorRepositorio.save(autor);
        } catch (Exception e){
            System.out.println("Livro não encontrado");
        }
    }

    private void consultarLivro(){

    }

    private void consultarAutor(){

    }

    private void consultarAutoresPorAno(){

    }

    private void consultarLivrosPorLinguagem(){

    }

}
