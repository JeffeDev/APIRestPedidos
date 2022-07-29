package br.com.apipedidos.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteResponse {
	
	private String id;
	
	private String nome;
	private String tipoPessoa="FISICA";
	private String telefone;
	private String email;
	private String documento;
}
