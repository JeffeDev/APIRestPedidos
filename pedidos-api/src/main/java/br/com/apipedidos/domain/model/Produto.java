package br.com.apipedidos.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TBL_PRODUTO")
public class Produto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prod;
	private String nome_prod;
	private String imagem_prod;
	private BigDecimal preco_prod;
	
	public Produto() {
	}
	public Produto(Long id_prod, String nome_prod, String imagem_prod, BigDecimal preco_prod) {
		super();
		this.id_prod = id_prod;
		this.nome_prod = nome_prod;
		this.imagem_prod = imagem_prod;
		this.preco_prod = preco_prod;
	}
	public Produto(String nome_prod, String imagem_prod, BigDecimal preco_prod) {
		this.nome_prod = nome_prod;
		this.imagem_prod = imagem_prod;
		this.preco_prod = preco_prod;
	}

	public Long getId_prod() {
		return id_prod;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public String getImagem_prod() {
		return imagem_prod;
	}

	public BigDecimal getPreco_prod() {
		return preco_prod;
	}

	@Override
	public String toString() {
		return "Produto [id_prod=" + id_prod + ", nome_prod=" + nome_prod + ", imagem_prod=" + imagem_prod
				+ ", preco_prod=" + preco_prod + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_prod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id_prod, other.id_prod);
	}

}
