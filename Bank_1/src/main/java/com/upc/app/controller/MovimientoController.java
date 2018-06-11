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
import com.upc.app.models.entity.Movimiento;
import com.upc.app.service.IClienteService;
import com.upc.app.service.ICuentaService;
import com.upc.app.service.IMovimientoService;

@Controller
@SessionAttributes("movimiento")
@RequestMapping("/movimiento/")
public class MovimientoController {
	
	@Autowired
	private IMovimientoService movimientoService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private ICuentaService cuentaService;
	
	private Cliente cliente;
	
	private Cuenta cuenta;
	
	@GetMapping("/list/{id}")
	public String listMovimiento(@PathVariable(value = "id") Long id,Model model) {			
		
		cliente=clienteService.fetchByIdWithMovimientos(id);
		model.addAttribute("movimientos",cliente.getMovimientos());
		model.addAttribute("cliente",cliente);
		return "movimiento/list";
	}
	@GetMapping("/listxCuenta/{id}")
	public String listxCuenta(@PathVariable(value = "id") Long id,Model model) {			
		
		cuenta=cuentaService.fetchByIdWithMovimientos(id);
		model.addAttribute("movimientos",cuenta.getMovimientos());
		model.addAttribute("cliente",cliente);
		return "movimiento/list";
	}
	
	
	
	@GetMapping(value = "/new/{id}")
	public String newMovimiento(@PathVariable(value = "id") Long id,Model model) {

		Movimiento movimiento = new Movimiento();
		cuenta =cuentaService.findById(id);
		model.addAttribute("movimiento", movimiento);
		model.addAttribute("cliente",cliente);
		model.addAttribute("cuenta",cuenta);
		return "movimiento/form";
	}

	@PostMapping(value = "/save")
	public String saveMovimiento(@Valid Movimiento movimiento, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "movimiento/form";
		}
		movimiento.setCliente(cliente);
		movimiento.setCuenta(cuenta);
		movimientoService.save(movimiento);
		status.setComplete();
		return "redirect:/cliente/list";
		
	}
}
