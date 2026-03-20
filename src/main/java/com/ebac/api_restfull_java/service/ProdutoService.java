package com.ebac.api_restfull_java.service;

import com.ebac.api_restfull_java.exception.ProdutoException;
import com.ebac.api_restfull_java.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>(List.of(
            new Produto(1, "TV", 2312.65),
            new Produto(2, "Celular", 3530.50),
            new Produto(3, "Computador", 5340.10)
    ));


    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto  buscarProdutoPorId(int id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> ProdutoException.notFound(id));
    }

    public Produto salvarProduto(Produto produto) {
        validarProduto(produto);
        produtos.add(produto);
        return produto;
    }

    private void validarProduto(Produto produto) {
        if (produto.getId() == null) {
            throw ProdutoException.invalido("Insira o ID do Produto");
        }

        if (produto.getNome() == null) {
            throw ProdutoException.invalido("Insira o nome do Produto");
        }

        if (produto.getPreco() == null) {
            throw ProdutoException.invalido("Insira o preco do Produto");
        }
        produtos.stream()
                .filter(p -> p.getId().equals(produto.getId()))
                .findFirst()
                .ifPresent(p -> { throw ProdutoException.duplicado(String.valueOf(produto.getId())); });
    }

    public Produto atualizarProduto(int id , Produto produto) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(produtoExistente -> atualizarProdutoExistente(produtoExistente, produto))
                .orElseThrow(() -> ProdutoException.notFound(id));
    }

    private Produto atualizarProdutoExistente(Produto produtoExistente, Produto produtoAtualizado) {
        if (produtoAtualizado.getId() != null) {
            produtoExistente.setId(produtoAtualizado.getId());
        }

        if (produtoAtualizado.getNome() != null) {
            produtoExistente.setNome(produtoAtualizado.getNome());
        }

        if (produtoAtualizado.getPreco() != null) {
            produtoExistente.setPreco(produtoAtualizado.getPreco());
        }

        return produtoExistente;
    }

    public void deletarProduto(int id) {
        if(!produtos.removeIf(p -> p.getId().equals(id))) {
            throw ProdutoException.notFound(id);
        }
    }
}
