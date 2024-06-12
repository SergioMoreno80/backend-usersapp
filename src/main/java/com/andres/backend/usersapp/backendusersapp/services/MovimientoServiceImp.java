package com.andres.backend.usersapp.backendusersapp.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_inventarioDto;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperMovimiento;
import com.andres.backend.usersapp.backendusersapp.models.entities.Activo;
import com.andres.backend.usersapp.backendusersapp.models.entities.Departamentos;
import com.andres.backend.usersapp.backendusersapp.models.entities.Empleado;
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_detalle;
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_inventario;
import com.andres.backend.usersapp.backendusersapp.models.entities.Sucursales;
import com.andres.backend.usersapp.backendusersapp.repositories.ActivoRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.DepartamentosRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.EmpleadoRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.MovimientoDetRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.MovimientoRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.SucursalesRepository;

@Service
public class MovimientoServiceImp implements MovimientoService {

	@Autowired
	private MovimientoRepository repository;
	@Autowired
	private SucursalesRepository sucursalRepository;
	@Autowired
	private DepartamentosRepository departamentoRepository;
//
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private MovimientoDetRepository movimientoDetRep;
	
	@Autowired
	private ActivoRepository activoRepository;
//	@Autowired
//	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Movimientos_inventarioDto> findAll() {
		List<Movimientos_inventario> movimientos = (List<Movimientos_inventario>) repository.findAll();
		return movimientos.stream().map(u -> DtoMapperMovimiento.builder().setMovimiento(u).build()).collect(Collectors.toList());

	}

	@Override
	@Transactional(readOnly = true)
	public Page<Movimientos_inventarioDto> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(u -> DtoMapperMovimiento.builder().setMovimiento(u).build());

//		 Page<MovimientoInventario> movimientosPage = repository.findAll(pageable);
//	        return movimientosPage.map(MovimientoInventarioMapper.INSTANCE::toDTO);

	}

	@Override
	public Page<Movimientos_inventarioDto> obtenerMovimientos(Pageable pageable) {
		return repository.findAll(pageable).map(u -> DtoMapperMovimiento.builder().setMovimiento(u).build());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Movimientos_inventarioDto> findById(Long id) {
		return repository.findById(id).map(u -> DtoMapperMovimiento.builder().setMovimiento(u).build());

	}

	@Override
	@Transactional
	public Movimientos_inventarioDto save(Movimientos_inventarioDto movimiento) {

		Movimientos_inventario MovDb = new Movimientos_inventario();
		Optional<Empleado> optionalEmpleado = empleadoRepository.findById(Long.valueOf(movimiento.getEmpleado_id()));
		Optional<Sucursales> optionalSucursal = sucursalRepository.findById(Long.valueOf(optionalEmpleado.get().getSucursal_id()));
		Optional<Departamentos> optionalDepartamento = departamentoRepository.findById(Long.valueOf(optionalEmpleado.get().getDepartamento_id()));

		MovDb.setDescripcion(movimiento.getDescripcion());
		MovDb.setTipo_movimiento(movimiento.getTipo_movimiento());
		MovDb.setFecha_movimiento(movimiento.getFecha_movimiento());
		MovDb.setSucursales(optionalSucursal.get());
		MovDb.setDepartamentos(optionalDepartamento.get());
		MovDb.setEmpleado(optionalEmpleado.get());

//		MovDb.setEmpleado_id(movimiento.getEmpleado_id());
//		MovDb.setId_departamento(movimiento.getId_departamento());
		//MovDb.setId_sucursal(movimiento.getId_sucursal());
		MovDb.setUser_id(movimiento.getUser_id());
		if (movimiento.getDoc() != null) {
			String directorio = "/Users/sergiomoreno/Documents/docs_movimientos/";

			// Verifica si el directorio existe, si no, créalo
			Path pathDirectorio = Paths.get(directorio);
			if (!Files.exists(pathDirectorio)) {
				try {
					Files.createDirectories(pathDirectorio);
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			}

			// Guardar la imagen en el directorio de imágenes
			Path rutaDoc = Paths.get(directorio + movimiento.getDoc().getOriginalFilename());
			try {
				Files.write(rutaDoc, movimiento.getDoc().getBytes());
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
			MovDb.setDocumento(movimiento.getDoc().getOriginalFilename());
		}
		MovDb.setDoc(null);
		return DtoMapperMovimiento.builder().setMovimiento(repository.save(MovDb)).build();

	}

	@Override
	@Transactional
	public Optional<Movimientos_inventarioDto> update(Movimientos_inventarioDto movimiento, Long id) {

		Optional<Movimientos_inventario> o = repository.findById(id);
		Movimientos_inventario movOptional = null;
		if (o.isPresent()) {
			Movimientos_inventario MovDb = o.orElseThrow();
			MovDb.setDescripcion(movimiento.getDescripcion());
			MovDb.setFecha_movimiento(movimiento.getFecha_movimiento());
			MovDb.setTipo_movimiento(movimiento.getTipo_movimiento());
			MovDb.setUser_id(movimiento.getUser_id());
//			MovDb.setEmpleado_id(movimiento.getEmpleado_id());
//			MovDb.setId_departamento(movimiento.getId_departamento());
			//MovDb.setId_sucursal(movimiento.getId_sucursal());

			movOptional = repository.save(MovDb);
		}
		return Optional.ofNullable(DtoMapperMovimiento.builder().setMovimiento(movOptional).build());
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
	}

	@Override
    @Transactional(readOnly = true)
    public List<Movimientos_inventario> findByActivoId(Long activo_id) {
        return repository.findByActivoId(activo_id);
      
    }
    
    public List<Movimientos_inventario> obtenerMovimientosPorActivo(Long activo_id) {
//        List<Movimientos_detalle> detalles = movimientoDetRep.findByActivo(activo_id);
//        return detalles.stream().map(Movimientos_detalle::getMovimiento).collect(Collectors.toList());
    	Optional<Activo> optionalActivo = activoRepository.findById(activo_id);
        if (optionalActivo.isPresent()) {
            List<Movimientos_detalle> detalles = movimientoDetRep.findByActivo(optionalActivo.get());
            return detalles.stream().map(Movimientos_detalle::getMovimiento).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


}
