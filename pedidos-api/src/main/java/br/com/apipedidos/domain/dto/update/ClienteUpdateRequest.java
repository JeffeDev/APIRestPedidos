package br.com.apipedidos.domain.dto.update;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClienteUpdateRequest {

	@NotEmpty(message = "Por favor, informe o nome do cliente")
	private String nome;
	
	@NotEmpty(message = "Por favor, informe o tipo pessoa fisica ou jurídica")
	private String tipoPessoa;
	
	@NotEmpty(message = "Por favor, informe o telefone")
	private String telefone;
	
	@NotEmpty(message = "Por favor, informe o email")
	private String email;
	
	@NotEmpty(message = "Por favor, informe o CPF/CNPJ")
	private String documento;
}
