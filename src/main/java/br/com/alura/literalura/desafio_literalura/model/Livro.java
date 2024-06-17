package br.com.alura.literalura.desafio_literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String autor;
    private String titulo;
    private String linguagem;
    private Integer numeroDownloads;
    private String genero;


    public Livro(){}

    public Livro(Resultados dadosLivro){
        this.titulo = dadosLivro.titulo();
        this.autor = dadosLivro.autorList().get(0).nomeAutor();
        this.linguagem = dadosLivro.linguagem().get(0);
        this.genero = dadosLivro.genero().get(0);
        this.numeroDownloads = dadosLivro.numeroDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
