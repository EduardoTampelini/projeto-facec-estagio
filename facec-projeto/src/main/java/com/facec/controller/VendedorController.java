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


import com.facec.model.Vendedor;
import com.facec.repository.VendedorRepository;
@Controller
public class VendedorController {
	List<Vendedor> vendedores= new ArrayList<>();
	 
	@Autowired
	VendedorRepository vendRepo;
	
	@RequestMapping("Vendedor/lista")
	public String iniciar(Model model,Vendedor vendedor) {
		model.addAttribute("mensagem", "Boas Vindas!");
		
		
		
		
		vendedores =  vendRepo.findAll();
		model.addAttribute("vendedor", vendedores);
		
		
		
		return "Vendedor/lista";
		
	}
	@PostMapping("Vendedor/consultar")
	public String consultar(String consultar, Model model) {
		model.addAttribute("mensagem", "Boas Vindas!");
		vendedores =  vendRepo.findByNomeContaining(consultar);
		model.addAttribute("vendedor", vendedores);
		
		
		return "Vendedor/lista";
		
	}
	@GetMapping("Vendedor/relatorio")
	public String abrirRelatorio(Model model) {
		model.addAttribute("vendedor", vendedores);
		
		return "Vendedor/relatorio";
	}
	@GetMapping("Vendedor/relatorioInt")
	public String abrirRelatorioInt(Model model) {
		model.addAttribute("vendedor", vendedores);
		
		return "Vendedor/relatorioInt";
	}
	@GetMapping("Vendedor/relatorioAt")
	public String abrirRelatorioAt(Model model) {
		model.addAttribute("vendedor", vendedores);
		
		return "Vendedor/relatorioAt";
	}
	@RequestMapping("Vendedor/formulario")
	public String abrirForm(Model model,Vendedor vendedor) {
		model.addAttribute("mensagem", "formulário");
		return "Vendedor/formulario";
	}
	
	@PostMapping("Vendedor/salvar")
	public String salvar(@Valid Vendedor vendedor, BindingResult result,Model model){

		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,vendedor);
		}
		
		vendRepo.save(vendedor);	
		
		
		
		
		return "redirect:/Vendedor/lista";
	}
	
	@GetMapping("Vendedor/editar")
	public String editar(@PathParam(value="id")Long id, Model model){
		model.addAttribute("mensagem", "Formulario");		
	
		model.addAttribute("vendedor",vendRepo.getById(id));
		
		
		return "Vendedor/formulario";
	}

	
	
	@GetMapping("Vendedor/deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		vendRepo.deleteById(id);
		
		
		return "redirect:/Vendedor/lista";
	}
	@PostMapping("Vendedor/editar/salvar")
	public String atualizar(@Valid Vendedor vendedor, BindingResult result,Model model){
				
		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,vendedor);
		}
		vendRepo.save(vendedor);	
		return "redirect:/Vendedor/lista";
	}
	
	
}
