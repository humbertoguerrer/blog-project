package com.hgn.blog.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Post {

	private Long id;
	private String titulo;
	private String autor;
	private Date data;
	private Integer upvotes;
	private List<String> comentarios = new ArrayList<String>();

	public Post() {
	}

	public Post(Long id, String titulo, String autor, Date data, Integer upvotes, List<String> comentarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.data = data;
		this.upvotes = upvotes;
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}

}
