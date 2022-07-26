package br.com.apipedidos.domain.dto.update;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProdutoUpdateRequest {

	@NotEmpty(message = "Por favor, informe o nome do cliente")
	private String nome;
	
	@NotEmpty(message = "Por favor, informe o path da imagem")
	private String image;
	
	@NotEmpty(message = "Por favor, informe o preço do produto")
	private BigDecimal preco;
}
