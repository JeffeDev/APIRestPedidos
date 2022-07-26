package br.com.apipedidos.domain.dto.response;


import java.math.BigDecimal;
import java.util.Date;

import br.com.apipedidos.domain.entity.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoVendaResponse {
	private String id;
	private Long numeroPedido;
	private String cliente_id;
	private Date dataEmissao;
	private Date dataEntrega;
	private BigDecimal totalPedido;
	private StatusPedidoEnum statusPedido;
	
	
}
