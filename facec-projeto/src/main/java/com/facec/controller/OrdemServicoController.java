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

import com.facec.dto.OrdemDto;
import com.facec.dto.VendaDto;
import com.facec.model.Cliente;
import com.facec.model.Ordem;
import com.facec.model.Produto;
import com.facec.model.Servico;
import com.facec.model.Tecnico;
import com.facec.model.Venda;
import com.facec.model.Vendedor;
import com.facec.repository.ClienteRepository;
import com.facec.repository.OrdemServicoRepository;
import com.facec.repository.ProdutoRepository;
import com.facec.repository.ServicoRepository;
import com.facec.repository.TecnicoRepository;
import com.facec.repository.VendaRepository;
import com.facec.repository.VendedorRepository;

@Controller
public class OrdemServicoController {
	List<Ordem> ordens= new ArrayList<>();
	Cliente cli;
	Tecnico tec;
	Servico serv;
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	TecnicoRepository tecRepo;
	
	@Autowired
	ServicoRepository servRepo;
	
	@Autowired
	OrdemServicoRepository ordemsRepo;
	
	@RequestMapping("Ordem/lista")
	public String iniciar(Model model,Ordem ordem) {
		model.addAttribute("mensagem", "Boas Vindas!");
		
		
		
		
		ordens =  ordemsRepo.findAll();
		model.addAttribute("ordem", ordens);
		
		
		
		return "Ordem/lista";
		
	}
	@GetMapping("Ordem/relatorio")
	public String abrirRelatorio(@PathParam(value = "id") Long id, Model model) {
		model.addAttribute("ordem", ordemsRepo.getById(id));
		
		return "Ordem/relatorio";
	}
	@RequestMapping("Ordem/formulario")
	public String abrirFormulario( Model model, Ordem ordem) {
		
		model.addAttribute("clientes", clienteRepo.findAll());
		
		model.addAttribute("tecnico", tecRepo.findAll());
		model.addAttribute("servico", servRepo.findAll());
		
		
		return "Ordem/formulario";
	}
	
	@PostMapping("Ordem/salvar")
	public String salvar(@Valid OrdemDto dto, BindingResult result, Model model, Ordem orden) {

		if(result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());	
			return abrirFormulario(model,orden);
		}
		try {
			ordemsRepo.save(dto.getEntity());

			return "redirect:/Ordem/lista";
		}catch (Exception e){
			
			return "redirect:/Ordem/formulario";
		}
			
	
			
		
		
		
	}
	@RequestMapping("Ordem/romaneio")
	public String romaneio(@PathParam(value = "id") Long id, Model model) {
		return "redirect:/Ordem/relatorio?id=" + id;
	}
}
