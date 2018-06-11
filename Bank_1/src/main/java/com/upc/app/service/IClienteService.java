package com.upc.app.service;

import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

import com.upc.app.models.entity.Cliente;


public interface IClienteService {
	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Cliente findById(Long id);

	public void deleteById(Long id);

	public Cliente fetchByIdWithMovimientos(Long id);
	
	public Cliente fetchByIdWithCuentas(Long id);

	//public Page<Cliente> findAll(Pageable pageable);
}
