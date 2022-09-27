package com.pichincha.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pichincha.request.CreateMovimientoRequest;

@Entity
@Table(name = "movimiento")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_cuenta")
	private Long idCuenta;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	
	@Column(name = "valor")
	private String valor;
	 
	@Column(name = "saldo")
	private Double saldo;

	public Movimiento(CreateMovimientoRequest request) {
		this.idCuenta = request.getIdCuenta();
		this.fecha = request.getFecha();
		this.tipoMovimiento = request.getTipoMovimiento();
		this.valor = request.getValor();
		this.saldo = request.getSaldo();
	}
	
	public Movimiento(CreateMovimientoRequest request, Long id) {
		this(request);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
