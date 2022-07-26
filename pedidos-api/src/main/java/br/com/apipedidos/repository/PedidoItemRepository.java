package br.com.apipedidos.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.apipedidos.domain.entity.PedidoItem;

public interface PedidoItemRepository  extends MongoRepository<PedidoItem, String> {
}
