package com.pichincha.response;

import com.pichincha.entity.Cliente;

/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
public class ClienteResponse {

	private long clienteId;
	private String nombre;
	private Character genero;
	private Integer edad;
	private String identificacion;
	private String direccion;
	private String telefono;
	private String clave;
	private Character estado;
	
	public ClienteResponse(Cliente cliente) {
		super();
		this.clienteId = cliente.getId();
		this.nombre = cliente.getPersonaId().getNombre();
		this.genero = cliente.getPersonaId().getGenero();
		this.edad = cliente.getPersonaId().getEdad();
		this.identificacion = cliente.getPersonaId().getIdentificacion();
		this.direccion = cliente.getPersonaId().getDireccion();
		this.telefono = cliente.getPersonaId().getTelefono();
		this.clave = cliente.getClave();
		this.estado = cliente.getEstado();
	}
	public long getClienteId() {
		return clienteId;
	}
	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
	
	
}