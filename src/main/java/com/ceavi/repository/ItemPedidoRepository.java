package com.ceavi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ceavi.model.ItemPedido;
import com.ceavi.model.Pedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
	
	public java.util.List<ItemPedido> findByPedido(Pedido pedido);
	
}
