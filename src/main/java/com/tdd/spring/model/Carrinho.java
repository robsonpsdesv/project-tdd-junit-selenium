package com.tdd.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private TicketPromocional ticketPromocional;

    @OneToOne
    private Usuario cliente;

    @OneToMany
    private List<CarrinhoProdutos> listaProduto;

    @OneToMany
    private List<CarrinhoFormaPagamento> listaFormaPagamento;

    public Carrinho() {
    }

    public Carrinho(Usuario cliente) {
        super();
        this.cliente = cliente;
        this.listaProduto = new ArrayList<CarrinhoProdutos>();
        this.listaFormaPagamento = new ArrayList<CarrinhoFormaPagamento>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketPromocional getTicketPromocional() {
        return ticketPromocional;
    }

    public void setTicketPromocional(TicketPromocional ticketPromocional) {
        this.ticketPromocional = ticketPromocional;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<CarrinhoProdutos> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<CarrinhoProdutos> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public List<CarrinhoFormaPagamento> getListaFormaPagamento() {
        return listaFormaPagamento;
    }

    public void setListaFormaPagamento(List<CarrinhoFormaPagamento> listaFormaPagamento) {
        this.listaFormaPagamento = listaFormaPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return id.equals(carrinho.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void incluirProdutos(Produto produto, double qtde){
        getListaProduto().add(new CarrinhoProdutos(qtde, produto));
    }

    public void incluirFormaPagamento(FormaPagamento fp, double valor){
        getListaFormaPagamento().add(new CarrinhoFormaPagamento(valor, fp));
    }

    public double maiorValorProduto(){
        double valorRetorno = Double.NEGATIVE_INFINITY;
        for (CarrinhoProdutos produtos : getListaProduto()){
            if(produtos.getProduto().getValorUnitario() > valorRetorno){
                valorRetorno = produtos.getProduto().getValorUnitario();
            }
        }
        return valorRetorno;
    }

    public double menorValorProduto(){
        double valorRetorno = Double.POSITIVE_INFINITY;
        for (CarrinhoProdutos produtos : getListaProduto()){
            if(produtos.getProduto().getValorUnitario() < valorRetorno){
                valorRetorno = produtos.getProduto().getValorUnitario();
            }
        }
        return valorRetorno;
    }

    public double valorTotalVenda(){
        double valorTotal = 0;
        for (CarrinhoProdutos produtos : getListaProduto()){
            valorTotal += (produtos.getQtde() * produtos.getProduto().getValorUnitario());
        }
        return valorTotal;
    }

    public double maiorValorFormaPagamentoVenda(){
        double valorRetorno = Double.NEGATIVE_INFINITY;
        for (CarrinhoFormaPagamento itemFormaPagamento : getListaFormaPagamento()){
            if (itemFormaPagamento.getValorCompra() > valorRetorno){
                valorRetorno = itemFormaPagamento.getValorCompra();
            }
        }
        return valorRetorno;
    }

    public double menorValorFormaPagamento(){
        double valorRetorno = Double.POSITIVE_INFINITY;
        for (CarrinhoFormaPagamento itemFormaPagamento : getListaFormaPagamento()){
            if (itemFormaPagamento.getValorCompra() < valorRetorno){
                valorRetorno = itemFormaPagamento.getValorCompra();
            }
        }
        return valorRetorno;
    }

    public double quantidadeTotalProdutosVenda(){
        double qtdeTotal = 0;
        for (CarrinhoProdutos produtos : getListaProduto()){
            qtdeTotal += produtos.getQtde();
        }
        return qtdeTotal;
    }

}
