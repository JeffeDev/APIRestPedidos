package br.com.app.expandirvendas.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TBL_ITENS_PEDIDO")
public class ItensPedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_item;
	
	private Long produto_id;
	private Long pedido_id;
	
	private Integer sequencia_item;
	
	private BigDecimal quantidade_item;
	private BigDecimal precoUnitario_item;
	private BigDecimal desconto_item;
	private BigDecimal totalItem_item;
	
	public ItensPedido() {
	}

	public ItensPedido(Long id_item, Long produto_id, Long pedido_id, Integer sequencia_item,
			BigDecimal quantidade_item, BigDecimal precoUnitario_item, BigDecimal desconto_item, BigDecimal totalItem_item) {
		super();
		this.id_item = id_item;
		this.produto_id = produto_id;
		this.pedido_id = pedido_id;
		this.sequencia_item = sequencia_item;
		this.quantidade_item = quantidade_item;
		this.precoUnitario_item = precoUnitario_item;
		this.desconto_item = desconto_item;
		this.totalItem_item = totalItem_item;
	}

	public ItensPedido(Long produto_id, Long pedido_id, Integer sequencia_item, BigDecimal quantidade_item,
			BigDecimal precoUnitario_item, BigDecimal desconto_item, BigDecimal totalItem_item) {
		super();
		this.produto_id = produto_id;
		this.pedido_id = pedido_id;
		this.sequencia_item = sequencia_item;
		this.quantidade_item = quantidade_item;
		this.precoUnitario_item = precoUnitario_item;
		this.desconto_item = desconto_item;
		this.totalItem_item = totalItem_item;
	}

	public Long getId_item() {
		return id_item;
	}

	public Long getProduto_id() {
		return produto_id;
	}

	public Long getPedido_id() {
		return pedido_id;
	}

	public Integer getSequencia_item() {
		return sequencia_item;
	}

	public BigDecimal getQuantidade_item() {
		return quantidade_item;
	}

	public BigDecimal getPrecoUnitario_item() {
		return precoUnitario_item;
	}

	public BigDecimal getDesconto_item() {
		return desconto_item;
	}

	public BigDecimal getTotalItem_item() {
		return totalItem_item;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_item, pedido_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensPedido other = (ItensPedido) obj;
		return Objects.equals(id_item, other.id_item) && Objects.equals(pedido_id, other.pedido_id);
	}

	@Override
	public String toString() {
		return "ItensPedido [id_item=" + id_item + ", produto_id=" + produto_id + ", pedido_id=" + pedido_id
				+ ", sequencia_item=" + sequencia_item + ", quantidade_item=" + quantidade_item
				+ ", precoUnitario_item=" + precoUnitario_item + ", desconto_item=" + desconto_item
				+ ", totalItem_item=" + totalItem_item + "]";
	}
	
}
