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

import com.facec.model.Tecnico;
import com.facec.repository.TecnicoRepository;
@Controller
public class TecnicoController {
	List<Tecnico> tecnicos= new ArrayList<>();
	 
	@Autowired
	TecnicoRepository tecRepo;
	
	@RequestMapping("Tecnico/lista")
	public String iniciar(Model model,Tecnico tecnico) {
		model.addAttribute("mensagem", "Boas Vindas!");
		
		
		
		
		tecnicos =  tecRepo.findAll();
		model.addAttribute("tecnico", tecnicos);
		
		
		
		return "Tecnico/lista";
		
	}
	@PostMapping("Tecnico/consultar")
	public String consultar(String consultar, Model model) {
		model.addAttribute("mensagem", "Boas Vindas!");
		tecnicos =  tecRepo.findByNomeContaining(consultar);
		model.addAttribute("tecnico", tecnicos);
		
		
		return "Tecnico/lista";
		
	}
	@GetMapping("Tecnico/relatorio")
	public String abrirRelatorio(Model model) {
		model.addAttribute("tecnico", tecnicos);
		
		return "Tecnico/relatorio";
	}
	@GetMapping("Tecnico/relatorioInt")
	public String abrirRelatorioInt(Model model) {
		model.addAttribute("tecnico", tecnicos);
		
		return "Tecnico/relatorioInt";
	}
	@GetMapping("Tecnico/relatorioAt")
	public String abrirRelatorioAt(Model model) {
		model.addAttribute("tecnico", tecnicos);
		
		return "Tecnico/relatorioAt";
	}
	@RequestMapping("Tecnico/formulario")
	public String abrirForm(Model model,Tecnico tecnico) {
		model.addAttribute("mensagem", "formulário");
		return "Tecnico/formulario";
	}
	
	@PostMapping("Tecnico/salvar")
	public String salvar(@Valid Tecnico tecnico, BindingResult result,Model model){

		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,tecnico);
		}
		
		tecRepo.save(tecnico);	
		
		
		
		
		return "redirect:/Tecnico/lista";
	}
	
	@GetMapping("Tecnico/editar")
	public String editar(@PathParam(value="id")Long id, Model model){
		model.addAttribute("mensagem", "Formulario");		
	
		model.addAttribute("tecnico",tecRepo.getById(id));
		
		
		return "Tecnico/formulario";
	}

	
	
	@GetMapping("Tecnico/deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		tecRepo.deleteById(id);
		
		
		return "redirect:/Tecnico/lista";
	}
	@PostMapping("Tecnico/editar/salvar")
	public String atualizar(@Valid Tecnico tecnico, BindingResult result,Model model){
				
		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,tecnico);
		}
		tecRepo.save(tecnico);	
		return "redirect:/Tecnico/lista";
	}
	
	
}
