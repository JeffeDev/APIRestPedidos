package br.com.apipedidos.domain.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.apipedidos.domain.model.Cliente;
import br.com.apipedidos.domain.model.ClienteTipoPessoaEnum;
import br.com.apipedidos.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteFormDTO {
	
	@NotNull(message = "Por favor, informe o nome do cliente")
	private String nome_cli;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Por favor, informe o tipo de pessoa FISICA ou JURIDICA")
	private ClienteTipoPessoaEnum tipoPessoa_cli;
	
	private String telefone_cli;
	
	@Email @NotNull(message = "Por favor, informe o email válido")
	private String email_cli;
	
	@NotNull(message = "Por favor, informe o documento do cliente CPF ou CNPJ para pessoa Juridica")
	private String documento_cli;
	
	public ClienteFormDTO() {
	}
	
	public Cliente converter(ClienteRepository clienteRepository) {
		return new Cliente(nome_cli, tipoPessoa_cli, telefone_cli, email_cli, documento_cli);
	}
	
}
