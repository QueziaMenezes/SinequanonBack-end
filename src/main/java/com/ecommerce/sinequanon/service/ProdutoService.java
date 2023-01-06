package com.ecommerce.sinequanon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sinequanon.model.Produto;
import com.ecommerce.sinequanon.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    /**
     * Metodo Buscar Todos.
     * @return Lista de produtos.
    */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo Cadastrar
     * @param produto que sera adicionado.
     * @return Retorna o produto que foi adicionado na lista.
    */
    public Produto adicionar(Produto produto){
        //colocar validacao
        return produtoRepository.adicionar(produto);
    }

    /**
     * Metodo Deletar
     * @param id que sera deletado.
    */
    public void deletar(Integer id){
        //colocar validacao
        produtoRepository.deletar(id);
    }

    /**Metodo Atualizar
     * @param produto que sera atualizado.
     * @param id do produto.
     * @return Retorna o produto atualizado na lista.
    */
    public Produto atualizar(Integer id, Produto produto){
        //colocar validacao
        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }

    public Optional<Produto> obterPorId(Integer id) {
        return null;
    }
}
