package com.amztecnologia.loja.service;

import com.amztecnologia.loja.exception.ProdutoNaoEncontradoException;
import com.amztecnologia.loja.model.Produto;
import com.amztecnologia.loja.repository.ProdutoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    @DisplayName("Deve retornar o produto quando o id existe")
    void deveRetornarProdutoQuandoIdExiste(){
        // Arrange
        Produto teclado = new Produto(1L, "Teclado Mecânico - ABNT", new BigDecimal("150.00"), 10);
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(teclado));

        // Act
        Produto resultado = produtoService.buscarPorId(1L);

        // Assert: verificação de ESTADO
        assertEquals("Teclado Mecânico - ABNT", resultado.getNome());
        assertEquals(10, resultado.getEstoques());
        // Assert: verificação de COMPORTAMENTO
        verify(produtoRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção quando o produto não existe")
    void deveLancarExcecaoQuandoProdutoNaoExiste(){
        // Arange
        when(produtoRepository.findById(99L)).thenReturn(Optional.empty());

        // Act + Assert
        ProdutoNaoEncontradoException excecao = assertThrows(
                ProdutoNaoEncontradoException.class,
                () -> produtoService.buscarPorId(99L));

        assertEquals("Produto com id 99 não encontrado", excecao.getMessage()

        );
    }


}