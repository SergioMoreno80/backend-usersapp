package com.andres.backend.usersapp.backendusersapp.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_detalleDto;
import com.andres.backend.usersapp.backendusersapp.services.MovimientoDetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/detalles")
@CrossOrigin(originPatterns = "*")
public class MovimientosDetalleController {

	@Autowired
	private MovimientoDetService service;

	@PostMapping
	   public ResponseEntity<?> create(
			   @Valid @ModelAttribute Movimientos_detalleDto detalle,
			   BindingResult result) {
	       if(result.hasErrors()){
	           return validation(result);
	       }
	       return ResponseEntity.status(HttpStatus.CREATED).body(service.save(detalle));
	   }

	   private ResponseEntity<?> validation(BindingResult result) {
	       Map<String, String> errors = new HashMap<>();

	       result.getFieldErrors().forEach(err -> {
	           errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
	       });
	       return ResponseEntity.badRequest().body(errors);
	   }
}
