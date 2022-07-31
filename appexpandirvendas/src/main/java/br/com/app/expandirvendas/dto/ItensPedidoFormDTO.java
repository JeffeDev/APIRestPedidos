package br.com.app.expandirvendas.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.app.expandirvendas.dao.repository.ItensPedidoRepository;
import br.com.app.expandirvendas.model.ItensPedido;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItensPedidoFormDTO {
	
	@Min(value=0, message = "Por favor, informe o id do produto")
	@NotNull @DecimalMin(value = "0.1")
	private Long produto_id;
	
	@Min(value=0, message = "Por favor, informe o id do pedido")
	@NotNull @DecimalMin(value = "0.1")
	private Long pedido_id;
	
	@Min(value=0, message = "Por favor, informe sequencia do item")
	@NotNull @DecimalMin(value = "0.1")
	private Integer sequencia_item;
	
	@Min(value=0, message = "Por favor, informe a quantidade")
	@DecimalMin(value = "0.1")
	private BigDecimal quantidade_item;
	
	@Min(value=0, message = "Por favor, informe o preço unitário")
	@DecimalMin(value = "0.1")
	private BigDecimal precoUnitario_item;
	
	private BigDecimal desconto_item;
	
	@Min(value=0, message = "Por favor, informe o valor total do item")
	@DecimalMin(value = "0.1")
	private BigDecimal totalItem_item;

	public ItensPedido converter(ItensPedidoRepository itensRepository) {
		return new ItensPedido(produto_id, pedido_id, sequencia_item,
				quantidade_item, precoUnitario_item, desconto_item,
				totalItem_item);
	}
		
}
