package com.ceavi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceavi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public java.util.List<Cliente> findByNome(String nome);

}
