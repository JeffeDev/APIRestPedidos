package br.com.apipedidos.domain.dto.update;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PedidoItemUpdateRequest {
	
	@NotEmpty(message = "Por favor, informe a quantidade")
	private BigDecimal quantidade;
	
	@NotEmpty(message = "Por favor, informe o precoUnitario")
	private BigDecimal precoUnitario;
	
	private BigDecimal desconto;
	
	@NotEmpty(message = "Por favor, informe o Valor do Item")
	private BigDecimal totalItem;
	
}
