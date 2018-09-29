package com.ceavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ceavi.model.Produto;

@Controller
@RequestMapping("/bancos")
public class CadastroBancoController {
	
	
	@GetMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("CadastroBanco"); 
		mv.addObject("produto", new Produto()); 
		return mv;
	}
	
	@PostMapping("/novo")
	public String salvarProduto(@ModelAttribute("produto") Produto produto){
		//produtoRepo.save(produto);
		return "redirect:/produtos";
	}
	
	@RequestMapping("/remover/{id}")
	public String exclusao(@PathVariable long id){
		//produtoRepo.deleteById(id);
		return "redirect:/produtos";
	}
	
	@RequestMapping
	public ModelAndView listagemProdutos(){
		ModelAndView mv = new ModelAndView("ListagemProdutos");
		//mv.addObject("listaProdutos", produtoRepo.findAll());
		return mv;
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView edicao(@PathVariable long id){
		ModelAndView mv = new ModelAndView("CadastroProduto"); 
	//	mv.addObject("produto", produtoRepo.findById(id)); 
		return mv;
	}




}
