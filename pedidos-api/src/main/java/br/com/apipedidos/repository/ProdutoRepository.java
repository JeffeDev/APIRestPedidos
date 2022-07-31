package br.com.apipedidos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apipedidos.domain.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

	Optional<Produto> findById(Long id);

	void deleteById(Long id);
	
}
