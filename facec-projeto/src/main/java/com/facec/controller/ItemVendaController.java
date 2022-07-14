package com.facec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facec.model.ItemVenda;
import com.facec.model.Produto;
import com.facec.repository.ItemVendaRepository;
import com.facec.repository.ProdutoRepository;

@Controller
public class ItemVendaController {
	List<Produto> produtos= new ArrayList<>();
	
	 
	@Autowired
	ProdutoRepository proRepo;
	@Autowired
	ItemVendaRepository itemRepo;
	
	@RequestMapping("ItemVenda/itens")
	public String iniciar(Model model,Produto produto) {
		model.addAttribute("mensagem", "Boas Vindas!");
		
		
		
		
		produtos =  proRepo.findAll();
		model.addAttribute("produto", produtos);
		
		
		
		return "ItemVenda/itens";
		
	}
	@GetMapping("ItemVenda/add")
	public String editar(@PathParam(value="id")Long id, Model model){
			
	
		System.out.println("teste");
		
		
		return "Venda/formulario";
	}

}
