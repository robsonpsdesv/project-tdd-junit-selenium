package com.tdd.spring.controller;

import com.tdd.spring.model.Produto;
import com.tdd.spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private static final String PRODUTO_CADASTRO = "produtoCadastro";
    private static final String PRODUTO_LISTA = "produtoLista";

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/novo")
    public ModelAndView novo(){
        ModelAndView modelAndView = new ModelAndView(PRODUTO_CADASTRO);
        modelAndView.addObject(new Produto());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView salvar(@Valid Produto produto, Errors errors, RedirectAttributes redirectAttributes){

        if(errors.hasErrors()){
            return new ModelAndView(PRODUTO_CADASTRO);
        }

        if(produto.getId() == null){
            produtoService.incluir(produto);
            redirectAttributes.addFlashAttribute("mensagem", "Inclusão realizada com sucesso!");
        } else {
            produtoService.alterar(produto);
            redirectAttributes.addFlashAttribute("mensagem", "Alteração realizada com sucesso!");
        }

        return new ModelAndView("redirect:/produto/novo");

    }

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView(PRODUTO_CADASTRO);
        modelAndView.addObject("produto", produtoService.listar());
        return modelAndView;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView(PRODUTO_CADASTRO);
        modelAndView.addObject(produtoService.pesquisaPorId(id));
        return modelAndView;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/produto");
        produtoService.excluir(id);
        return modelAndView;
    }

}
