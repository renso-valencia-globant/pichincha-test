package com.pichincha.response;

import java.util.Date;

import com.pichincha.entity.Movimiento;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
public class MovimientoResponse {

	private Long idCuenta;
	private Long idMovimiento;
	private Date fecha;
	private String tipoMovimiento;
	private String valor;
	private Double saldo;

	public MovimientoResponse(Movimiento mov) {
		super();
		this.idCuenta = mov.getIdCuenta();
		this.idMovimiento = mov.getId();
		this.fecha = mov.getFecha();
		this.tipoMovimiento = mov.getTipoMovimiento();
		this.valor = mov.getValor();
		this.saldo = mov.getSaldo();
	}
	public Long getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}
	public Long getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(Long idMovimiento) {
		this.idMovimiento = idMovimiento;
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