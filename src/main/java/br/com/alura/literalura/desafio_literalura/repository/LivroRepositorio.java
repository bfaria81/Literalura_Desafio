package br.com.alura.literalura.desafio_literalura.repository;

import br.com.alura.literalura.desafio_literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {
    @Query("SELECT l FROM Livro l WHERE l.linguagem ILIKE %:linguagem%")
    List<Livro> findByLinguagem(String linguagem);
}

