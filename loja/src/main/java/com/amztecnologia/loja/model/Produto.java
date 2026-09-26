package com.amztecnologia.loja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
            private BigDecimal preco;
    private int estoques;

    public Produto(){}

    public Produto(Long id, String nome, BigDecimal preco, int estoques) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoques = estoques;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getEstoques() {
        return estoques;
    }

    public void setEstoques(int estoques) {
        this.estoques = estoques;
    }
}
