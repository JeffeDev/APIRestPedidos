package br.com.app.expandirvendas.dao.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.expandirvendas.model.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

	Optional<Pedido> findById(Long id);

	void deleteById(Long id);
	

}
