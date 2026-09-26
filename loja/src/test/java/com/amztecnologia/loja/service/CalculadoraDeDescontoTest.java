package com.amztecnologia.loja.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeDescontoTest {
    private static final double DELTA = 0.001;
    private CalculadoraDeDesconto calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraDeDesconto();
    }

    @Test
    @DisplayName("Compras abaixo de R$100,00 não têm desconto.")
    void compraPequenaNaoTemDesconto() {
        double desconto = calculadora.calcularDesconto(50.00);
        assertEquals(0.0, desconto, DELTA);
    }

    @Test
    @DisplayName("Compras entre R$100,00 e F$499,00 têm 10% de desconto.")
    void compraMediaTemCincoPorCento(){
        double desconto = calculadora.calcularDesconto(200.00);
        assertEquals(190.00, desconto, DELTA);
    }

    @Test
    @DisplayName("Compras a partir de R$500,00 têm 10% de desconto.")
    public void compraGradeTemDezPorCento(){
        double desconto = calculadora.calcularDesconto(1000.00);
        assertEquals(100.00, desconto, DELTA);
    }

    @Test
    @DisplayName("Valor negativo deve lançar exceção.")
    public void valorNegativoLancaExcecao(){
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                ()-> calculadora.calcularDesconto(-1.00));
        assertEquals("O valor da compra não pode ser negativo.", excecao.getMessage());
    }

    @ParameterizedTest(name = "compra de {0} gera desconto de {1}")
    @CsvSource({
            "99.99, 0.00", // logo ABAIXO do 1º limite
            "100.00, 5.00", // EXATAMENTE no 1º limite
            "499.99, 24.9995", // logo ABAIXO do 2º limite
            "500.00, 50.00" // EXATAMENTE no 2º limite
    })
    @DisplayName("Valores-limite das faixas de desconto")
    void valoresLimite(double valorCompra, double descontoEsperado) {
        assertEquals(descontoEsperado, calculadora.calcularDesconto(valorCompra), DELTA);
    }
}