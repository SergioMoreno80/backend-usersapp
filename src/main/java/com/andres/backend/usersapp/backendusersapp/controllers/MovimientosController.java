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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_inventarioDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Departamentos;
import com.andres.backend.usersapp.backendusersapp.models.entities.Empleado;
import com.andres.backend.usersapp.backendusersapp.models.entities.Sucursales;
import com.andres.backend.usersapp.backendusersapp.services.DepartamentosService;
import com.andres.backend.usersapp.backendusersapp.services.EmpleadoService;
import com.andres.backend.usersapp.backendusersapp.services.MovimientoService;
import com.andres.backend.usersapp.backendusersapp.services.SucursalesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimientos")
@CrossOrigin(originPatterns = "*")
public class MovimientosController {

	@Autowired
	private MovimientoService service;

	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private SucursalesService sucursalesService;
	@Autowired
	private DepartamentosService departamentosService;


	 @GetMapping("/page/{page}")
	   public Page<Movimientos_inventarioDto> list(@PathVariable Integer page) {
	       Pageable pageable = PageRequest.of(page, 5);
	       return service.findAll(pageable);
	   }

//	   @GetMapping(name = "getActivosPageable", params = {"page", "size"})
//	   public ResponseEntity<Page<Object[]>> getMovimientos(Pageable pageable) {
//	       Page<Object[]> activos = service.findAllActivosWithFabricanteAndProveedor(pageable);
//	       return ResponseEntity.ok(activos);
//	   }

	   @GetMapping("/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {
		   Optional<Movimientos_inventarioDto> movimientoOptional = service.findById(id);
		   if (movimientoOptional.isPresent()) {
			   return ResponseEntity.ok(movimientoOptional.orElseThrow());
		   }
			return ResponseEntity.notFound().build();
		}
	@RequestMapping("/cargaEmpleados")
	@ResponseBody
	public List<Empleado> ListaEmleados() {
		return empleadoService.findAll();
	}

	@RequestMapping("/cargaSucursales")
	@ResponseBody
	public List<Sucursales> ListaSucursales() {
		return sucursalesService.findAll();
	}

	@RequestMapping("/cargaDepartamentos")
	@ResponseBody
	public List<Departamentos> ListaDepartamentos() {
		return departamentosService.findAll();
	}

	 @PostMapping
	   //(consumes = {"multipart/form-data"})
	   public ResponseEntity<?> create(
			   @Valid @ModelAttribute Movimientos_inventarioDto movimiento,
			   BindingResult result) {
	       if(result.hasErrors()){
	           return validation(result);
	       }
	       return ResponseEntity.status(HttpStatus.CREATED).body(service.save(movimiento));
	   }

	   private ResponseEntity<?> validation(BindingResult result) {
	       Map<String, String> errors = new HashMap<>();

	       result.getFieldErrors().forEach(err -> {
	           errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
	       });
	       return ResponseEntity.badRequest().body(errors);
	   }

//	   @GetMapping("/{movimientoId}")
//	    public ResponseEntity<List<Object[]>> getMovimientoDetallesAndNames(@PathVariable Long movimientoId) {
//	        List<Object[]> movimientosDetallesAndNames = service.findAllMovimientosDetallesAndNames(movimientoId);
//	        return ResponseEntity.ok().body(movimientosDetallesAndNames);
//	    }
//

}
