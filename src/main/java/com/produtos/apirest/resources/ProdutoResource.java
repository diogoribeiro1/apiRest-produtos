package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
public class ProdutoResource {

    @Autowired
    ProdutoRepository repository;

    @ApiOperation(value="Retorna uma lista de Produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return repository.findAll();
    }

    @ApiOperation(value="Retorna um produto unico")
    @GetMapping("/produto/{id}")
    public Produto listaProdutos(@PathVariable(value = "id") long id) {
        return repository.findById(id);
    }

    @ApiOperation(value="Salva um produto")
    @PostMapping("/produto")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @ApiOperation(value="Deleta um produto")
    @DeleteMapping("/produto")
    public void deletarProduto(@RequestBody Produto produto) {
        repository.delete(produto);
    }

    @ApiOperation(value="Atualiza um Produto")
    @PutMapping("/produto")
    public void editarProduto(@RequestBody Produto produto) {
        repository.delete(produto);
    }

}
