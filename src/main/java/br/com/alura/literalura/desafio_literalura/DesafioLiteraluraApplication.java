package br.com.alura.literalura.desafio_literalura;

import br.com.alura.literalura.desafio_literalura.main.Principal;
import br.com.alura.literalura.desafio_literalura.repository.AutorRepositorio;
import br.com.alura.literalura.desafio_literalura.repository.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioLiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioLiteraluraApplication.class, args);
	}

	@Autowired
	private AutorRepositorio autorRepositorio;
	public void run(String[] args){
		Principal principal = new Principal(repositorio, autorRepositorio);
		principal.showMenu();
	}
	@Autowired
	private LivroRepositorio repositorio;
}
