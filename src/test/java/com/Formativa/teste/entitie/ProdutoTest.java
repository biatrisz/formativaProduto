package com.Formativa.teste.entitie;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.Formativa.entitie.Produto;


class ProdutoTest {
	private Produto produto;
	@BeforeEach
	void setUp() {
		produto = new Produto(1L, "babyliss", "para cabelo", 200.00);
	}
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testGetSetId() {
		//Act
		produto.setId(2L);
		//Assert
		assertEquals(2L,produto.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testGetSetNome () {
		//Act
		produto.setNome("babyliss");
		//Assert
		assertEquals("babyliss", produto.getNome());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testGetSetDescricao () {
		//Act
		produto.setDescricao("para cabelo");
		//Assert
		assertEquals("para cabelo", produto.getDescricao());

	}@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testGetSetPreco () {
		//Act
		produto.setPreco(200.00);
		//Assert
		assertEquals(200.00, produto.getPreco());
	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testProdutoConstructor() {
		Produto novoProduto = new Produto(1L,"babyliss", "para cabelo", 200.00);
		assertAll("novoHospede",()-> assertEquals(1L, novoProduto.getId()),
				()-> assertEquals("babyliss", novoProduto.getNome()),
				()-> assertEquals("para cabelo", novoProduto.getDescricao()),
				()-> assertEquals(200.00, novoProduto.getPreco()));
}

}
