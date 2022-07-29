package br.com.apipedidos.domain.dto.response;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoItemResponse {
	private String Id;
	private String produto_id;
	
	private String pedido_id;
	
	private Integer sequencia;
	private BigDecimal quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal desconto;
	private BigDecimal totalItem;
}
