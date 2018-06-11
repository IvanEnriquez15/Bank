package com.upc.app.service;

import java.util.List;

import com.upc.app.models.entity.Movimiento;

public interface IMovimientoService {
	public List<Movimiento> findAll();

	public void save(Movimiento movimiento);

	public Movimiento findById(Long id);

	public void deleteById(Long id);
	
	public Movimiento fetchByIdWithCliente(Long id);
}
