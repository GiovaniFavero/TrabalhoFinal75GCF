package com.ceavi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceavi.model.Cliente;
import com.ceavi.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	

}
