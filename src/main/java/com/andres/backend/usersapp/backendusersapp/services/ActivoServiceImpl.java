package com.andres.backend.usersapp.backendusersapp.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.andres.backend.usersapp.backendusersapp.models.dto.ActivoDto;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperActivo;
import com.andres.backend.usersapp.backendusersapp.models.entities.Activo;
import com.andres.backend.usersapp.backendusersapp.models.entities.Configuracion;
import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;
import com.andres.backend.usersapp.backendusersapp.repositories.ActivoRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.ConfiguracionRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.ProveedorRepository;
import io.jsonwebtoken.io.IOException;

@Service
public class ActivoServiceImpl implements ActivoService {

	@Autowired
	private ActivoRepository repository;
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	private ConfiguracionRepository configRepository;


	@Override
	@Transactional(readOnly = true)
	public List<ActivoDto> findAll() {
		// return (List<Activo>) repository.findAll(); /// codigo anerior a
		// actualizacion 10 ene 2024
		List<Activo> activos = (List<Activo>) repository.findAll();
		return activos.stream().map(u -> DtoMapperActivo.builder().setActivo(u).build()).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ActivoDto> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(u -> DtoMapperActivo.builder().setActivo(u).build());
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Object[]> findAllActivosWithFabricanteAndProveedor(Pageable pageable) {
		return repository.findAllActivosWithFabricanteAndProveedor(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ActivoDto> findById(Long id) {
//		return repository.findById(id);

		return repository.findById(id).map(u -> DtoMapperActivo.builder().setActivo(u).build());

	}

	@Override
	@Transactional
	public ActivoDto save(ActivoDto activo) {
		Activo activoDb = new Activo();
		Boolean local = false;
		String directorioImagenes;
		String directorioDocs;
		Optional<Proveedor> optionalProveedor = proveedorRepository.findById(activo.getProveedor_id());
		Iterable<Configuracion> optionalConfig = configRepository.findAll();
		if (optionalConfig != null) {
		    Configuracion configuracion = optionalConfig.iterator().next();
		   local = configuracion.isLocal();
		    // Obtener la ruta de imágenes y documentos
		     directorioImagenes = configuracion.getRuta_imagen();
		     directorioDocs = configuracion.getRuta_docs();
		}else {
			directorioImagenes = "/Users/sergiomoreno/Documents/imagenes_activos/";
			directorioDocs = "/Users/sergiomoreno/Documents/doc_activos/";
		}
//		//rutina simple para manejo de archivos e imagenes para su alamacenamiento local o en aws, u otro servicio.
//		// Es necesario crear en base de datos las rutas configurables, crea una tabla de configuracion. Table: Configuracion
//		
//		if (local) {
//			directorioImagenes = "/Users/sergiomoreno/Documents/imagenes_activos/";
//			directorioDocs = "/Users/sergiomoreno/Documents/doc_activos/";
//		} else {
//			directorioImagenes = "/home/ec2-user/imagenes_activos/";
//			directorioDocs = "/home/ec2-user/doc_activos/";
//		}
		activoDb.setClave_busqueda(activo.getClave_busqueda());
		activoDb.setDescripcion(activo.getDescripcion());
		activoDb.setEstatus("A");
		activoDb.setFabricante_id(activo.getFabricante_id());
		activoDb.setFactura(activo.getFactura());
		activoDb.setFecha_compra(activo.getFecha_compra());
		activoDb.setFecha_ingreso(activo.getFecha_ingreso());
		activoDb.setGrupoactivo_id(activo.getGrupoactivo_id());
		activoDb.setImporte(activo.getImporte());
		activoDb.setModelo(activo.getModelo());
		activoDb.setNo_serie(activo.getModelo());
		activoDb.setNombre(activo.getNombre());
		activoDb.setProveedor(optionalProveedor.get());
		activoDb.setClasificacion(activo.getClasificacion());
		activoDb.setImagen(null);
		// Verifica si el directorio existe, si no, créalo
		Path pathDirectorio = Paths.get(directorioImagenes);
		if (!Files.exists(pathDirectorio)) {
			try {
				Files.createDirectories(pathDirectorio);
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Path pathDirectorioDoc = Paths.get(directorioDocs);
		if (!Files.exists(pathDirectorioDoc)) {
			try {
				Files.createDirectories(pathDirectorioDoc);
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Guardar la imagen en el directorio de imágenes
		Path rutaImagen = Paths.get(directorioImagenes + activo.getImagen().getOriginalFilename());
		Path rutaDoc = Paths.get(directorioDocs + activo.getDoc().getOriginalFilename());

		try {
			Files.write(rutaImagen, activo.getImagen().getBytes());
			Files.write(rutaDoc, activo.getDoc().getBytes());

		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		activoDb.setFoto(activo.getImagen().getOriginalFilename());
		activoDb.setDocumento(activo.getDoc().getOriginalFilename());

		return DtoMapperActivo.builder().setActivo(repository.save(activoDb)).build();

	}

	@Override
	@Transactional
	public ActivoDto saveWithImage(Activo activo, MultipartFile imagen) throws IOException {
		// Crear una instancia de Activo y establecer sus propiedades
		// Activo activo = new Activo();
		try {

			Optional<Proveedor> optionalProveedor = proveedorRepository
					.findById(activo.getProveedor().getProveedor_id());

			byte[] imagenBytes = imagen.getBytes();

			activo.setClave_busqueda(activo.getClave_busqueda());
			activo.setDescripcion(activo.getDescripcion());
			activo.setEstatus(activo.getEstatus());
			activo.setFabricante_id(activo.getFabricante_id());
			activo.setFactura(activo.getFactura());
			activo.setFecha_compra(activo.getFecha_compra());
			activo.setFecha_ingreso(activo.getFecha_ingreso());
			activo.setGrupoactivo_id(activo.getGrupoactivo_id());
			activo.setImporte(activo.getImporte());
			activo.setModelo(activo.getModelo());
			activo.setNo_serie(activo.getModelo());
			activo.setNombre(activo.getNombre());
			activo.setProveedor(optionalProveedor.get());
			activo.setClasificacion(activo.getClasificacion());
			activo.setImagen(imagenBytes);

		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return DtoMapperActivo.builder().setActivo(repository.save(activo)).build();

	}

	@Override
	@Transactional
	public Optional<ActivoDto> update(ActivoDto activo, Long id) {
//		Optional<Activo> o = this.findById(id);
//		Activo activoOptional = null;
//		   if(o.isPresent()) {
//			   Activo activoDB = o.orElseThrow();
//			   activoDB.setClave_busqueda(activo.getClave_busqueda());
//			   activoDB.setDescripcion(activo.getDescripcion());
//			   activoDB.setEstatus(activo.getEstatus());
//			   return Optional.of(this.save(activoDB));
//
//		   }
//		return Optional.ofNullable(activoOptional);

	
		Optional<Activo> o = repository.findById(id);
		Activo activoOptional = null;
		Boolean local = false;
		String directorioImagenes;
		String directorioDocs;
		Optional<Proveedor> optionalProveedor = proveedorRepository.findById(activo.getProveedor_id());
		Iterable<Configuracion> optionalConfig = configRepository.findAll();
		Path rutaImagen = null;
		Path rutaDoc = null;
		if (optionalConfig != null) {
		    Configuracion configuracion = optionalConfig.iterator().next();
		   local = configuracion.isLocal();
		    // Obtener la ruta de imágenes y documentos
		     directorioImagenes = configuracion.getRuta_imagen();
		     directorioDocs = configuracion.getRuta_docs();
		}else {
			directorioImagenes = "/Users/sergiomoreno/Documents/imagenes_activos/";
			directorioDocs = "/Users/sergiomoreno/Documents/doc_activos/";
		}
		if (o.isPresent()) {

			Activo activoDb = o.orElseThrow();
			activoDb.setNombre(activo.getNombre());
			activoDb.setDescripcion(activo.getDescripcion());
			activoDb.setClave_busqueda(activo.getClave_busqueda());
			activoDb.setEstatus(activo.getEstatus());
			activoDb.setFabricante_id(activo.getFabricante_id());
			activoDb.setFactura(activo.getFactura());
			activoDb.setFecha_compra(activo.getFecha_compra());
			activoDb.setFecha_ingreso(activo.getFecha_ingreso());
			activoDb.setGrupoactivo_id(activo.getGrupoactivo_id());
			activoDb.setImporte(activo.getImporte());
			activoDb.setModelo(activo.getModelo());
			activoDb.setNo_serie(activo.getNo_serie());
			activoDb.setProveedor(optionalProveedor.get());
			activoDb.setClasificacion(activo.getClasificacion());

			// Verifica si el directorio existe, si no, créalo
			Path pathDirectorio = Paths.get(directorioImagenes);
			if (!Files.exists(pathDirectorio)) {
				try {
					Files.createDirectories(pathDirectorio);
				} catch (java.io.IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Path pathDirectorioDoc = Paths.get(directorioDocs);
			if (!Files.exists(pathDirectorioDoc)) {
				try {
					Files.createDirectories(pathDirectorioDoc);
				} catch (java.io.IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(activo.getDoc()!= null) {
					//rutaDoc = Paths.get(directorioDocs + activo.getDoc().getOriginalFilename());
				  String extensionDoc = obtenerExtension(activo.getDoc().getOriginalFilename());
		          rutaDoc = Paths.get(directorioDocs + activo.getClave_busqueda() + extensionDoc);
				try {
					Files.write(rutaDoc, activo.getDoc().getBytes());
					activoDb.setDocumento(activo.getClave_busqueda() + extensionDoc);
				} catch (java.io.IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				activoDb.setDocumento(activo.getDocumento());
			}
			
			if(activo.getImagen()!= null) {
//			    rutaImagen = Paths.get(directorioImagenes + activo.getImagen().getOriginalFilename());
			    String extensionImagen = obtenerExtension(activo.getImagen().getOriginalFilename());
	            rutaImagen = Paths.get(directorioImagenes + activo.getClave_busqueda() + extensionImagen);
					try {
						Files.write(rutaImagen, activo.getImagen().getBytes());
						activoDb.setFoto(activo.getClave_busqueda() + extensionImagen);
					} catch (java.io.IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}else {
				activoDb.setFoto(activo.getFoto());
			}
			
			activoDb.setImagen(null);
			activoDb.setDoc(null);
			activoOptional = repository.save(activoDb);
		}
		return Optional.ofNullable(DtoMapperActivo.builder().setActivo(activoOptional).build());

	}
	
    public static String obtenerExtension(String nombreArchivo) {
        if (nombreArchivo == null || nombreArchivo.lastIndexOf('.') == -1) {
            return null; // O devuelve una cadena vacía, según lo que prefieras
        }
        return nombreArchivo.substring(nombreArchivo.lastIndexOf('.'));
    }

	@Override
	@Transactional
	public void remove(Long id) {
		repository.deleteById(id);
	}

}
