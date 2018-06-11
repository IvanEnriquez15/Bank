package com.upc.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upc.app.models.entity.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Long>{
	
	@Query("select c from Cliente c left join fetch c.movimientos m where c.id=?1")
	public Cliente fetchByIdWithMovimientos(Long id);
	
	@Query("select c from Cliente c left join fetch c.cuentas u where c.id=?1")
	public Cliente fetchByIdWithCuentas(Long id);
}
