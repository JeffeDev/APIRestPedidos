package br.com.app.expandirvendas.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.expandirvendas.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findById(Long id);

	void deleteById(Long id);
	
}
