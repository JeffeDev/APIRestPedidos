package br.com.apipedidos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.apipedidos.domain.model.ItensPedido;

public interface ItemRepository  extends JpaRepository<ItensPedido, Long> {

	Optional<ItensPedido> findById(Long id);

	void deleteById(Long id);
	
	@Query("SELECT item FROM TBL_ITENS_PEDIDO item WHERE item.pedido_id = :pedido_id")
	List<ItensPedido> findByPedido(@Param("pedido_id") Long pedido_id);

}
