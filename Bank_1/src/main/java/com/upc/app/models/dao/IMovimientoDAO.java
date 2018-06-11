package com.upc.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upc.app.models.entity.Movimiento;

@Repository
public interface IMovimientoDAO extends JpaRepository<Movimiento, Long>{
	
	@Query("select m from Movimiento m join fetch m.cliente c where m.id=?1")
	public Movimiento fetchByIdWithCliente(Long id);
}
