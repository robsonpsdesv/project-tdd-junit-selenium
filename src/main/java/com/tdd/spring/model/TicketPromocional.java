package com.tdd.spring.model;

import javax.persistence.*;

@Entity
public class TicketPromocional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePromocao;
    private String codigoPromocional;
    private double percentualPromocao;

    public TicketPromocional() {
    }

    public TicketPromocional(String nomePromocao, String codigoPromocional, double percentualPromocao) {
        this.nomePromocao = nomePromocao;
        this.codigoPromocional = codigoPromocional;
        this.percentualPromocao = percentualPromocao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public String getCodigoPromocional() {
        return codigoPromocional;
    }

    public void setCodigoPromocional(String codigoPromocional) {
        this.codigoPromocional = codigoPromocional;
    }

    public double getPercentualPromocao() {
        return percentualPromocao;
    }

    public void setPercentualPromocao(double percentualPromocao) {
        this.percentualPromocao = percentualPromocao;
    }
}
