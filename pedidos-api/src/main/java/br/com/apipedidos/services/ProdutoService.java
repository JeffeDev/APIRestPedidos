package br.com.apipedidos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.apipedidos.domain.dto.create.ProdutoCreateRequest;
import br.com.apipedidos.domain.dto.response.ProdutoResponse;
import br.com.apipedidos.domain.dto.update.ProdutoUpdateRequest;
import br.com.apipedidos.domain.entity.Produto;
import br.com.apipedidos.exception.ApiNotFoundException;
import br.com.apipedidos.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtorepository) {
		this.produtoRepository = produtorepository;
	}

	public List<ProdutoResponse> listAll() {
		var result = produtoRepository.findAll();

		return result.stream().map(produto -> 
				new ProdutoResponse(
						produto.getId(), 
						produto.getNome(),
						produto.getImage(), 
						produto.getPreco())).collect(Collectors.toList());
	}

	public ProdutoResponse create(ProdutoCreateRequest request) {
		var newProduto = new Produto(request.getNome(), 
									  request.getImage(), 
									  request.getPreco());
		
		var saveProduto = produtoRepository.save(newProduto);

		return new ProdutoResponse(saveProduto.getId(), 
								   saveProduto.getNome(), 
								   saveProduto.getImage(),
								   saveProduto.getPreco()
								);
	}

	public ProdutoResponse update(String id, ProdutoUpdateRequest request) {
		var result = produtoRepository.findById(id);

		if (result.isEmpty()) {
			throw new ApiNotFoundException();
		}

		var updateProduto = result.get();
		    updateProduto.setNome(request.getNome());
		    updateProduto.setImage(request.getImage());
		    updateProduto.setPreco(request.getPreco());
		    
		var saveProduto= produtoRepository.save(updateProduto);
		
		return new ProdutoResponse( saveProduto.getId(), 
									saveProduto.getNome(), 
									saveProduto.getImage(),
									saveProduto.getPreco()
								   );
	}

	public ProdutoResponse delete(String id) {
		var result = produtoRepository.findById(id);

		if (result.isEmpty()) {
			throw new ApiNotFoundException();
		}

		Produto deletarProduto = result.get();
		produtoRepository.delete(deletarProduto);

		return new ProdutoResponse(deletarProduto.getId(), 
									deletarProduto.getNome(), 
									deletarProduto.getImage(), 
									deletarProduto.getPreco()
								);
	}
}
