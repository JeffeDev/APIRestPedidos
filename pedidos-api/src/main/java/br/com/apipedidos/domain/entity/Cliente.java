package br.com.apipedidos.domain.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

@Document(collection = "cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String nome;
	
	@JsonEnumDefaultValue
	private TipoPessoaEnum tipoPessoa;
	
	private String telefone;
	private String email;
	
	public Cliente() {
	}

	public Cliente(String nome, TipoPessoaEnum tipoPessoa, String telefone, String email) {
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.telefone = telefone;
		this.email = email;
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

	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
