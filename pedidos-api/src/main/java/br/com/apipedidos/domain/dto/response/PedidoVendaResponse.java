package br.com.apipedidos.domain.dto.response;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoVendaResponse {
	private String id;
	private Long numeroPedido;
	private String cliente_id;
	private String dataEmissao;
	private String dataEntrega;
	private BigDecimal totalPedido;
	private String statusPedido;
	
}
