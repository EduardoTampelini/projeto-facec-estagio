package com.facec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexControlle {
	
	

		@RequestMapping("/")
		public String iniciar(Model model) {
			model.addAttribute("mensagem", "Welcome");
			
			
			
			return "index";
			
		}
		
		
}
