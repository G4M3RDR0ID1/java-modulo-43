package com.ebac.api_restfull_java.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<Map<String, Object>> handleProdutoException(
            ProdutoException ex, HttpServletRequest request) {

        Map<String, Object> erro = new LinkedHashMap<>();
        erro.put("status", ex.getStatus().value());
        erro.put("mensagem", ex.getMessage());
        erro.put("path", request.getRequestURI());

        return ResponseEntity.status(ex.getStatus()).body(erro);
    }
}