package br.com.apipedidos.domain.dto.create;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClienteCreateRequest {

	@NotEmpty(message = "Por favor, informe o nome do cliente")
	private String nome;
	
	@NotEmpty(message = "Por favor, informe o tipo pessoa FISCA ou JURIDICA")
	private String tipoPessoa;
	
	@NotEmpty(message = "Por favor, informe o telefone")
	private String telefone;
	
	@NotEmpty(message = "Por favor, informe o email")
	private String email;
}
