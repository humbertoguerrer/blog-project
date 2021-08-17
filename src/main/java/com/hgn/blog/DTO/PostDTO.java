package com.hgn.blog.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class PostDTO {

    @NotBlank(message = "Este campo não pode ser deixado em branco.")
    private String titulo;

    @NotBlank(message = "Este campo não pode ser deixado em branco.")
    private String autor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private String conteudo;

    private Integer upvotes;


    public PostDTO() {
    }

    public PostDTO(String titulo, String autor, Date data, Integer upvotes) {
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.upvotes = upvotes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }
}
