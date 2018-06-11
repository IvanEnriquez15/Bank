package com.upc.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable{
	//Numero de cuenta
	// CCi
	//Saldo
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String numero;
	
	@NotNull
	private String cci;
	
	@NotNull
	private Long saldo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Banco banco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Movimiento> movimientos;
	
	@NotNull
	@Column(name = "creado")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creado;
	
	
	/*@PrePersist
	public void prePersist() {
		creado = new Date();
	}*/


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getCci() {
		return cci;
	}


	public void setCci(String cci) {
		this.cci = cci;
	}


	public Long getSaldo() {
		return saldo;
	}


	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}


	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Movimiento> getMovimientos() {
		return movimientos;
	}


	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}


	public Date getCreado() {
		return creado;
	}


	public void setCreado(Date creado) {
		this.creado = creado;
	}
	
	
}
