package br.com.apipedidos.domain.dto.create;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PedidoItemCreateRequest {

	@NotEmpty(message = "Por favor, informe o produto_id")
	private String produto_id;
	
	@NotEmpty(message = "Por favor, informe o pedido_id")
	private String pedido_id;
	
	@NotEmpty(message = "Por favor, informe a sequencia")
	private Integer sequencia;
	
	@NotEmpty(message = "Por favor, informe a quantidade")
	private BigDecimal quantidade;
	
	@NotEmpty(message = "Por favor, informe o precoUnitario")
	private BigDecimal precoUnitario;
	
	private BigDecimal desconto;
	
	@NotEmpty(message = "Por favor, informe o Valor do Item")
	private BigDecimal totalItem;
	
}
