package br.com.apipedidos.exception;


import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ApiNotFoundException extends RuntimeException {

	public ApiNotFoundException() {
        super("Registro não encontrado.");
    }
	
}
