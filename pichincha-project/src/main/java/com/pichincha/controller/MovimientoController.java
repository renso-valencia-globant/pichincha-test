package com.pichincha.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pichincha.request.CreateMovimientoRequest;
import com.pichincha.response.EstadoCuentaDto;
import com.pichincha.response.MovimientoResponse;
import com.pichincha.service.MovimientoService;
import com.pichincha.util.MessageApplication;
import static com.pichincha.util.MessageApplication.MSJ;
import static com.pichincha.util.MessageApplication.ERR;;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
@RestController
@RequestMapping("/api/movimiento")
public class MovimientoController {
	
	@Autowired
	MovimientoService movService;
	
	@GetMapping("/estadoCuenta")
	public ResponseEntity<?> getAll() {
		
		List<EstadoCuentaDto> movResponse = null;
		
		try {
			System.out.print("este es un mensaje inicio");
			movResponse = movService.getAll();
			System.out.print("este es un mensaje fin");
		} catch(NoSuchElementException nsex) {
			return new ResponseEntity<List<EstadoCuentaDto>>(movResponse, HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<List<EstadoCuentaDto>>(movResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<EstadoCuentaDto>>(movResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) {
		
		MovimientoResponse movResponse = null;
		
		try {
			movResponse = movService.getById(id);
		} catch(NoSuchElementException nsex) {
			return new ResponseEntity<MovimientoResponse>(movResponse, HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<MovimientoResponse>(movResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<MovimientoResponse>(movResponse, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateMovimientoRequest createCuentaRequest) {
		
		MovimientoResponse movResponse = null;
		
		try {
			movResponse = movService.create(createCuentaRequest);
		} catch(Exception e) {
			return new ResponseEntity<MovimientoResponse>(movResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<MovimientoResponse>(movResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateById(@RequestBody CreateMovimientoRequest createMovRequest, @PathVariable long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			if(movService.thereIsById(id)) {
				movService.updateById(createMovRequest, id);
				response.put(MSJ, MessageApplication.ERR_UPDATE_OK);
			} else {
				response.put(MSJ, MessageApplication.ERR_UPDATE_EXISTS);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch(DataAccessException ace) {
			response.put(MSJ, MessageApplication.ERR_UPDATE_NO_EXISTS.concat(String.valueOf(id)));
			response.put(ERR, ace.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(Exception e) {
			response.put(MSJ, MessageApplication.ERR_UPDATE_INTERNAL);
			response.put(ERR, e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/getById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			movService.deleteById(id);
			response.put(MSJ, MessageApplication.ERR_DELETE_OK);
		} catch(DataAccessException ace) {
			response.put(MSJ, MessageApplication.ERR_DELETE_NO_EXISTS.concat(String.valueOf(id))); 
			response.put(ERR, ace.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			response.put(MSJ, MessageApplication.ERR_DELETE_INTERNAL);
			response.put(ERR, e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}