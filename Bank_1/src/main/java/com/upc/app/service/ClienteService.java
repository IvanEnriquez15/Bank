package com.upc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.app.models.dao.IClienteDAO;
import com.upc.app.models.entity.Cliente;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteDAO dao;
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.save(cliente);
	}

	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Cliente fetchByIdWithMovimientos(Long id) {
		// TODO Auto-generated method stub
		return dao.fetchByIdWithMovimientos(id);
	}

	@Override
	public Cliente fetchByIdWithCuentas(Long id) {
		// TODO Auto-generated method stub
		return dao.fetchByIdWithCuentas(id);
	}

}
