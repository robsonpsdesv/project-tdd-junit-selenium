package com.tdd.spring.service;

import com.tdd.spring.repository.ProdutoRepository;
import com.tdd.spring.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto incluir(Produto produto){
        produto.setId(null);
        return repository.save(produto);
    }

    public Produto pesquisaPorId(Long id){
        return repository.findById(id).orElseThrow(()
        -> new EmptyResultDataAccessException(0));
    }

    public Produto alterar(Produto produto){
        pesquisaPorId(produto.getId());
        return repository.save(produto);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

}
