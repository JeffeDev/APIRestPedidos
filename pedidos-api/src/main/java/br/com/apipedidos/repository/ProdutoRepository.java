package br.com.apipedidos.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.apipedidos.domain.entity.Produto;

public interface ProdutoRepository  extends MongoRepository<Produto, String> {
}
