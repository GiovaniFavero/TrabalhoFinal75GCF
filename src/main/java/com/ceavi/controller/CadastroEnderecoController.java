package com.ceavi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ceavi.model.Cliente;
import com.ceavi.model.ItemPedido;
import com.ceavi.model.Pedido;
import com.ceavi.model.Produto;

@Controller
@RequestMapping("/enderecos")
public class CadastroEnderecoController {
	

	
	@GetMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("CadastroEndereco");
		//Novo.
		mv.addObject("cliente", new Cliente()); 
		return mv;
	}
	
	@PostMapping("/novo")
	public String salvarProduto(@ModelAttribute("cliente") Cliente cliente){
	//	clienteRepo.save(cliente);
		return "redirect:/clientes";
	}
	
	@RequestMapping("/remover/{id}")
	public String exclusao(@PathVariable long id){
		//clienteRepo.deleteById(id);
		return "redirect:/clientes";
	}
	
	@RequestMapping
	public ModelAndView listagemClientes(){
		ModelAndView mv = new ModelAndView("ListagemClientes");
		//mv.addObject("listaClientes", clienteRepo.findAll());
		return mv;
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView edicao(@PathVariable long id){
		ModelAndView mv = new ModelAndView("CadastroCliente"); 
		//mv.addObject("cliente", clienteRepo.findById(id)); 
		return mv;
	}




}
