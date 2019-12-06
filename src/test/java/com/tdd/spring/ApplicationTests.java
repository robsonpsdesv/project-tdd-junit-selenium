package com.tdd.spring;

import com.tdd.spring.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplicationTests {

    private Carrinho compra;
    private Impressora impressora;

    public Carrinho getCompra() {
        return compra;
    }

    public void setCompra(Carrinho compra) {
        this.compra = compra;
    }

    public Impressora getImpressora() {
        return impressora;
    }

    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
    }

    @Before
    public void iniciarCenario(){
        CriadorDeCarrinhoDataBuilder criador = new CriadorDeCarrinhoDataBuilder();
        TicketPromocional tkp = new TicketPromocional("Black Friday", "123456", 50);
        criador.paraOCliente(new Usuario("Robson", "73121703153", "robsonps", "123456", "62 986194122", "robson@gmail.com",
                new Endereco("74375350", "Rua das Papoulas", new Cidade("Goiânia"), new Bairro("Pq Oeste"))))
                .pegarProduto(new Produto("Teclado", 50.00),10)
                .pegarProduto(new Produto("Mouse", 100.00), 5)
                .pagar(new FormaPagamento("Dinheiro"), 150.00)
                .pagar(new FormaPagamento("Cartão"), 50.00)
                .aplicarPromocao(tkp)
                .constroi();
        setCompra(criador.getCarrinho());
        impressora = new Impressora(criador.getCarrinho());
    }

    @Test
    public void maiorValorProduto(){
        Assert.assertEquals(100.00, getCompra().maiorValorProduto(), 0);
    }

    @Test
    public void menorValorProduto(){
        Assert.assertEquals(50.00, getCompra().menorValorProduto(), 0);
    }

    @Test
    public void valorTotalVenda(){
        Assert.assertEquals(1000.00, getCompra().valorTotalVenda(), 0);
    }

    @Test
    public void qtdeTotalVenda(){
        Assert.assertEquals(15, getCompra().quantidadeTotalProdutosVenda(), 0);
    }

    @Test
    public void maiorValorFormaPagamento(){
        Assert.assertEquals(150, getCompra().maiorValorFormaPagamentoVenda(), 0);
    }

    @Test
    public void menorValorFormaPagamento(){
        Assert.assertEquals(50, getCompra().menorValorFormaPagamento(), 0);
    }

    @Test
    public void imprimirVenda(){
        Assert.assertEquals(0, getImpressora().imprimirVenda(), 0);
    }

}
