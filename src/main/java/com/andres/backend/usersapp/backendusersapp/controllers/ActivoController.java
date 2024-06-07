package com.andres.backend.usersapp.backendusersapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.andres.backend.usersapp.backendusersapp.models.dto.ActivoDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Fabricante;
import com.andres.backend.usersapp.backendusersapp.models.entities.Grupoactivo;
import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;
import com.andres.backend.usersapp.backendusersapp.services.ActivoService;
import com.andres.backend.usersapp.backendusersapp.services.FabricanteService;
import com.andres.backend.usersapp.backendusersapp.services.GrupoactivoService;
import com.andres.backend.usersapp.backendusersapp.services.ProveedorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/activos")
@CrossOrigin(originPatterns = "*")
public class ActivoController {

	@Autowired
	private ActivoService service;
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private FabricanteService fabricanteService;
	@Autowired
	private GrupoactivoService grupoactivoService;

   @GetMapping
	public List<ActivoDto> list(){
		return service.findAll();
	}

   @GetMapping("/page/{page}")
   public Page<ActivoDto> list(@PathVariable Integer page) {
       Pageable pageable = PageRequest.of(page, 5);
       return service.findAll(pageable);
   }

   @GetMapping("/pageable/{page}")
   public ResponseEntity<Page<Object[]>> getAllActivosPageable(@PathVariable int page, Pageable pageable) {
       Page<Object[]> activos = service.findAllActivosWithFabricanteAndProveedor(pageable);
       return ResponseEntity.ok(activos);
   }

   @GetMapping(name = "getActivosPageable", params = {"page", "size"})
   public ResponseEntity<Page<Object[]>> getActivos(Pageable pageable) {
       Page<Object[]> activos = service.findAllActivosWithFabricanteAndProveedor(pageable);
       return ResponseEntity.ok(activos);
   }

   @GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
	   Optional<ActivoDto> activoOptional = service.findById(id);
	   if (activoOptional.isPresent()) {
		   return ResponseEntity.ok(activoOptional.orElseThrow());
	   }
		return ResponseEntity.notFound().build();
	}

   @PostMapping
   public ResponseEntity<?> create(
           @Valid @ModelAttribute ActivoDto activo,
           BindingResult result) {
       if (result.hasErrors()) {
           return validation(result);
       }
       try {
           return ResponseEntity.status(HttpStatus.CREATED).body(service.save(activo));
       } catch (Exception e) {
           String errorMessage = "Error al crear activo: " + e.getMessage();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
       }
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> update(
	        @PathVariable Long id,
	        @Valid @ModelAttribute ActivoDto activo,
	        BindingResult result,
	        @RequestParam(value = "imagen", required = false) MultipartFile imagen,
	        @RequestParam(value = "doc", required = false) MultipartFile doc) {
       if(result.hasErrors()){
           return validation(result);
       }
       Optional<ActivoDto> o = service.update(activo, id);

       if (o.isPresent()) {
           return ResponseEntity.status(HttpStatus.CREATED).body(o.orElseThrow());
       }
       return ResponseEntity.notFound().build();
   }

   
   @DeleteMapping("/{id}")
   public ResponseEntity<?> remove(@PathVariable Long id){
	   Optional<ActivoDto> o = service.findById(id);
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

	@RequestMapping("/cargaFabricante")
	@ResponseBody
	public List<Fabricante> ListaFabricante() {
		return fabricanteService.findAll();
	}

	@RequestMapping("/cargaProveedor")
	@ResponseBody
	public List<Proveedor> ListaProveedor() {
		return proveedorService.findAll();
	}
	@RequestMapping("/cargaGrupoActivo")
	@ResponseBody
	public List<Grupoactivo> ListaGrupoactivo() {
		return grupoactivoService.findAll();
	}


}
