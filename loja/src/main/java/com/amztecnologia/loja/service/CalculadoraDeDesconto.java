package com.amztecnologia.loja.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraDeDesconto {

    public double calcularDesconto(double valorCompra){
        if(valorCompra < 0){
            throw new IllegalArgumentException("O valor da compra não pode ser negativo.");
        }if(valorCompra >= 500){
            return valorCompra * 0.10;
        }if(valorCompra >= 100){
            return valorCompra * 0.05;
        }

        return  0.0;
    }
}
