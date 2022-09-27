package com.pichincha.response;

import java.util.Date;

public class EstadoCuentaDto {

	String nombre;
	String clave;
	String numero_cuenta;
	String tipo_cuenta;
	Double saldo; 
	Date fecha; 
	String tipoMovimiento; 
	Double saldoMovimiento;
	
	public EstadoCuentaDto(String nombre, String clave, String numero_cuenta, String tipo_cuenta, Double saldo,
			Date fecha, String tipoMovimiento, Double saldoMovimiento) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.numero_cuenta = numero_cuenta;
		this.tipo_cuenta = tipo_cuenta;
		this.saldo = saldo;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.saldoMovimiento = saldoMovimiento;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNumero_cuenta() {
		return numero_cuenta;
	}
	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}
	public String getTipo_cuenta() {
		return tipo_cuenta;
	}
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
	public Double getSaldoMovimiento() {
		return saldoMovimiento;
	}
	public void setSaldoMovimiento(Double saldoMovimiento) {
		this.saldoMovimiento = saldoMovimiento;
	}
}