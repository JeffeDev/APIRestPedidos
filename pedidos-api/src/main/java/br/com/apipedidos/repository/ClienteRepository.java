package br.com.apipedidos.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.apipedidos.domain.entity.Cliente;

public interface ClienteRepository  extends MongoRepository<Cliente, String> {
	
}
