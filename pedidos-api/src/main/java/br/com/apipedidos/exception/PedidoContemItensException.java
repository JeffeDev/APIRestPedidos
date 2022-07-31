package br.com.apipedidos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PedidoContemItensException extends RuntimeException{

	public PedidoContemItensException() {
        super("Pedido contém itens cadastrado.");
    }
	
}
