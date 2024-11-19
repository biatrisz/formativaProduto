package com.Formativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Formativa.entitie.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
