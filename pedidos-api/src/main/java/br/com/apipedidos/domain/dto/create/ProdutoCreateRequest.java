package br.com.apipedidos.domain.dto.create;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProdutoCreateRequest {

	@NotEmpty(message = "Por favor, informe o nome do cliente")
	private String nome;
	
	@NotEmpty(message = "Por favor, informe o path da imagem")
	private String image;
	
	@Min(value=0, message = "Por favor, informe o preço do produto")
	private BigDecimal preco;
}
