package com.amztecnologia.loja.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{
    public ProdutoNaoEncontradoException(Long id) {
        super("Produto com id: "+id+" não foi encontrado.");
    }
}
