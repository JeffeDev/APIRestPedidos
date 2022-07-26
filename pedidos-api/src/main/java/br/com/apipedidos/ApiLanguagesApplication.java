package br.com.apipedidos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.apipedidos.repository.ClienteRepository;

@SpringBootApplication
public class ApiLanguagesApplication { 
	
	@Autowired
    ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiLanguagesApplication.class, args);
	}

}
