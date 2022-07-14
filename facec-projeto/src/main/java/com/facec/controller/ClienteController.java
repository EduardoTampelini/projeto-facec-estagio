package com.facec.controller;


import java.util.ArrayList;
import java.util.List;



import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facec.model.Cliente;
import com.facec.repository.ClienteRepository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Controller
//@RequestMapping("cliente")
public class ClienteController {
	List<Cliente> clientes= new ArrayList<>();
	 
	@Autowired
	ClienteRepository clienteRepo;
	
	@RequestMapping("Cliente/lista")
	public String iniciar(Model model,Cliente cliente) {
		model.addAttribute("mensagem", "Boas Vindas!");
		
		
		
		
		clientes =  clienteRepo.findAll();
		model.addAttribute("cliente", clientes);
		
		
		
		return "Cliente/lista";
		
	}
	@PostMapping("Cliente/consultar")
	public String consultar(String consultar, Model model) {
		model.addAttribute("mensagem", "Boas Vindas!");
		clientes =  clienteRepo.findByNomeContaining(consultar);
		model.addAttribute("cliente", clientes);
		
		
		return "Cliente/lista";
		
	}
	@GetMapping("Cliente/relatorio")
	public String abrirRelatorio(Model model) {
		model.addAttribute("cliente", clientes);
		
		return "Cliente/relatorio";
	}
	@GetMapping("Cliente/relatorioInt")
	public String abrirRelatorioInt(Model model) {
		model.addAttribute("cliente", clientes);
		
		return "Cliente/relatorioInt";
	}
	@GetMapping("Cliente/relatorioAt")
	public String abrirRelatorioAt(Model model) {
		model.addAttribute("cliente", clientes);
		
		return "Cliente/relatorioAt";
	}
	
	@RequestMapping("Cliente/formulario")
	public String abrirForm(Model model,Cliente cliente) {
		model.addAttribute("mensagem", "formulário");
		return "Cliente/formulario";
	}
	
	@PostMapping("Cliente/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result,Model model){

		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,cliente);
		}
		
		clienteRepo.save(cliente);	
		
		
		
		
		return "redirect:/Cliente/lista";
	}
	
	@GetMapping("Cliente/editar")
	public String editar(@PathParam(value="id")Long id, Model model){
		model.addAttribute("mensagem", "Formulario");		
	
		model.addAttribute("cliente",clienteRepo.getById(id));
		
		
		return "Cliente/formulario";
	}

	
	
	@GetMapping("Cliente/deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		clienteRepo.deleteById(id);
		
		
		return "redirect:/Cliente/lista";
	}
	@PostMapping("Cliente/editar/salvar")
	public String atualizar(@Valid Cliente cliente, BindingResult result,Model model){
				
		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,cliente);
		}	
		
		clienteRepo.save(cliente);	
		return "redirect:/Cliente/lista";
	}
	
	
}
