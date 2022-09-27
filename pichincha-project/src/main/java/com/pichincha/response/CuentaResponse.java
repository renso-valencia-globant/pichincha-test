package com.pichincha.response;

import com.pichincha.entity.Cuenta;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
public class CuentaResponse {

	private Long idCuenta;
	private Long idCliente;
	private String numeroCuenta;
	private String tipoCuenta;
	private Double saldo;
	private Character estado;
	
	public CuentaResponse(Cuenta cuenta) {
		super();
		this.idCuenta = cuenta.getId();
		this.idCliente = cuenta.getIdCliente();
		this.numeroCuenta = cuenta.getNumeroCuenta();
		this.tipoCuenta = cuenta.getTipoCuenta();
		this.saldo = cuenta.getSaldo();
		this.estado = cuenta.getEstado();
	}
	
	public Long getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
}