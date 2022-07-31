package br.com.app.expandirvendas.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.app.expandirvendas.model.Cliente;
import br.com.app.expandirvendas.model.ClienteTipoPessoaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDTO {
	private Long id_cli;
	private String nome_cli;
	
	@Enumerated(EnumType.STRING)
	private ClienteTipoPessoaEnum tipoPessoa_cli = ClienteTipoPessoaEnum.FISICA;
	private String telefone_cli;
	private String email_cli;
	private String documento_cli;
	
	public ClienteDTO(Cliente cliente) {
		this.id_cli = cliente.getId_cli();
		this.nome_cli = cliente.getNome_cli();
		this.tipoPessoa_cli = cliente.getTipoPessoa_cli();
		this.telefone_cli = cliente.getTelefone_cli();
		this.email_cli = cliente.getEmail_cli();
		this.documento_cli = cliente.getDocumento_cli();
	}
	
	public static List<ClienteDTO> converter(List<Cliente> cliente) {
		return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}
}
