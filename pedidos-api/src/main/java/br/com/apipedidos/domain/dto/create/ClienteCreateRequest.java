package br.com.apipedidos.domain.dto.create;

import br.com.apipedidos.domain.entity.TipoPessoaEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteCreateRequest {

	@NotEmpty(message = "Por favor, informe o nome do cliente")
	private String nome;
	
	@NotEmpty(message = "Por favor, informe o tipo pessoa FISCA ou JURIDICA")
	private TipoPessoaEnum tipoPessoa;
	
	@NotEmpty(message = "Por favor, informe o telefone")
	private String telefone;
	
	@NotEmpty(message = "Por favor, informe o email")
	private String email;
	
	@NotEmpty(message = "Por favor, informe o número CPF/CNPJ")
	private String documento;
}
