package br.com.apipedidos.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import br.com.apipedidos.domain.entity.PedidoVenda;
import br.com.apipedidos.repository.PedidoVendaRepository;

@SpringBootTest
class PedidoControllerTest {

	@Autowired
	PedidoVendaRepository pedido = new PedidoVendaRepository() {
		
		@Override
		public <S extends PedidoVenda> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		
		@Override
		public <S extends PedidoVenda, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends PedidoVenda> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends PedidoVenda> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public <S extends PedidoVenda> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Page<PedidoVenda> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<PedidoVenda> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends PedidoVenda> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<PedidoVenda> findById(String id) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		
		@Override
		public boolean existsById(String id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteById(String id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllById(Iterable<? extends String> ids) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll(Iterable<? extends PedidoVenda> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(PedidoVenda entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public <S extends PedidoVenda> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<PedidoVenda> findAllById(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<PedidoVenda> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends PedidoVenda> List<S> insert(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends PedidoVenda> S insert(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends PedidoVenda> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends PedidoVenda> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
}
