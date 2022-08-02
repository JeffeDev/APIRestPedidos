package br.com.app.expandirvendas.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.app.expandirvendas.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

	@Query("SELECT cli FROM TBL_CLIENTE cli WHERE cli.nome_cli like :nome")
	List<Cliente> findByNome_cli(@Param("nome") String nome);
	
}
