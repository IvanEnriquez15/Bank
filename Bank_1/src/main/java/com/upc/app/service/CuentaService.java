package com.upc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.app.models.dao.ICuentaDAO;
import com.upc.app.models.entity.Cuenta;

@Service
public class CuentaService implements ICuentaService{

	@Autowired
	private ICuentaDAO dao;
	
	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Cuenta cuenta) {
		// TODO Auto-generated method stub
		dao.save(cuenta);
	}

	@Override
	public Cuenta findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Cuenta fetchByIdWithMovimientos(Long id) {
		// TODO Auto-generated method stub
		return dao.fetchByIdWithMovimientos(id);
	}

	
}
