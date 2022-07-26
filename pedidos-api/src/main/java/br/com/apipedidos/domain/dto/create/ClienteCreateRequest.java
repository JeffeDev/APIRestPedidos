package br.com.apipedidos.domain.dto.create;

import br.com.apipedidos.domain.entity.TipoPessoaEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClienteCreateRequest {

	@NotEmpty(message = "Por favor, informe o nome do cliente")
	private String nome;
	
	@NotEmpty(message = "Por favor, informe o tipo pessoa fisica ou jurídica")
	private TipoPessoaEnum tipoPessoa;
	
	@NotEmpty(message = "Por favor, informe o telefone")
	private String telefone;
	
	@NotEmpty(message = "Por favor, informe o email")
	private String email;
}
