package com.pichincha.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pichincha.entity.Movimiento;
import com.pichincha.repository.MovimientoRepository;
import com.pichincha.request.CreateMovimientoRequest;
import com.pichincha.response.EstadoCuentaDto;
import com.pichincha.response.MovimientoResponse;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
@Service
public class MovimientoService {
	
	Logger logger = LoggerFactory.getLogger(MovimientoService.class);
	
	@Autowired
	MovimientoRepository movRepository;
	
	
	
	public MovimientoResponse create(CreateMovimientoRequest request) {
		
		Movimiento mov = new Movimiento(request);
		return new MovimientoResponse(movRepository.save(mov));
	}
	
	public List<EstadoCuentaDto> getAll() { 
		System.out.print("segundo mensaje");
		try {
			return movRepository.findByEstadoCuenta();
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("error:", e.getMessage());
		}
		return null;
	}
	
	public MovimientoResponse getById(long id) {
		
		logger.info("Get the client by id " + id);
		Movimiento mov = movRepository.findById(id).get();
		return new MovimientoResponse(mov);
	}
	
	public boolean thereIsById(long id) {
		
		logger.info("There is getById " + id);
		
		if(movRepository.findById(id).isEmpty()) {
			return false;
		}
		return true;
	}
	
	public void deleteById(long id) {
		
		logger.info("Delete ById " + id);
		movRepository.deleteById(id);
	}

	public void updateById(CreateMovimientoRequest request, long id) {
		
		Movimiento mov = new Movimiento(request, id);
		movRepository.save(mov);
		logger.error("The process finish in the correct way");
	}
}
