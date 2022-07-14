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
import com.facec.repository.ProdutoRepository;
@Controller
//@RequestMapping("cliente")
public class ProdutoController {
	List<Produto> produtos= new ArrayList<>();
	 
	@Autowired
	ProdutoRepository proRepo;
	
	@RequestMapping("Produto/lista")
	public String iniciar(Model model,Produto produto) {
		model.addAttribute("mensagem", "Boas Vindas!");
		
		
		
		
		produtos =  proRepo.findAll();
		model.addAttribute("produto", produtos);
		
		
		
		return "Produto/lista";
		
	}
	@PostMapping("Produto/consultar")
	public String consultar(String consultar, Model model) {
		model.addAttribute("mensagem", "Boas Vindas!");
		produtos =  proRepo.findByNomeContaining(consultar);
		model.addAttribute("produto", produtos);
		
		
		return "Produto/lista";
		
	}
	@GetMapping("Produto/relatorio")
	public String abrirRelatorio(Model model) {
		model.addAttribute("produto", produtos);
		
		return "Produto/relatorio";
	}
	@GetMapping("Produto/relatorioInt")
	public String abrirRelatorioInt(Model model) {
		model.addAttribute("produto", produtos);
		
		return "Produto/relatorioInt";
	}
	@GetMapping("Produto/relatorioAt")
	public String abrirRelatorioAt(Model model) {
		model.addAttribute("produto", produtos);
		
		return "Produto/relatorioAt";
	}
	@RequestMapping("Produto/formulario")
	public String abrirForm(Model model,Produto produto) {
		model.addAttribute("mensagem", "formulário");
		return "Produto/formulario";
	}
	
	@PostMapping("Produto/salvar")
	public String salvar(@Valid Produto produto, BindingResult result,Model model){

		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,produto);
		}
		
		proRepo.save(produto);	
		
		
		
		
		return "redirect:/Produto/lista";
	}
	
	@GetMapping("Produto/editar")
	public String editar(@PathParam(value="id")Long id, Model model){
		model.addAttribute("mensagem", "Formulario");		
	
		model.addAttribute("produto",proRepo.getById(id));
		
		
		return "Produto/formulario";
	}

	
	
	@GetMapping("Produto/deletar")
	public String deletar(@PathParam(value="id")Long id, Model model){
				
		
		proRepo.deleteById(id);
		
		
		return "redirect:/Produto/lista";
	}
	@PostMapping("Produto/editar/salvar")
	public String atualizar(@Valid Produto produto, BindingResult result,Model model){
				
		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirForm(model,produto);
		}
		proRepo.save(produto);	
		return "redirect:/Produto/lista";
	}
	
	
}
