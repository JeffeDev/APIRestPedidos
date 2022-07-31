package br.com.app.expandirvendas.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.expandirvendas.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

	Optional<Produto> findById(Long id);

	void deleteById(Long id);
	
}
