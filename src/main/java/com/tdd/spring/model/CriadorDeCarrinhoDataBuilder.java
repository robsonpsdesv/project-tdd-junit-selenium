package com.tdd.spring.model;

public class CriadorDeCarrinhoDataBuilder {

    private Carrinho carrinho;

    public CriadorDeCarrinhoDataBuilder() {
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public CriadorDeCarrinhoDataBuilder paraOCliente(Usuario cliente){
        setCarrinho(new Carrinho(cliente));
        return this;
    }

    public CriadorDeCarrinhoDataBuilder pegarProduto(Produto produto, double quantidade){
        getCarrinho().incluirProdutos(produto, quantidade);
        return this;
    }

    public CriadorDeCarrinhoDataBuilder pagar(FormaPagamento fp, double valor){
        getCarrinho().incluirFormaPagamento(fp, valor);
        return this;
    }

    public CriadorDeCarrinhoDataBuilder aplicarPromocao(TicketPromocional tkp){
        getCarrinho().setTicketPromocional(tkp);
        return this;
    }

    public Carrinho constroi(){
        return getCarrinho();
    }
}
