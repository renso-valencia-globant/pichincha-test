package com.pichincha.request;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
public class CreateCuentaRequest {

	private Long idCliente;
	private String numeroCuenta;
	private String tipoCuenta;
	private Double saldo;
	private Character estado;
	
	public CreateCuentaRequest(Long idCliente, String numeroCuenta, String tipoCuenta, Double saldo,
			Character estado) {
		super();
		this.idCliente = idCliente;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.estado = estado;
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