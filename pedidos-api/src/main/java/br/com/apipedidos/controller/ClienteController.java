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

import br.com.apipedidos.domain.dto.create.ClienteCreateRequest;
import br.com.apipedidos.domain.dto.response.ClienteResponse;
import br.com.apipedidos.domain.dto.update.ClienteUpdateRequest;
import br.com.apipedidos.services.ClienteService;
import jakarta.validation.Valid;

@RestController
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteResponse>>  getAll() {
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteResponse> create(@RequestBody @Valid ClienteCreateRequest request) {
        var result = service.create(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/cliente/{id}")
    public ResponseEntity<ClienteResponse> update(
            @PathVariable("id") String id,
            @RequestBody @Valid ClienteUpdateRequest updateRequest) {
        var cliente = service.update(id, updateRequest);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/cliente-deletar/{id}")
    public ResponseEntity<ClienteResponse> delete(@PathVariable("id") String id) {
        var cliente = service.delete(id);
        return ResponseEntity.ok(cliente);
    }
}
