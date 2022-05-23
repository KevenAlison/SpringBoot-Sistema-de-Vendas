package io.github.kevenalison.rest.controller;

import io.github.kevenalison.domain.entity.Produto;
import io.github.kevenalison.domain.repository.ProdutoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoRepository produtosRepository;
    public ProdutoController(ProdutoRepository produto){
        produtosRepository = produto;
    }

    //BUSCAR PRODUTO POR ID
    @GetMapping("{id}")
    public Produto getProdutosById(@PathVariable Integer id){
        return produtosRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    //Adicionar produto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save( @RequestBody Produto cliente){
        return produtosRepository.save(cliente);
    }

    //Deletar produto
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
         produtosRepository.findById(id)
                .map( produto -> {
                    produtosRepository.delete(produto);
                    return produto;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Produto produto){

        produtosRepository
                .findById(id)
                .map(produtoExistente -> {
                    produto.setId(produtoExistente.getId());
                    produtosRepository.save(produto);
                    return produtoExistente;
                 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping
    public List<Produto> filter(Produto filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching().withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return produtosRepository.findAll(example);
    }

}
