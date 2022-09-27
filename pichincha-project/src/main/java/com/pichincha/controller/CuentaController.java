package com.pichincha.controller;

import java.util.HashMap;
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

import com.pichincha.request.CreateCuentaRequest;
import com.pichincha.response.CuentaResponse;
import com.pichincha.service.CuentaService;
import com.pichincha.util.MessageApplication;
import static com.pichincha.util.MessageApplication.MSJ;
import static com.pichincha.util.MessageApplication.ERR;;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) {
		
		CuentaResponse cuentaResponse = null;
		
		try {
			cuentaResponse = cuentaService.getById(id);
		} catch(NoSuchElementException nsex) {
			return new ResponseEntity<CuentaResponse>(cuentaResponse, HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<CuentaResponse>(cuentaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CuentaResponse>(cuentaResponse, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateCuentaRequest createCuentaRequest) {
		
		CuentaResponse cuentaResponse = null;
		
		try {
			cuentaResponse = cuentaService.create(createCuentaRequest);
		} catch(Exception e) {
			return new ResponseEntity<CuentaResponse>(cuentaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CuentaResponse>(cuentaResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateById(@RequestBody CreateCuentaRequest createCuentaRequest, @PathVariable long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			if(cuentaService.thereIsById(id)) {
				cuentaService.updateById(createCuentaRequest, id);
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
			cuentaService.deleteById(id);
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