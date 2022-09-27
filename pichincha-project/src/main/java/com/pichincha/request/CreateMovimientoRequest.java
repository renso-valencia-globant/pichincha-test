package com.pichincha.request;

import java.util.Date;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
public class CreateMovimientoRequest {

	private Long idCuenta;
	private Date fecha;
	private String tipoMovimiento;
	private String valor;
	private Double saldo;
	
	public CreateMovimientoRequest(Long idCuenta, Date fecha, String tipoMovimiento, String valor, Double saldo) {
		super();
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.saldo = saldo;
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