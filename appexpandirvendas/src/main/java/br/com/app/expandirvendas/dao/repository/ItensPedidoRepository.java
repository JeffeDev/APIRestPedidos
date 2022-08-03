package br.com.app.expandirvendas.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.app.expandirvendas.model.ItensPedido;

public interface ItensPedidoRepository  extends JpaRepository<ItensPedido, Long> {
	
	@Query("SELECT item FROM TBL_ITENS_PEDIDO item WHERE item.pedido_id = :pedido_id")
	Optional<ItensPedido> findByPedido(@Param("pedido_id") Long pedido_id);

	@Query("delete from TBL_ITENS_PEDIDO itens where itens.pedido_id=:numero")
	void deleteAllByIdPedido_id(@Param("numero") Long numero);

}
