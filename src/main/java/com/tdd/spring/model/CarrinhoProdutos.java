package com.tdd.spring.model;

import javax.persistence.*;

@Entity
public class CarrinhoProdutos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double qtde;

    @OneToOne
    private Produto produto;

    public CarrinhoProdutos() {
    }

    public CarrinhoProdutos(double qtde, Produto produto) {
        this.qtde = qtde;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
