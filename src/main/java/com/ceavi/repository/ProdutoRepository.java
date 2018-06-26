package com.ceavi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceavi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public java.util.List<Produto> findByDescricao(String descricao);
}
