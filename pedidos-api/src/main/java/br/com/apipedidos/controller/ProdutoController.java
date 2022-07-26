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

import br.com.apipedidos.domain.dto.create.ProdutoCreateRequest;
import br.com.apipedidos.domain.dto.response.ProdutoResponse;
import br.com.apipedidos.domain.dto.update.ProdutoUpdateRequest;
import br.com.apipedidos.services.ProdutoService;
import jakarta.validation.Valid;

@RestController
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoResponse>>  getAll() {
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoResponse> create(@RequestBody @Valid ProdutoCreateRequest request) {
        var result = service.create(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/produto/{id}")
    public ResponseEntity<ProdutoResponse> update(
            @PathVariable("id") String id,
            @RequestBody @Valid ProdutoUpdateRequest updateRequest) {
        var produto = service.update(id, updateRequest);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/produto-deletar/{id}")
    public ResponseEntity<ProdutoResponse> delete(@PathVariable("id") String id) {
        var produto = service.delete(id);
        return ResponseEntity.ok(produto);
    }
}
