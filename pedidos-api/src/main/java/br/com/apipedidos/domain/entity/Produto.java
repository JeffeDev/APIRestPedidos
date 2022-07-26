package br.com.apipedidos.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String nome;
	private String image;
	private BigDecimal preco;
	
	public Produto() {
	}

	public Produto(String nome, String image, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
		this.image = image;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
