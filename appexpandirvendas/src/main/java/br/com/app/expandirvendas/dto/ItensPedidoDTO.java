package br.com.app.expandirvendas.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.app.expandirvendas.model.ItensPedido;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItensPedidoDTO {
	private Long id;
	
	private Long produto_id;
	private Long pedido_id;
	
	private Integer sequencia_item;
	
	private BigDecimal quantidade_item;
	private BigDecimal precoUnitario_item;
	private BigDecimal desconto_item;
	private BigDecimal totalItem_item;
	
	public ItensPedidoDTO(ItensPedido itens) {
		this.id = itens.getId();
		this.pedido_id = itens.getPedido_id();
		this.produto_id = itens.getProduto_id();
		this.sequencia_item = itens.getSequencia_item();
		this.quantidade_item = itens.getQuantidade_item();
		this.precoUnitario_item = itens.getPrecoUnitario_item();
		this.desconto_item = itens.getDesconto_item();
		this.totalItem_item = itens.getTotalItem_item();
	}
	
	public static List<ItensPedidoDTO> converter(List<ItensPedido> itens) {
		return itens.stream().map(ItensPedidoDTO::new).collect(Collectors.toList());
	}	
}
