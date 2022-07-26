package br.com.apipedidos.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.apipedidos.domain.dto.create.PedidoVendasCreateRequest;
import br.com.apipedidos.domain.dto.response.PedidoVendaResponse;
import br.com.apipedidos.domain.dto.update.PedidoVendasUpdateRequest;
import br.com.apipedidos.services.PedidoVendaService;
import jakarta.validation.Valid;

@RestController
public class PedidoController {
    private final PedidoVendaService service;

    public PedidoController(PedidoVendaService service) {
        this.service = service;
    }

    @GetMapping("/pedido")
    public ResponseEntity<List<PedidoVendaResponse>>  getAll() {
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PedidoVendaResponse> create(@RequestBody @Valid PedidoVendasCreateRequest request) {
        var result = service.create(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/pedido/{id}")
    public ResponseEntity<PedidoVendaResponse> update(
            @PathVariable("id") String id,
            @RequestBody @Valid PedidoVendasUpdateRequest updateRequest) {
        var cliente = service.update(id, updateRequest);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/cliente-deletar/{id}")
    public ResponseEntity<PedidoVendaResponse> delete(@PathVariable("id") String id) {
        var pedido = service.delete(id);
        return ResponseEntity.ok(pedido);
    }
}
