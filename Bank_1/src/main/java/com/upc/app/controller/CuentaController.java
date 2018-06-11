package com.upc.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.upc.app.models.entity.Cliente;
import com.upc.app.models.entity.Cuenta;
import com.upc.app.service.IClienteService;
import com.upc.app.service.ICuentaService;

@Controller
@SessionAttributes("cuenta")
@RequestMapping("/cuenta/")
public class CuentaController {
	@Autowired
	private ICuentaService cuentaService;
	
	@Autowired
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	@GetMapping("/list/{id}")
	public String listCuenta(@PathVariable(value = "id") Long id,Model model) {	
		
		cliente=clienteService.fetchByIdWithCuentas(id);
		model.addAttribute("cuentas",cliente.getCuentas());
		model.addAttribute("cliente",cliente);
		return "cuenta/list";
	}

	@GetMapping(value = "/new")
	public String newCuenta(Model model) {

		Cuenta cuenta = new Cuenta();
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("cliente",cliente);
		return "cuenta/form";
	}

	@PostMapping(value = "/save")
	public String saveCuenta(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "cuenta/form";
		}
		cuenta.setCliente(cliente);
		//cuenta.setBanco(banco);
		cuentaService.save(cuenta);
		status.setComplete();
		return "redirect:/cliente/list";
		
	}
}
