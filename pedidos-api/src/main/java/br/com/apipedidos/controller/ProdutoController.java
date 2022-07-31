package br.com.apipedidos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.apipedidos.domain.dto.ProdutoDTO;
import br.com.apipedidos.domain.dto.ProdutoFormDTO;
import br.com.apipedidos.domain.model.Produto;
import br.com.apipedidos.repository.ProdutoRepository;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<ProdutoDTO> lista(){
		List<Produto> produto = produtoRepository.findAll();
		return ProdutoDTO.converter(produto);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> cadastrar(@RequestBody @Valid ProdutoFormDTO formApi, UriComponentsBuilder uriBuilder) {
		Produto produto = formApi.converter(produtoRepository);
		System.out.println("Salvando produto "+ produto);
		produtoRepository.save(produto);
		
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId_prod()).toUri();
		
		return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> detalhar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoDTO(produto.get()) );
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoDTO> remover(@PathVariable Long id) {
		produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
	}
}
