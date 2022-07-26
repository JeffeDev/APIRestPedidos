package br.com.apipedidos.domain.dto.response;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoResponse {
	private String id;
	
	private String nome;
	private String image;
	private BigDecimal preco;
}
