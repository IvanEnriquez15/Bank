package com.upc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.app.models.dao.IMovimientoDAO;
import com.upc.app.models.entity.Movimiento;

@Service
public class MovimientoService implements IMovimientoService{

	@Autowired
	private IMovimientoDAO dao;
	
	@Override
	public List<Movimiento> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void save(Movimiento movimiento) {
		// TODO Auto-generated method stub
		dao.save(movimiento);
	}

	@Override
	public Movimiento findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Movimiento fetchByIdWithCliente(Long id) {
		// TODO Auto-generated method stub
		return dao.fetchByIdWithCliente(id);
	}

	
}
