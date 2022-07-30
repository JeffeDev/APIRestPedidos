package br.com.apipedidos.domain.dto.response;

import br.com.apipedidos.domain.entity.TipoPessoaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteResponse {
	
	private String id;
	
	private String nome;
	private TipoPessoaEnum tipoPessoa;
	private String telefone;
	private String email;
	private String documento;
}
