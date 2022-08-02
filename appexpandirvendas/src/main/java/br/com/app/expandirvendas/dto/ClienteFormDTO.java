package br.com.app.expandirvendas.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.app.expandirvendas.dao.repository.ClienteRepository;
import br.com.app.expandirvendas.model.Cliente;
import br.com.app.expandirvendas.model.ClienteTipoPessoaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteFormDTO {
	
	@NotEmpty(message = "Por favor, informe o nome do cliente")
	private String nome_cli;
	
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "Por favor, informe o tipo de pessoa FISICA ou JURIDICA")
	private ClienteTipoPessoaEnum tipoPessoa_cli = ClienteTipoPessoaEnum.FISICA;

	private String telefone_cli;
	
	@Email @NotEmpty(message = "Por favor, informe o email do cliente")
	private String email_cli;
	
	@NotEmpty(message = "Por favor, informe o documento do cliente CPF ou CNPJ para pessoa Juridica")
	private String documento_cli;
	
	public ClienteFormDTO() {
	}
	
	public Cliente converter(ClienteRepository clienteRepository) {
		return new Cliente(nome_cli, tipoPessoa_cli, telefone_cli, email_cli, documento_cli);
	}
	
}
