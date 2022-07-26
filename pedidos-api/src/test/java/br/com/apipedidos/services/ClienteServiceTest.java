package br.com.apipedidos.services;

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

import br.com.apipedidos.domain.entity.Cliente;
import br.com.apipedidos.repository.ClienteRepository;

@SpringBootTest
class ClienteServiceTest {

	@Autowired
	ClienteRepository cliente = new ClienteRepository() {
		
		@Override
		public <S extends Cliente> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		
		@Override
		public <S extends Cliente, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Cliente> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Cliente> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public <S extends Cliente> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Page<Cliente> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Cliente> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Cliente> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<Cliente> findById(String id) {
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
		public void deleteAll(Iterable<? extends Cliente> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Cliente entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public <S extends Cliente> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Cliente> findAllById(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Cliente> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Cliente> List<S> insert(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Cliente> S insert(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Cliente> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Cliente> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}
	};
}
