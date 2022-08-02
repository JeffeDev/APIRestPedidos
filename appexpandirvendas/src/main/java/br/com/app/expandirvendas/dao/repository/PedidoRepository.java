package br.com.app.expandirvendas.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.expandirvendas.model.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {


}
