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

import br.com.app.expandirvendas.dao.repository.ClienteRepository;
import br.com.app.expandirvendas.dto.ClienteDTO;
import br.com.app.expandirvendas.dto.ClienteFormDTO;
import br.com.app.expandirvendas.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<ClienteDTO> lista(String nome) {
		if (nome == null) {
			List<Cliente> cliente = clienteRepository.findAll();
			return ClienteDTO.converter(cliente);
		}else {
			List<Cliente> cliente = clienteRepository.findByNome_cli(nome);
			return ClienteDTO.converter(cliente);		
		}
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteFormDTO formApi,
			UriComponentsBuilder uriBuilder) {
		Cliente cliente = formApi.converter(clienteRepository);
		System.out.println("Salvando cliente " + cliente);
		clienteRepository.save(cliente);

		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId_cli()).toUri();

		return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> detalhar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDTO(cliente.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Cliente> remover(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
