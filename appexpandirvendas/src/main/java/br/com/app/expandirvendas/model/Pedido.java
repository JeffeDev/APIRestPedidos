package br.com.app.expandirvendas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "TBL_PEDIDO")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero_pedi;
	private Long cliente_id;
	
	private String dataEmissao_pedi;
	private String dataEntrega_pedi;
	private BigDecimal totalPedido_pedi;
	
	@Enumerated(EnumType.STRING)
	private PedidoStatusEnum status_pedi = PedidoStatusEnum.ABERTO;
	
	@OneToMany(mappedBy = "pedido_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ItensPedido> itens_pedi = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Long cliente_id, String dataEmissao_pedi, String dataEntrega_pedi, BigDecimal totalPedido_pedi,
			PedidoStatusEnum status_pedi, List<ItensPedido> itens_pedi) {
		super();
		this.cliente_id = cliente_id;
		this.dataEmissao_pedi = dataEmissao_pedi;
		this.dataEntrega_pedi = dataEntrega_pedi;
		this.totalPedido_pedi = totalPedido_pedi;
		this.status_pedi = status_pedi;
		this.itens_pedi = itens_pedi;
	}

	public Pedido(Long cliente_id, String dataEmissao_pedi,
			String dataEntrega_pedi, BigDecimal totalPedido_pedi, PedidoStatusEnum statusPedido_pedi) {
		
		this.cliente_id = cliente_id;
		this.dataEmissao_pedi = dataEmissao_pedi;
		this.dataEntrega_pedi = dataEntrega_pedi;
		this.totalPedido_pedi = totalPedido_pedi;
		this.status_pedi = statusPedido_pedi;
	}
	
	public Pedido(Long numero_pedi, Long cliente_id, String dataEmissao_pedi, String dataEntrega_pedi,
			BigDecimal totalPedido_pedi, PedidoStatusEnum status_pedi, List<ItensPedido> pedidoItens_pedi) {
		this.numero_pedi = numero_pedi;
		this.cliente_id = cliente_id;
		this.dataEmissao_pedi = dataEmissao_pedi;
		this.dataEntrega_pedi = dataEntrega_pedi;
		this.totalPedido_pedi = totalPedido_pedi;
		this.status_pedi = status_pedi;
		this.itens_pedi = pedidoItens_pedi;
	}

	@Override
	public String toString() {
		return "Pedido [ numeroPedido_pedi=" + numero_pedi + ", cliente_id=" + cliente_id
				+ ", dataEmissao_pedi=" + dataEmissao_pedi + ", dataEntrega_pedi=" + dataEntrega_pedi
				+ ", totalPedido_pedi=" + totalPedido_pedi + ", statusPedido_pedi=" + status_pedi
				+ "]";
	}

	public Long getNumeroPedido_pedi() {
		return numero_pedi;
	}

	public Long getCliente_id() {
		return cliente_id;
	}

	public String getDataEmissao_pedi() {
		return dataEmissao_pedi;
	}

	public String getDataEntrega_pedi() {
		return dataEntrega_pedi;
	}

	public BigDecimal getTotalPedido_pedi() {
		return totalPedido_pedi;
	}

	public PedidoStatusEnum getStatusPedido_pedi() {
		return status_pedi;
	}
	public List<ItensPedido> getItens_pedi() {
		return itens_pedi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero_pedi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(numero_pedi, other.numero_pedi);
	}
	

}
