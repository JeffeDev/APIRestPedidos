package br.com.apipedidos.domain.dto.create;

import java.math.BigDecimal;
import java.util.Date;

import br.com.apipedidos.domain.entity.StatusPedidoEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PedidoVendasCreateRequest {
	
	@NotEmpty(message = "Por favor, informe o numero do pedido")
	private Long numeroPedido;
	
	@NotEmpty(message = "Por favor, informe o cliente_id")
	private String cliente_id;
	
	@NotEmpty(message = "Por favor, informe a data emissão")
	private Date dataEmissao;
	
	@NotEmpty(message = "Por favor, informe a data Entrega")
	private Date dataEntrega;
	
	@NotEmpty(message = "Por favor, informe o valor Total do Pedido")
	private BigDecimal totalPedido;
	private StatusPedidoEnum statusPedido;
}
