package com.amztecnologia.loja.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void deveSomarDoisNumeros() {
        //Arrange
        Calculadora calculadora = new Calculadora();

        //Act
        int resultado = calculadora.somar(2,3);

        //Assert
        assertEquals(5,resultado);
    }

    @Test
    void deveSubtrairDoisNumeros(){
        //Arrange
        Calculadora calculadora = new Calculadora();

        //Act
        int resultado = calculadora.subtrair(6,3);

        //Assert
        assertEquals(3,resultado);
    }

    @Test
    void deveMultiplicarDoisNumeros(){
        //Arrange
        Calculadora calculadora = new Calculadora();

        //Act
        int resultado = calculadora.multiplicar(6,3);

        //Assert
        assertEquals(18,resultado);

    }

}