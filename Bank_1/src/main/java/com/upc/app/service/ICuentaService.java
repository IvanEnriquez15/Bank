package com.upc.app.service;

import java.util.List;

import com.upc.app.models.entity.Cuenta;

public interface ICuentaService {
	public List<Cuenta> findAll();

	public void save(Cuenta cuenta);

	public Cuenta findById(Long id);

	public void deleteById(Long id);
	public Cuenta fetchByIdWithMovimientos(Long id);
}
