package com.pichincha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pichincha.entity.Cuenta;
import com.pichincha.repository.CuentaRepository;
import com.pichincha.request.CreateCuentaRequest;
import com.pichincha.response.CuentaResponse;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
@Service
public class CuentaService {
	
	Logger logger = LoggerFactory.getLogger(CuentaService.class);
	
	@Autowired
	CuentaRepository cuentaRepository;
	
	public CuentaResponse create(CreateCuentaRequest createCuentaRequest) {
		Cuenta cuenta = this.buildCuenta(createCuentaRequest); 
		return new CuentaResponse(cuentaRepository.save(cuenta));
	}
	
	public CuentaResponse getById(long id) {
		
		logger.info("Get the client by id " + id);
		
		Cuenta cuenta = cuentaRepository.findById(id).get();
		
		return new CuentaResponse(cuenta);
	}
	
	public boolean thereIsById(long id) {
		
		logger.info("There is getById " + id);
		
		if(cuentaRepository.findById(id).isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	public void deleteById(long id) {
		
		logger.info("Delete ById " + id);
		cuentaRepository.deleteById(id);
	}

	public void updateById(CreateCuentaRequest updateCuentaRequest, long id) {
		
		logger.info("Update ById " + id);
		
		Cuenta cuenta = this.buildCuenta(updateCuentaRequest); 
		cuenta.setId(id); 
		
		Object data = cuentaRepository.save(cuenta);
		logger.error("data: " + data);
	}
	
	private Cuenta buildCuenta(CreateCuentaRequest createCuentaRequest) {
		Cuenta cuenta = new Cuenta();
		
		cuenta.setIdCliente(createCuentaRequest.getIdCliente());
		cuenta.setNumeroCuenta(createCuentaRequest.getNumeroCuenta());
		cuenta.setTipoCuenta(createCuentaRequest.getTipoCuenta());
		cuenta.setSaldo(createCuentaRequest.getSaldo());
		cuenta.setEstado(createCuentaRequest.getEstado());
		return cuenta;
	}
}
