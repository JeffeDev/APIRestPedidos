package br.com.apipedidos.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedido-de-venda")
public class PedidoVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Id 
	private Long numeroPedido;
	
	private String cliente_id;
	private Date dataEmissao;
	private Date dataEntrega;
	private BigDecimal totalPedido;
	
	private StatusPedidoEnum statusPedido=StatusPedidoEnum.ABERTO;
	
	public PedidoVenda() {
	}

	public PedidoVenda(Long numeroPedido, String cliente_id, Date dataEmissao, Date dataEntrega, 
			BigDecimal totalPedido, StatusPedidoEnum statusPedido) {
		this.numeroPedido = numeroPedido;
		this.cliente_id = cliente_id;
		this.dataEmissao = dataEmissao;
		this.dataEntrega = dataEntrega;
		this.totalPedido = totalPedido;
		this.statusPedido = statusPedido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(String cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	public StatusPedidoEnum getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedidoEnum statusPedido) {
		this.statusPedido = statusPedido;
	}
	
}
