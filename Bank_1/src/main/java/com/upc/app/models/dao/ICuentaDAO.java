package com.upc.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upc.app.models.entity.Cuenta;

@Repository
public interface ICuentaDAO extends JpaRepository<Cuenta, Long>{
	
	@Query("select c from Cuenta c left join fetch c.movimientos m where c.id=?1")
	public Cuenta fetchByIdWithMovimientos(Long id);
}
