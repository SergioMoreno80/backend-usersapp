package com.andres.backend.usersapp.backendusersapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.andres.backend.usersapp.backendusersapp.models.dto.ProveedorDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;
import com.andres.backend.usersapp.backendusersapp.services.ProveedorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin(originPatterns = "*")
public class ProveedorController {
	
    @Autowired
    private ProveedorService service;
    
    @GetMapping
 	public List<ProveedorDto> list(){
 		return service.findAll();
 	}
    
    @GetMapping("/{id}")
  	public ResponseEntity<?> show(@PathVariable Long id) {
  	   Optional<ProveedorDto> proveedorOptional = service.findById(id);
  	   if (proveedorOptional.isPresent()) {
  		   return ResponseEntity.ok(proveedorOptional.orElseThrow());
  	   }
  		return ResponseEntity.notFound().build();
  	}

     @PostMapping
     public ResponseEntity<?> create(
             @Valid @ModelAttribute ProveedorDto proveedor,
             BindingResult result) {
         if (result.hasErrors()) {
             return validation(result);
         }
         try {
             return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proveedor));
         } catch (Exception e) {
             String errorMessage = "Error al crear proveedor: " + e.getMessage();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
         }
     }

     @PutMapping("/{id}")
     public ResponseEntity<?> update(
  	        @PathVariable Long id,
  	        @Valid @ModelAttribute ProveedorDto proveedor,
  	        BindingResult result) {
         if(result.hasErrors()){
             return validation(result);
         }
         Optional<ProveedorDto> o = service.update(proveedor, id);

         if (o.isPresent()) {
             return ResponseEntity.status(HttpStatus.CREATED).body(o.orElseThrow());
         }
         return ResponseEntity.notFound().build();
     }

     
     @DeleteMapping("/{id}")
     public ResponseEntity<?> remove(@PathVariable Long id){
  	   Optional<ProveedorDto> o = service.findById(id);
  	   if (o.isPresent()) {
  		   service.remove(id);
  		   return ResponseEntity.noContent().build();
  	   }
         return ResponseEntity.notFound().build();

     }

     private ResponseEntity<?> validation(BindingResult result) {
         Map<String, String> errors = new HashMap<>();

         result.getFieldErrors().forEach(err -> {
             errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
         });
         return ResponseEntity.badRequest().body(errors);
     }
}
