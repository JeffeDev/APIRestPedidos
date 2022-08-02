package br.com.app.expandirvendas.controller;

import java.io.Serializable;
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

import br.com.app.expandirvendas.dao.repository.ItensPedidoRepository;
import br.com.app.expandirvendas.dao.repository.PedidoRepository;
import br.com.app.expandirvendas.dto.PedidoDTO;
import br.com.app.expandirvendas.dto.PedidoFormDTO;
import br.com.app.expandirvendas.dto.ProdutoDTO;
import br.com.app.expandirvendas.model.ItensPedido;
import br.com.app.expandirvendas.model.Pedido;


@RestController
@RequestMapping("/pedido")
public class PedidoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItensPedidoRepository itensPedidoRepository;
	
	@GetMapping
	public List<PedidoDTO> lista(){
		List<Pedido> pedido = pedidoRepository.findAll();
		return PedidoDTO.converter(pedido);
	}
	
	@PostMapping
	public ResponseEntity<PedidoDTO> cadastrar(@RequestBody @Valid PedidoFormDTO formApi, UriComponentsBuilder uriBuilder) {
		Pedido pedido = formApi.converter(pedidoRepository);
		System.out.println("Salvando pedido "+ pedido);
		pedidoRepository.save(pedido);
		
		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getNumeroPedido_pedi()).toUri();
		
		return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> detalhar(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(new PedidoDTO(pedido.get()) );
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<ProdutoDTO> remover(@PathVariable Long id) {
		Optional<ItensPedido> itens = itensPedidoRepository.findById(id);
		
		if(!itens.isEmpty()) {
			itensPedidoRepository.deleteAllByIdPedido_id(id);
		}
		
		pedidoRepository.deleteById(id);
		return ResponseEntity.ok().build();

	} 
}
