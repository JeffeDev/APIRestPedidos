package br.com.apipedidos.domain.dto.update;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PedidoVendasUpdateRequest {
	
	@NotEmpty(message = "Por favor, informe o valor Total do Pedido")
	private BigDecimal totalPedido;
	
	@NotEmpty(message = "Por favor, informe o um Status Venda")
	private String statusPedido;
}
