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
import com.ceavi.repository.ClienteRepository;
import com.ceavi.repository.ItemPedidoRepository;
import com.ceavi.repository.PedidoRepository;
import com.ceavi.repository.ProdutoRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private ItemPedidoRepository itemPedidoRepo;
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@GetMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("CadastroPedido");
		Pedido pedido =  new Pedido();
		pedido.setCliente(new Cliente());
		mv.addObject("pedido",pedido); 
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarPedido(@ModelAttribute("pedido") Pedido pedido,@ModelAttribute("quantidade") String quantidade, @ModelAttribute("idProduto") String idProduto,@ModelAttribute("precoUnitario") String precoUnitario,@ModelAttribute("desconto") String desconto){
		ModelAndView mv = new ModelAndView("CadastroPedido");
		ItemPedido item = new ItemPedido();
		item.setProduto(produtoRepo.findById(Long.parseLong(idProduto)).get());
		item.setQuantidade(Integer.parseInt(quantidade));
		pedido.setCliente(clienteRepo.findByCpf(pedido.getCliente().getCpf()).get(0));
		if(desconto.isEmpty())
			desconto = "0";
		item.setDesconto(Double.parseDouble(desconto) + pedido.getCliente().getDescontoPorCliente());
		if(precoUnitario.isEmpty())
			item.setPrecoUnitario(item.getProduto().getPrecoVenda());
		else
			item.setPrecoUnitario(Double.parseDouble(precoUnitario));
		pedido = pedidoRepo.save(pedido);
		item.setPedido(pedido);
		item = itemPedidoRepo.save(item);
		mv.addObject("pedido", pedido);
		pedido.setItensPedido(itemPedidoRepo.findByPedido(pedido));
		mv.addObject("itensPedido",pedido.getItensPedido());
		return mv;
	}
	
	@GetMapping
	public ModelAndView listarPedidos() {
		ModelAndView mv = new ModelAndView("ListagemPedidos");
		mv.addObject("listaPedidos", pedidoRepo.findAll());
		return mv;
	}
	
	@RequestMapping("/remover/{id}")
	public String exclusao(@PathVariable long id){
		pedidoRepo.deleteById(id);
		return "redirect:/pedidos";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView edicao(@PathVariable long id){
		ModelAndView mv = new ModelAndView("CadastroPedido"); 
		mv.addObject("pedido", pedidoRepo.findById(id));
		mv.addObject("itensPedido",itemPedidoRepo.findByPedido(pedidoRepo.findById(id).get()));
		return mv;
	}

}
