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

import br.com.apipedidos.domain.dto.create.PedidoItemCreateRequest;
import br.com.apipedidos.domain.dto.create.PedidoVendasCreateRequest;
import br.com.apipedidos.domain.dto.response.PedidoItemResponse;
import br.com.apipedidos.domain.dto.response.PedidoVendaResponse;
import br.com.apipedidos.domain.dto.update.PedidoItemUpdateRequest;
import br.com.apipedidos.services.PedidoItemService;
import jakarta.validation.Valid;

@RestController
public class PedidoItemController {
    private final PedidoItemService service;

    public PedidoItemController(PedidoItemService service) {
        this.service = service;
    }

    @GetMapping("/pedido-item")
    public ResponseEntity<List<PedidoItemResponse>>  getAll() {
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/pedido-item")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PedidoItemResponse> create(@RequestBody @Valid PedidoItemCreateRequest request) {
        var result = service.create(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/pedido-item/{id}")
    public ResponseEntity<PedidoItemResponse> update(
            @PathVariable("id") String id,
            @RequestBody @Valid PedidoItemUpdateRequest updateRequest) {
        var pedidoitem = service.update(id, updateRequest);
        return ResponseEntity.ok(pedidoitem);
    }

    @DeleteMapping("/cliente-deletar/{id}")
    public ResponseEntity<PedidoItemResponse> delete(@PathVariable("id") String id) {
        var pedidoItem = service.delete(id);
        return ResponseEntity.ok(pedidoItem);
    }
}
