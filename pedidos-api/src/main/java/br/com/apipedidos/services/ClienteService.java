package br.com.apipedidos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apipedidos.domain.dto.create.ClienteCreateRequest;
import br.com.apipedidos.domain.dto.response.ClienteResponse;
import br.com.apipedidos.domain.dto.update.ClienteUpdateRequest;
import br.com.apipedidos.domain.entity.Cliente;
import br.com.apipedidos.exception.ApiNotFoundException;
import br.com.apipedidos.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteResponse> listAll() {
		var result = clienteRepository.findAll();

		return result
				.stream().map(cliente -> new ClienteResponse(
						cliente.getId(), 
						cliente.getNome(),
						cliente.getTipoPessoa(), 
						cliente.getTelefone(), 
						cliente.getEmail(),
						cliente.getDocumento()))
				.collect(Collectors.toList());
	}

	public ClienteResponse create(ClienteCreateRequest request) {
		var newCliente = new Cliente();
		newCliente.setNome(request.getNome());
		newCliente.setTelefone(request.getTelefone());
		newCliente.setTipoPessoa(request.getTipoPessoa());
		newCliente.setEmail(request.getEmail());
		newCliente.setDocumento(request.getDocumento());
		
		var saveCliente = clienteRepository.save(newCliente);

		return new ClienteResponse(
				saveCliente.getId(), 
				saveCliente.getNome(), 
				saveCliente.getTipoPessoa(),
				saveCliente.getTelefone(), 
				saveCliente.getEmail(),
				saveCliente.getDocumento() );
	}

	public ClienteResponse update(String id, ClienteUpdateRequest request) {
		var result = clienteRepository.findById(id);

		if (result.isEmpty()) {
			throw new ApiNotFoundException();
		}

		var updateCliente = result.get();
		updateCliente.setNome(request.getNome());
		updateCliente.setTipoPessoa(request.getTipoPessoa());
		updateCliente.setTelefone(request.getTelefone());
		updateCliente.setEmail(request.getEmail());
		updateCliente.setDocumento(request.getDocumento());
		
		var saveCliente = clienteRepository.save(updateCliente);

		return new ClienteResponse(
				saveCliente.getId(), 
				saveCliente.getNome(), 
				saveCliente.getTipoPessoa(),
				saveCliente.getTelefone(), 
				saveCliente.getEmail(),
				saveCliente.getDocumento());
	}

	public ClienteResponse delete(String id) {
		var result = clienteRepository.findById(id);

		if (result.isEmpty()) {
			throw new ApiNotFoundException();
		}

		Cliente deletarCliente = result.get();
		clienteRepository.delete(deletarCliente);

		return new ClienteResponse(
				deletarCliente.getId(), 
				deletarCliente.getNome(), 
				deletarCliente.getTipoPessoa(),
				deletarCliente.getTelefone(), 
				deletarCliente.getEmail(),
				deletarCliente.getDocumento());
	}
}
