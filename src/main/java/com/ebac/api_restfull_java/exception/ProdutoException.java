package com.ebac.api_restfull_java.exception;

import org.springframework.http.HttpStatus;

public class ProdutoException extends RuntimeException {

    private final HttpStatus status;

    public ProdutoException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    // Cada "tipo" de erro vira um método estático aqui
    public static ProdutoException notFound(int id) {
        return new ProdutoException("Produto com ID " + id + " não encontrado.", HttpStatus.NOT_FOUND);
    }

    public static ProdutoException invalido(String motivo) {
        return new ProdutoException(motivo, HttpStatus.BAD_REQUEST);
    }

    public static ProdutoException duplicado(String nome) {
        return new ProdutoException("Produto '" + nome + "' já existe.", HttpStatus.CONFLICT);
    }
}