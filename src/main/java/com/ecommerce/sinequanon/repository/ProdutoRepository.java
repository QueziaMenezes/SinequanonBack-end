package com.ecommerce.sinequanon.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ecommerce.sinequanon.model.Produto;

@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo Buscar Todos.
     * @return Lista de produtos.
    */
    public List<Produto> obterTodos(){
        return produtos;

    }

    /**Metodo Buscar por id
     * @param id do produto que sera localizado.
     * @return Produto referente ao id informado.
    */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
            .stream()
            .filter(produto -> produto.getId() == id)
            .findFirst();
    }

    /**
     * Metodo Cadastrar
     * @param produto que sera adicionado.
     * @return Retorna o produto que foi adicionado na lista.
    */
    public Produto adicionar(Produto produto){
        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;

    }

    /**
     * Metodo Deletar
     * @param id que sera deletado.
    */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**Metodo Atualizar
     * @param produto
     * @return Retorna o produto atualizado na lista.
    */
    public Produto atualizar(Produto produto){
        //encontra o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }
        //remove o produto anterior
        deletar(produto.getId());
        //adiciona o produto novo (atualizado)
        produtos.add(produto);

        return produto;
    }
}
