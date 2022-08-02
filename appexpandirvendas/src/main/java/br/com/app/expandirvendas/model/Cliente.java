package br.com.app.expandirvendas.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TBL_CLIENTE")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome_cli;
	
	@Enumerated(EnumType.STRING)
	private ClienteTipoPessoaEnum tipoPessoa_cli = ClienteTipoPessoaEnum.FISICA;
	private String telefone_cli;
	private String email_cli;
	private String documento_cli; //cpf ou cnpj
	
	public Cliente() {
	}

	public Cliente(Long id_cli, String nome_cli, ClienteTipoPessoaEnum tipoPessoa_cli, String telefone_cli,
			String email_cli, String documento_cli) {
		super();
		this.id = id_cli;
		this.nome_cli = nome_cli;
		this.tipoPessoa_cli = tipoPessoa_cli;
		this.telefone_cli = telefone_cli;
		this.email_cli = email_cli;
		this.documento_cli = documento_cli;
	}

	public Cliente(String nome_cli, ClienteTipoPessoaEnum tipoPessoa_cli, String telefone_cli, String email_cli,
			String documento_cli) {
		super();
		this.nome_cli = nome_cli;
		this.tipoPessoa_cli = tipoPessoa_cli;
		this.telefone_cli = telefone_cli;
		this.email_cli = email_cli;
		this.documento_cli = documento_cli;
	}

	public Long getId_cli() {
		return id;
	}

	public String getNome_cli() {
		return nome_cli;
	}

	public ClienteTipoPessoaEnum getTipoPessoa_cli() {
		return tipoPessoa_cli;
	}

	public String getTelefone_cli() {
		return telefone_cli;
	}

	public String getEmail_cli() {
		return email_cli;
	}

	public String getDocumento_cli() {
		return documento_cli;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id_cli=" + id + ", nome_cli=" + nome_cli + ", tipoPessoa_cli=" + tipoPessoa_cli
				+ ", telefone_cli=" + telefone_cli + ", email_cli=" + email_cli + ", documento_cli=" + documento_cli
				+ "]";
	}
	
	

}
