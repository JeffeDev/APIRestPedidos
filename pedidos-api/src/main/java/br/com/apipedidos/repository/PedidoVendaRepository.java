package br.com.apipedidos.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.apipedidos.domain.entity.PedidoVenda;

public interface PedidoVendaRepository  extends MongoRepository<PedidoVenda, String> {

}
