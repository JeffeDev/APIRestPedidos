package br.com.apipedidos.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apipedidos.domain.model.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

	Optional<Pedido> findById(Long id);

	void deleteById(Long id);


}
