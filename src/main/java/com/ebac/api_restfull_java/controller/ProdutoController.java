package com.ebac.api_restfull_java.controller;

import com.ebac.api_restfull_java.model.Produto;
import com.ebac.api_restfull_java.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable int id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping()
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produtoNovo) {
        Produto produto =  produtoService.salvarProduto(produtoNovo);
        return ResponseEntity.created(URI.create("/produtos/" + produto.getId())).body(produto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable int id ,@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.atualizarProduto(id,produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable int id){
        produtoService.deletarProduto(id);
        return  ResponseEntity.noContent().build();
    }



}
