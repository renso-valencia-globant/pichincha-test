package com.pichincha.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.entity.Cliente;
import com.pichincha.entity.Persona;
import com.pichincha.repository.ClienteRepository;
import com.pichincha.request.CreateClienteRequest;
import com.pichincha.response.ClienteResponse;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
@Service
public class ClienteService {
	
	Logger logger = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	public ClienteResponse create(CreateClienteRequest createClienteRequest) {
		Cliente cliente = new Cliente();
		
		cliente.setPersonaId(new Persona()); 
		cliente.getPersonaId().setNombre(createClienteRequest.getNombre());
		cliente.getPersonaId().setGenero(createClienteRequest.getGenero()); 
		cliente.getPersonaId().setEdad(createClienteRequest.getEdad());
		cliente.getPersonaId().setIdentificacion(createClienteRequest.getIdentificacion());
		cliente.getPersonaId().setDireccion(createClienteRequest.getDireccion());
		cliente.getPersonaId().setTelefono(createClienteRequest.getTelefono());
		cliente.setEstado(createClienteRequest.getEstado());
		cliente.setClave(createClienteRequest.getClave());
		return new ClienteResponse(clienteRepository.save(cliente));
	}
	
	public ClienteResponse getById(long id) {
		
		logger.info("Get the client by id " + id);
		
		Cliente cliente = clienteRepository.findById(id).get();
		
		return new ClienteResponse(cliente);
	}
	
	public List<ClienteResponse> getAll() {
		return clienteRepository.findAll().stream().map(
				d -> new ClienteResponse(d)
				).collect(Collectors.toList());
	}
	
	public boolean thereIsById(long id) {
		
		logger.info("There is getById " + id);
		
		if(clienteRepository.findById(id).isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	public void deleteById(long id) {
		
		logger.info("Delete ById " + id);
		clienteRepository.deleteById(id);
	}

	public void updateById(CreateClienteRequest updateClienteRequest, long id) {
		
		logger.info("Update ById " + id);
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setClave(updateClienteRequest.getClave());
		cliente.setEstado(updateClienteRequest.getEstado());
		cliente.setPersonaId(new Persona(id)); 
		cliente.getPersonaId().setNombre(updateClienteRequest.getNombre());
		cliente.getPersonaId().setGenero(updateClienteRequest.getGenero()); 
		cliente.getPersonaId().setEdad(updateClienteRequest.getEdad());
		cliente.getPersonaId().setIdentificacion(updateClienteRequest.getIdentificacion());
		cliente.getPersonaId().setDireccion(updateClienteRequest.getDireccion());
		cliente.getPersonaId().setTelefono(updateClienteRequest.getTelefono());
		
		Object data = clienteRepository.save(cliente);
		logger.error("data: " + data);
		
	}
}
