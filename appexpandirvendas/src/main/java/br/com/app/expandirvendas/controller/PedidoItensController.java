package br.com.app.expandirvendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.expandirvendas.dao.repository.PedidoRepository;
import br.com.app.expandirvendas.dto.PedidoItensDTO;
import br.com.app.expandirvendas.model.Pedido;

@RestController
@RequestMapping("/pedidos-itens")
public class PedidoItensController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public List<PedidoItensDTO> lista() {
		List<Pedido> pedido = pedidoRepository.findAll();
		return  PedidoItensDTO.converter(pedido);
	}

}
