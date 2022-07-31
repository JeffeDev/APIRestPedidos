package br.com.apipedidos.domain.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.apipedidos.domain.model.Pedido;
import br.com.apipedidos.domain.model.PedidoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PedidoDTO {
	private Long id_pedi;
	private Long numero_pedi;
	private Long cliente_id;
	private String dataEmissao_pedi;
	private String dataEntrega_pedi;
	private BigDecimal totalPedido_pedi;
	private PedidoStatusEnum statusPedido_pedi = PedidoStatusEnum.ABERTO;

	public PedidoDTO(Pedido pedidoVenda) {
		this.id_pedi = pedidoVenda.getId_pedi();
		this.numero_pedi = pedidoVenda.getNumeroPedido_pedi();
		this.cliente_id = pedidoVenda.getCliente_id();
		this.dataEmissao_pedi = pedidoVenda.getDataEmissao_pedi();
		this.dataEntrega_pedi = pedidoVenda.getDataEntrega_pedi();
		this.totalPedido_pedi = pedidoVenda.getTotalPedido_pedi();
		this.statusPedido_pedi = pedidoVenda.getStatusPedido_pedi();
	}

	public static List<PedidoDTO> converter(List<Pedido> pedido) {
		return pedido.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
	
}
