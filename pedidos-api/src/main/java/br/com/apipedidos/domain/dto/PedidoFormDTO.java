package br.com.apipedidos.domain.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.apipedidos.domain.model.ItensPedido;
import br.com.apipedidos.domain.model.Pedido;
import br.com.apipedidos.domain.model.PedidoStatusEnum;
import br.com.apipedidos.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoFormDTO {

	private Long numero_pedi;
	private Long cliente_id;
	
	@NotNull(message = "deve ser uma data no formato dd/MM/yyyy")
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "deve ser uma data no formato dd/MM/yyyy")
	private String dataEmissao_pedi;
	
	@NotNull(message = "deve ser uma data no formato dd/MM/yyyy")
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "deve ser uma data no formato dd/MM/yyyy")
	private String dataEntrega_pedi;
	
	@NotNull
	@DecimalMin(value = "0.1")
	private BigDecimal totalPedido_pedi;

	@NotNull(message = "Status deve ser ABERTO ou FECHADO")
	private PedidoStatusEnum statusPedido_pedi = PedidoStatusEnum.ABERTO;
	
	
	public PedidoFormDTO(Pedido pedidoVenda) {
		this.numero_pedi = pedidoVenda.getNumeroPedido_pedi();
		this.cliente_id = pedidoVenda.getCliente_id();
		this.dataEmissao_pedi = pedidoVenda.getDataEmissao_pedi();
		this.dataEntrega_pedi = pedidoVenda.getDataEntrega_pedi();
		this.totalPedido_pedi = pedidoVenda.getTotalPedido_pedi();
		this.statusPedido_pedi = pedidoVenda.getStatusPedido_pedi();
	}

	public static List<PedidoFormDTO> converter(PedidoRepository pedidoRepository ) {
		return PedidoFormDTO new Pedido(numero_pedi, cliente_id, dataEmissao_pedi, dataEntrega_pedi, totalPedido_pedi, statusPedido_pedi);
	}
	
}
