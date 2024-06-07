package com.andres.backend.usersapp.backendusersapp.models.dto.mapper;
import com.andres.backend.usersapp.backendusersapp.models.dto.ActivoDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Activo;

public class DtoMapperActivo {


    private Activo activo;

    private DtoMapperActivo() {
    }

    public static DtoMapperActivo builder() {
        return new DtoMapperActivo();
    }

    public DtoMapperActivo setActivo(Activo activo) {
        this.activo = activo;
        return this;
    }

    public ActivoDto build() {
        if (activo == null) {
            throw new RuntimeException("Debe pasar el entity !");
        }
        //boolean isAdmin = user.getRoles().stream().anyMatch(r -> "ROLE_ADMIN".equals(r.getName()));
        return new ActivoDto(this.activo.getActivo_id(), activo.getNombre(),
               		activo.getDescripcion(),
        		activo.getFabricante_id(),
        		activo.getModelo(),
        		activo.getNo_serie(),
        		activo.getClasificacion(),
        		activo.getGrupoactivo_id(),
        		activo.getProveedor().getProveedor_id(),
        		activo.getFactura(),
        		activo.getFecha_compra(),activo.getImporte(),
        		activo.getFecha_ingreso(), activo.getEstatus(),
        		activo.getClave_busqueda(),
        		null, activo.getFoto(), null,  activo.getProveedor().getNombre()
        		,activo.getDocumento()

        		);

    }




}
