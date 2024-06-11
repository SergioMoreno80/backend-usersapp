package com.andres.backend.usersapp.backendusersapp.models.dto.mapper;
import com.andres.backend.usersapp.backendusersapp.models.dto.ProveedorDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;

public class DtoMapperProveedor {
	 private Proveedor proveedor;

	    private DtoMapperProveedor() {
	    }

	    public static DtoMapperProveedor builder() {
	        return new DtoMapperProveedor();
	    }

	    public DtoMapperProveedor setProveedor(Proveedor proveedor) {
	        this.proveedor = proveedor;
	        return this;
	    }

	    public ProveedorDto build() {
	        if (proveedor == null) {
	            throw new RuntimeException("Debe pasar el entity !");
	        }
	        //boolean isAdmin = user.getRoles().stream().anyMatch(r -> "ROLE_ADMIN".equals(r.getName()));
	        return new ProveedorDto(this.proveedor.getProveedor_id(), proveedor.getNombre(),
	        		proveedor.getDescripcion(),
	        		proveedor.getEstatus()//,
//	        		proveedor.getClave_busqueda()
	        		);

	    }

}
