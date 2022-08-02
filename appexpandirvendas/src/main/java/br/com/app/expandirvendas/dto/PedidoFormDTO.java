package br.com.app.expandirvendas.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import br.com.app.expandirvendas.dao.repository.PedidoRepository;
import br.com.app.expandirvendas.model.ItensPedido;
import br.com.app.expandirvendas.model.Pedido;
import br.com.app.expandirvendas.model.PedidoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoFormDTO {
	
	@NotEmpty(message = "Id Cliente Inválido")
	private Long cliente_id;
	
	@NotEmpty(message = "deve ser uma data no formato dd/MM/yyyy")
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\\\d{4}$", message = "deve ser uma data no formato dd/MM/yyyy")
	private String dataEmissao_pedi;
	
	@NotEmpty(message = "deve ser uma data no formato dd/MM/yyyy")
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\\\d{4}$", message = "deve ser uma data no formato dd/MM/yyyy")
	private String dataEntrega_pedi;
	
	private BigDecimal totalPedido_pedi;

	@NotEmpty(message = "Status deve ser ABERTO ou FECHADO")
	private PedidoStatusEnum statusPedido_pedi = PedidoStatusEnum.ABERTO;
	
	private List<ItensPedido> pedidoItens_pedi = new ArrayList<>();
	
	
	public PedidoFormDTO(Pedido pedidoVenda) {
		this.cliente_id = pedidoVenda.getCliente_id();
		this.dataEmissao_pedi = pedidoVenda.getDataEmissao_pedi();
		this.dataEntrega_pedi = pedidoVenda.getDataEntrega_pedi();
		this.totalPedido_pedi = pedidoVenda.getTotalPedido_pedi();
		this.statusPedido_pedi = pedidoVenda.getStatusPedido_pedi();
		this.pedidoItens_pedi = pedidoVenda.getItens_pedi();
	}

	public Pedido converter(PedidoRepository pedidoRepository ) {
		return new Pedido(cliente_id, dataEmissao_pedi, dataEntrega_pedi, totalPedido_pedi, statusPedido_pedi, pedidoItens_pedi);
	}	
}
