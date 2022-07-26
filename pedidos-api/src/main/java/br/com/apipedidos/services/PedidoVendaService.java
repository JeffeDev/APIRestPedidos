package br.com.apipedidos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.apipedidos.domain.dto.create.PedidoVendasCreateRequest;
import br.com.apipedidos.domain.dto.response.PedidoVendaResponse;
import br.com.apipedidos.domain.dto.update.PedidoVendasUpdateRequest;
import br.com.apipedidos.domain.entity.PedidoVenda;
import br.com.apipedidos.exception.ApiNotFoundException;
import br.com.apipedidos.repository.PedidoVendaRepository;

@Service
public class PedidoVendaService {
	private final PedidoVendaRepository pedidoVendaRepository;

	public PedidoVendaService(PedidoVendaRepository repository) {
		this.pedidoVendaRepository = repository;
	}
	
	public List<PedidoVendaResponse> listAll() {
		var result = pedidoVendaRepository.findAll();
		
		return result.stream().map(pedidoVenda -> new PedidoVendaResponse(
				pedidoVenda.getId(),
				pedidoVenda.getNumeroPedido(),
				pedidoVenda.getCliente_id(), 
				pedidoVenda.getDataEmissao(), 
				pedidoVenda.getDataEntrega(), 
				pedidoVenda.getTotalPedido(),
				pedidoVenda.getStatusPedido())).collect(Collectors.toList());
	}

	public PedidoVendaResponse create(PedidoVendasCreateRequest request) {
		var newPedidoVenda = new PedidoVenda(
				request.getNumeroPedido(), 
				request.getCliente_id(), 
				request.getDataEmissao(),
				request.getDataEntrega(),
				request.getTotalPedido(),
				request.getStatusPedido()
			);
		
		var savePedidoVenda = pedidoVendaRepository.save(newPedidoVenda);

		return new PedidoVendaResponse(
				savePedidoVenda.getId(), 
				savePedidoVenda.getNumeroPedido(), 
				savePedidoVenda.getCliente_id(),
				savePedidoVenda.getDataEmissao(),
				savePedidoVenda.getDataEntrega(),
				savePedidoVenda.getTotalPedido(),
				savePedidoVenda.getStatusPedido()
			);
	}

	public PedidoVendaResponse update(String id, PedidoVendasUpdateRequest request) {
		var result = pedidoVendaRepository.findById(id);

		if (result.isEmpty()) {
			throw new ApiNotFoundException();
		}

		var pedidoVenda = result.get();
				pedidoVenda.setTotalPedido(request.getTotalPedido());
				pedidoVenda.setStatusPedido(request.getStatusPedido());
		
		var savePedidoVenda = pedidoVendaRepository.save(pedidoVenda);

		return new PedidoVendaResponse(
				savePedidoVenda.getId(),
				savePedidoVenda.getNumeroPedido(), 
				savePedidoVenda.getCliente_id(), 
				savePedidoVenda.getDataEmissao(),
				savePedidoVenda.getDataEntrega(),
				savePedidoVenda.getTotalPedido(),
				savePedidoVenda.getStatusPedido()
			);
	}
	public PedidoVendaResponse delete(String id) {
		var result = pedidoVendaRepository.findById(id);

		if (result.isEmpty()) {
			throw new ApiNotFoundException();
		}

		PedidoVenda deletarPedidoVenda = result.get();
		pedidoVendaRepository.delete(deletarPedidoVenda);

		return new PedidoVendaResponse(
				deletarPedidoVenda.getId(),
				deletarPedidoVenda.getNumeroPedido(), 
				deletarPedidoVenda.getCliente_id(), 
				deletarPedidoVenda.getDataEmissao(), 
				deletarPedidoVenda.getDataEntrega(),
				deletarPedidoVenda.getTotalPedido(),
				deletarPedidoVenda.getStatusPedido()
		);
	}}
