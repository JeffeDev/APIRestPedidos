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
import br.com.app.expandirvendas.dto.ItensPedidoDTO;
import br.com.app.expandirvendas.dto.ItensPedidoFormDTO;
import br.com.app.expandirvendas.model.ItensPedido;

@RestController
@RequestMapping("/itens")
public class ItensController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ItensPedidoRepository itensPedidoRepository;

	@GetMapping
	public List<ItensPedidoDTO> lista(){
		List<ItensPedido> itens = itensPedidoRepository.findAll();
		return ItensPedidoDTO.converter(itens);
	}
	
	@GetMapping("/num-pedido/{numero}")
	public List<ItensPedidoDTO>  detalharItensPorPedido(@PathVariable Long numero) {
		List<ItensPedido>  itens = itensPedidoRepository.findByPedido(numero);
		
		if (itens.isEmpty()) {
			return (List<ItensPedidoDTO>) ResponseEntity.notFound().build();
		}else {	
			return ItensPedidoDTO.converter(itens);
		}
		
	}	
	@PostMapping
	public ResponseEntity<ItensPedidoDTO> cadastrar(@RequestBody @Valid ItensPedidoFormDTO formApi,
			UriComponentsBuilder uriBuilder) {
		ItensPedido itens = formApi.converter(itensPedidoRepository);
		System.out.println("Salvando pedido " + itens);
		itensPedidoRepository.save(itens);

		URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(itens.getId()).toUri();

		return ResponseEntity.created(uri).body(new ItensPedidoDTO(itens));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItensPedidoDTO> detalhar(@PathVariable Long id) {
		Optional<ItensPedido> itens = itensPedidoRepository.findById(id);
		
		if (itens.isPresent()) {
			return ResponseEntity.ok(new ItensPedidoDTO(itens.get()) );
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<ItensPedidoDTO> remover(@PathVariable Long id) {
		itensPedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
	}}
