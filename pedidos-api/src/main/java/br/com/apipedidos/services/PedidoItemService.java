package br.com.apipedidos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.apipedidos.domain.dto.create.PedidoItemCreateRequest;
import br.com.apipedidos.domain.dto.response.PedidoItemResponse;
import br.com.apipedidos.domain.dto.response.ProdutoResponse;
import br.com.apipedidos.domain.dto.update.PedidoItemUpdateRequest;
import br.com.apipedidos.domain.entity.PedidoItem;
import br.com.apipedidos.domain.entity.Produto;
import br.com.apipedidos.exception.ApiNotFoundException;
import br.com.apipedidos.repository.PedidoItemRepository;

@Service
public class PedidoItemService {
	private final PedidoItemRepository pedidoItemRepository;

	public PedidoItemService(PedidoItemRepository pedidoitemRepository) {
		this.pedidoItemRepository = pedidoitemRepository;
	}

	public List<PedidoItemResponse> listAll() {
		var result = pedidoItemRepository.findAll();
		
		return result.stream().map(pedidoItem -> new PedidoItemResponse(
				pedidoItem.getId(), 
				pedidoItem.getProduto_id(),
				pedidoItem.getPedido_id(), 
				pedidoItem.getSequencia(),
				pedidoItem.getQuantidade(),
				pedidoItem.getPrecoUnitario(),
				pedidoItem.getDesconto(),
				pedidoItem.getTotalItem() )).collect(Collectors.toList());
	}
	
	public PedidoItemResponse create(PedidoItemCreateRequest request) {
		var newPedidoItem = new PedidoItem(
				request.getProduto_id(), 
				request.getPedido_id(), 
				request.getSequencia(),
				request.getQuantidade(),
				request.getPrecoUnitario(),
				request.getDesconto(),
				request.getTotalItem());
		
		var saveProduto = pedidoItemRepository.save(newPedidoItem);

		return new PedidoItemResponse(
				saveProduto.getId(), 
				saveProduto.getProduto_id(), 
				saveProduto.getPedido_id(),
				saveProduto.getSequencia(),
				saveProduto.getQuantidade(),
				saveProduto.getPrecoUnitario(),
				saveProduto.getDesconto(),
				saveProduto.getTotalItem()
				);
	}

	public PedidoItemResponse update(String id, PedidoItemUpdateRequest request) {
		var result = pedidoItemRepository.findById(id);

		if (result.isEmpty()) {
			throw new ApiNotFoundException();
		}

		var updatePedidoItem = result.get();
		    	updatePedidoItem.setQuantidade(request.getQuantidade());
		    	updatePedidoItem.setPrecoUnitario(request.getPrecoUnitario());
		    	updatePedidoItem.setDesconto(request.getDesconto());
		    	updatePedidoItem.setTotalItem(request.getTotalItem());
		    
		var saveProduto= pedidoItemRepository.save(updatePedidoItem);
		
		return new PedidoItemResponse( 
				saveProduto.getId(), 
				saveProduto.getProduto_id(), 
				saveProduto.getPedido_id(),
				saveProduto.getSequencia(),
				saveProduto.getQuantidade(),
				saveProduto.getPrecoUnitario(),
				saveProduto.getDesconto(),
				saveProduto.getTotalItem()
				);
	}

	public PedidoItemResponse delete(String id) {
		var result = pedidoItemRepository.findById(id);

		if (result.isEmpty()) {
			throw new ApiNotFoundException();
		}

		PedidoItem deletarPedidoItem = result.get();
		pedidoItemRepository.delete(deletarPedidoItem);

		return new PedidoItemResponse(
				deletarPedidoItem.getId(), 
				deletarPedidoItem.getProduto_id(), 
				deletarPedidoItem.getPedido_id(), 
				deletarPedidoItem.getSequencia(),
				deletarPedidoItem.getQuantidade(),
				deletarPedidoItem.getPrecoUnitario(),
				deletarPedidoItem.getDesconto(),
				deletarPedidoItem.getTotalItem()
				);
	}
}
