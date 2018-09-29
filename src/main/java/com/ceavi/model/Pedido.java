package com.ceavi.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private long id;
	
	private Cliente cliente;
	
	private List<ItemPedido> itensPedido;
	
	public Pedido() {
		this.itensPedido = new ArrayList<ItemPedido>();
	}
	
	public void addItemPedido(ItemPedido item) {
		this.itensPedido.add(item);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	
	public double totalPedido() {
		double resultado = 0;
		for(ItemPedido item: this.getItensPedido()) {
			resultado = (item.getPrecoUnitario() * item.getQuantidade()) - item.getDesconto(); 
		}
		return resultado;
	}
	
	

}
