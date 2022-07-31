package br.com.apipedidos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apipedidos.domain.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findById(Long id);

	void deleteById(Long id);
	
}
