package br.com.alura.literalura.desafio_literalura.main;

import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);

    public void Menu(){

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

        }
    }
}
