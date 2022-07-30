package br.com.apipedidos.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Document(collection = "pedidos")
public class PedidoVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private Long numeroPedido;
	private String cliente_id;
	private String dataEmissao;
	private String dataEntrega;
	private BigDecimal totalPedido;
	
	@Enumerated(EnumType.STRING)
	private StatusPedidoEnum statusPedido = StatusPedidoEnum.ABERTO;

	@Autowired
    private List<PedidoItem> pedidos;

	public PedidoVenda() {
	}

	public PedidoVenda(Long numeroPedido, String cliente_id, String dataEmissao, String dataEntrega, 
			BigDecimal totalPedido, StatusPedidoEnum statusPedido) {
		this.numeroPedido = numeroPedido;
		this.cliente_id = cliente_id;
		this.dataEmissao = dataEmissao;
		this.dataEntrega = dataEntrega;
		this.totalPedido = totalPedido;
		this.statusPedido = statusPedido;
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

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
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

	public String getId() {
		return id;
	}

	public List<PedidoItem> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoItem> pedidos) {
		this.pedidos = pedidos;
	}

}
