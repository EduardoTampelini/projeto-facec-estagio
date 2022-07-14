package com.facec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.facec.dto.VendaDto;
import com.facec.model.Cliente;
import com.facec.model.Produto;
import com.facec.model.Venda;
import com.facec.model.Vendedor;
import com.facec.repository.ClienteRepository;
import com.facec.repository.ProdutoRepository;
import com.facec.repository.VendaRepository;
import com.facec.repository.VendedorRepository;

@Controller
public class VendaController {
	List<Venda> vendas= new ArrayList<>();
	Cliente cli;
	Vendedor v;
	Produto p;
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	VendedorRepository vendRepo;
	
	@Autowired
	ProdutoRepository proRepo;
	
	@Autowired
	VendaRepository vendaRepo;
	
	@RequestMapping("Venda/lista")
	public String iniciar(Model model,Venda venda) {
		model.addAttribute("mensagem", "Boas Vindas!");
		
		
		
		
		vendas =  vendaRepo.findAll();
		model.addAttribute("venda", vendas);
		
		
		
		return "Venda/lista";
		
	}
	@GetMapping("Venda/relatorio")
	public String abrirRelatorio(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("venda", vendaRepo.getById(id));
		
		return "Venda/relatorio";
	}
	@RequestMapping("Venda/formulario")
	public String abrirFormulario(Venda venda, Model model) {
		
		model.addAttribute("clientes", clienteRepo.findAll());
		
		model.addAttribute("vendedor", vendRepo.findAll());
		model.addAttribute("produto", proRepo.findAll());
		
		
		return "Venda/formulario";
	}
	
	@PostMapping("Venda/salvar")
	public String salvar(@Valid VendaDto dto, BindingResult result, Model model, Venda venda) {
		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirFormulario(venda,model);
		}
		
		try {
			vendaRepo.save(dto.getEntity());

			return "redirect:/Venda/lista";
		}catch (Exception e){
			
			return "redirect:/Venda/formulario";
		}
			
	
			
		
		
		
	}
	@RequestMapping("Venda/romaneio")
	public String romaneio(@PathParam(value = "id") Long id, Model model) {
		return "redirect:/Venda/relatorio?id=" + id;
	}
}
