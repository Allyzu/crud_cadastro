package com.example.crud_cadastro.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.crud_cadastro.repository.ProdutoRepository;
import com.example.crud_cadastro.model.Produto;;



@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtorepository)  {
        this.produtoRepository = produtorepository;
    }

    // Métodos de serviço para manipular produtos podem ser adicionados aqui

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setPreco(produtoAtualizado.getPreco());
                    return produtoRepository.save(produto);
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }
}
