package br.com.app.expandirvendas.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.app.expandirvendas.model.ItensPedido;
import br.com.app.expandirvendas.model.Pedido;
import br.com.app.expandirvendas.model.PedidoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PedidoDTO {
	private Long id;
	private Long numero_pedi;
	private Long cliente_id;
	private String dataEmissao_pedi;
	private String dataEntrega_pedi;
	private BigDecimal totalPedido_pedi;
	private PedidoStatusEnum status_pedi = PedidoStatusEnum.ABERTO;
	
    private List<ItensPedido> pedidoItens_pedi = new ArrayList<>();
	
	public PedidoDTO(Pedido pedidoVenda) {
		this.numero_pedi = pedidoVenda.getNumeroPedido_pedi();
		this.cliente_id = pedidoVenda.getCliente_id();
		this.dataEmissao_pedi = pedidoVenda.getDataEmissao_pedi();
		this.dataEntrega_pedi = pedidoVenda.getDataEntrega_pedi();
		this.totalPedido_pedi = pedidoVenda.getTotalPedido_pedi();
		this.status_pedi = pedidoVenda.getStatusPedido_pedi();
		this.pedidoItens_pedi = pedidoVenda.getItens_pedi();
	}

	public static List<PedidoDTO> converter(List<Pedido> pedido) {
		return pedido.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
	
}
