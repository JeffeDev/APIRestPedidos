package br.com.apipedidos.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedido-itens")
public class PedidoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String produto_id;
	
	private String pedido_id;
	
	private Integer sequencia;
	private BigDecimal quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal desconto;
	private BigDecimal totalItem;
	
	public PedidoItem() {
	}

	public PedidoItem(String produto_id, String pedido_id, Integer sequencia, BigDecimal quantidade,
			BigDecimal precoUnitario, BigDecimal desconto, BigDecimal totalItem) {
		this.produto_id = produto_id;
		this.setPedido_id(pedido_id);
		this.sequencia = sequencia;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.desconto = desconto;
		this.totalItem = totalItem;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(String produto_id) {
		this.produto_id = produto_id;
	}
	public Integer getSequencia() {
		return sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	public BigDecimal getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(BigDecimal totalItem) {
		this.totalItem = totalItem;
	}

	public String getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(String pedido_id) {
		this.pedido_id = pedido_id;
	}

}
