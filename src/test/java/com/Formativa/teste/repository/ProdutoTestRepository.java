package com.Formativa.teste.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Formativa.entitie.Produto;
import com.Formativa.repository.ProdutoRepository;

@DataJpaTest
class ProdutoTestRepository {

	@Autowired
	private ProdutoRepository produtoRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		Produto Produto1 = new Produto(null, "babyliss", "para cabelo", 200.00);
		Produto saveProduto = produtoRepository.save(Produto1);
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
	}

	@DisplayName("Testando Get para todos os Produtos")
	@Test
	void testGetAllRepository() {
		Produto Produto1 = new Produto(null, "babyliss", "para cabelo", 200.00);
		Produto Produto2 = new Produto(null, "blush", "para rosto", 50.00);
		produtoRepository.save(Produto1);
		produtoRepository.save(Produto2);
		List<Produto> ProdutoList = produtoRepository.findAll();
		assertNotNull(ProdutoList);
		assertEquals(2, ProdutoList.size());
	}

	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		Produto Produto1 = new Produto(null, "babyliss", "para cabelo", 200.00);
		produtoRepository.save(Produto1);
		Produto saveProduto = produtoRepository.findById(Produto1.getId()).get();
		assertNotNull(saveProduto);
		assertEquals(Produto1.getId(), saveProduto.getId());
	}

	@DisplayName("Testando Update")
	@Test
	void testUpdateProduto() {
		Produto Produto1 = new Produto(null, "babyliss", "para cabelo", 200.00);
		produtoRepository.save(Produto1);
		Produto saveProduto = produtoRepository.findById(Produto1.getId()).get();
		Produto1.setNome("babyliss");
		Produto1.setDescricao("para cabelo");
		Produto1.setPreco(200.00);
		Produto updateProduto = produtoRepository.save(saveProduto);
		assertNotNull(updateProduto);
		assertEquals("babyliss", updateProduto.getNome());
		assertEquals("para cabelo", updateProduto.getDescricao());
		assertEquals(200.00, updateProduto.getPreco());
	}

	@DisplayName("Testando Delete")
	@Test
	void testDeleteProduto() {
		Produto Produto1 = new Produto(null, "babyliss", "para cabelo", 200.00);
		produtoRepository.save(Produto1);
		produtoRepository.deleteById(Produto1.getId());
		Optional<Produto> ProdutoOptional = produtoRepository.findById(Produto1.getId());
		assertTrue(ProdutoOptional.isEmpty());
	}

}
