package com.tdd.spring.model;

public class Impressora {

    public Carrinho carrinho;

    public Impressora(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public int imprimirVenda(){

        double valorTotalBruto = 0;
        double valorTotalLiquido = 0;

        System.out.println("** PRODUTOS **");
        for (CarrinhoProdutos listaProdutos : getCarrinho().getListaProduto()){
            System.out.println(listaProdutos.getProduto().getDescricao() + " " +
                    listaProdutos.getQtde() + " " +
                    listaProdutos.getProduto().getValorUnitario());
            valorTotalBruto += (listaProdutos.getQtde() * listaProdutos.getProduto().getValorUnitario());
        }
        System.out.println("** FORMA PAGAMENTO **");
        for(CarrinhoFormaPagamento listaFP : getCarrinho().getListaFormaPagamento()){
            System.out.println(listaFP.getFormaPagamento().getDescricao() + " " + listaFP.getValorCompra());
        }
        System.out.println("Valor Total Bruto: " + valorTotalBruto);
        System.out.println("Ticket Promocional de " + getCarrinho().getTicketPromocional().getPercentualPromocao());
        valorTotalLiquido = valorTotalBruto - (valorTotalBruto * (getCarrinho().getTicketPromocional().getPercentualPromocao()/100));
        System.out.println("Valor total líquido: " + valorTotalLiquido);
        return 0;
    }
}
