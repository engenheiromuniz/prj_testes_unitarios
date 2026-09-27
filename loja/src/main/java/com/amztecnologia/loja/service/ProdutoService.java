package com.amztecnologia.loja.service;
import com.amztecnologia.loja.exception.ProdutoNaoEncontradoException;
import com.amztecnologia.loja.exception.RegraDeNegocioException;
import com.amztecnologia.loja.model.Produto;
import com.amztecnologia.loja.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) { // injeção por construtor
        this.produtoRepository = produtoRepository;
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }
    public Produto cadastrar(String nome, BigDecimal preco, Integer estoqueInicial) {
        if (nome == null || nome.isBlank()) {
            throw new RegraDeNegocioException("Nome é obrigatório");
        }

        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Preço deve ser maior que zero");
        }
        String nomeLimpo = nome.trim();

        if (produtoRepository.existsByNomeIgnoreCase(nomeLimpo)) {
            throw new RegraDeNegocioException("Já existe um produto com o nome " + nomeLimpo);
        }

        int estoque = (estoqueInicial == null) ? 0 : estoqueInicial;
        Produto novo = new Produto(null, nomeLimpo, preco, estoque);
        return produtoRepository.save(novo);
    }
}