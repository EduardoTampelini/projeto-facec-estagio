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


import com.facec.model.Produto;
import com.facec.model.Servico;
import com.facec.repository.ProdutoRepository;
import com.facec.repository.ServicoRepository;
@Controller
public class ServicoController {
	List<Servico> servicos= new ArrayList<>();
	 
	@Autowired
	ServicoRepository servRepo;
	
	@RequestMapping("Servico/lista")
	public String iniciar(Model model,Servico servico) {
		model.addAttribute("mensagem", "Boas Vindas!");
		
		
		
		
		servicos =  servRepo.findAll();
		model.addAttribute("servico", servicos);
		
		
		
		return "Servico/lista";
		
	}
	@PostMapping("Servico/consultar")
	public String consultar(String consultar, Model model) {
		model.addAttribute("mensagem", "Boas Vindas!");
		servicos =  servRepo.findByNomeContaining(consultar);
		model.addAttribute("servico", servicos);
		
		
		return "Servico/lista";
		
	}
	@GetMapping("Servico/relatorio")
	public String abrirRelatorio(Model model) {
		model.addAttribute("servico", servicos);
		
		return "Servico/relatorio";
	}
	@GetMapping("Servico/relatorioInt")
	public String abrirRelatorioInt(Model model) {
		model.addAttribute("servico", servicos);
		
		return "Servico/relatorioInt";
	}
	@GetMapping("Servico/relatorioAt")
	public String abrirRelatorioAt(Model model) {
		model.addAttribute("servico", servicos);
		
		return "Servico/relatorioAt";
	}
	@RequestMapping("Servico/formulario")
	public String abrirForm(Model model,Servico servico) {
		model.addAttribute("mensagem", "formulário");
		return "Servico/formulario";
	}
	
	@PostMapping("Servico/salvar")
	public String salvar(@Valid Servico servico, BindingResult result,Model model){

		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,servico);
		}
		
		servRepo.save(servico);	
		
		
		
		
		return "redirect:/Servico/lista";
	}
	
	@GetMapping("Servico/editar")
	public String editar(@PathParam(value="id")Long id, Model model){
		model.addAttribute("mensagem", "Formulario");		
	
		model.addAttribute("servico",servRepo.getById(id));
		
		
		return "Servico/formulario";
	}

	
	
	@GetMapping("Servico/deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		servRepo.deleteById(id);
		
		
		return "redirect:/Servico/lista";
	}
	@PostMapping("Servico/editar/salvar")
	public String atualizar(@Valid Servico servico, BindingResult result,Model model){
				
		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,servico);
		}
		servRepo.save(servico);	
		return "redirect:/Servico/lista";
	}
	
	
}
