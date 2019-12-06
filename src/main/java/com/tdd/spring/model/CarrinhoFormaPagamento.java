package com.tdd.spring.model;

import javax.persistence.*;

@Entity
public class CarrinhoFormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valorCompra;

    @OneToOne
    private FormaPagamento formaPagamento;

    public CarrinhoFormaPagamento() {
    }

    public CarrinhoFormaPagamento(double valorCompra, FormaPagamento formaPagamento) {
        super();
        this.valorCompra = valorCompra;
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
