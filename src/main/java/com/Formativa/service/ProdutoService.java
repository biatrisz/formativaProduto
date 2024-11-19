package com.Formativa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Formativa.entitie.Produto;
import com.Formativa.repository.ProdutoRepository;


@Service
public class ProdutoService {
	private  final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService (ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;		
	}
	
	
	public Produto salvarProduto (Produto produto)	{
		return produtoRepository.save(produto);
		}
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	public Optional<Produto> buscarPorId(Long id){
		return produtoRepository.findById(id);
	}
	public Produto atualizarProduto (Long id, Produto produto) {
		
		Optional<Produto> existeProduto = produtoRepository.findById(id);
		if (existeProduto.isPresent()) {
			produto.setId(id);
			return produtoRepository.save(produto);
			
		}
		return null;
	}
		
	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}

}
