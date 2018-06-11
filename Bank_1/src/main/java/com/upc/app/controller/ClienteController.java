package com.upc.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.upc.app.models.entity.Cliente;
import com.upc.app.service.IClienteService;


@Controller
@SessionAttributes("cliente")
@RequestMapping("/cliente/")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping(value = "/list")
	public String listCliente(Model model) {		
		model.addAttribute("clientes",clienteService.findAll());
		return "cliente/list";
	}

	@GetMapping(value = "/new")
	public String newCliente(Model model) {

		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/form";
	}

	@PostMapping(value = "/save")
	public String saveCliente(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "cliente/form";
		}	

		clienteService.save(cliente);
		status.setComplete();
		return "redirect:/cliente/list";
		
	}
}
