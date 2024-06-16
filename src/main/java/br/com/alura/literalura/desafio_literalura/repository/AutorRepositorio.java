package br.com.alura.literalura.desafio_literalura.repository;

import br.com.alura.literalura.desafio_literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.nascimento >= :anoBuscado ORDER BY a.nascimento ASC")
    List<Autor> autorPorData(int anoBuscado);
}
