package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionProyectoBl;
import bo.edu.ucb.ingsoft.demorest.dto.ProyectoDTO;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class ProyectoController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionProyectoBl gestionProyectoBl;

    @PostMapping(path = "/proyecto")
    public ResponseDto crearProyecto(@RequestBody ProyectoDTO proyectoDTO){
        if (proyectoDTO.getNombre()==null||proyectoDTO.getNombre().trim().equals("")){
            return new ResponseDto(false,null,"El nombre es Obligatorio");
        }
        if (proyectoDTO.getDescripcion()==null||proyectoDTO.getDescripcion().trim().equals("")){
            return new ResponseDto(false,null,"La Descripcion es Obligatorio");
        }
        if (proyectoDTO.getMontoRecaudar()==null||proyectoDTO.getMontoRecaudar().equals("")){
            return new ResponseDto(false,null,"El Monto a recaudar es Obligatorio");
        }
        if (proyectoDTO.getIdEmprendedor()==null||proyectoDTO.getIdEmprendedor().equals("")){
            return new ResponseDto(false,null,"El ID del emprendedor es Obligatorio");
        }
        if (proyectoDTO.getHoraInicio()==null||proyectoDTO.getHoraInicio().trim().equals("")){
            return new ResponseDto(false,null,"La hora de Inicio es Obligatorio");
        }
        if (proyectoDTO.getHoraFin()==null||proyectoDTO.getHoraFin().trim().equals("")){
            return new ResponseDto(false,null,"El hora de Fin es Obligatorio");
        }
        if (proyectoDTO.getIdEstado()==null||proyectoDTO.getIdEstado().equals("")){
            return new ResponseDto(false,null,"El ID de Estado es Obligatorio");
        }
        if (proyectoDTO.getFechaInicio()==null||proyectoDTO.getFechaInicio().trim().equals("")){
            return new ResponseDto(false,null,"La Fecha de Inicio es Obligatorio");
        }
        if (proyectoDTO.getFechaFin()==null||proyectoDTO.getFechaFin().trim().equals("")){
            return new ResponseDto(false,null,"La Fecha de Finalizacion es Obligatorio");
        }
        return new ResponseDto(true,gestionProyectoBl.crearProyecto(proyectoDTO), null);
    }
    @GetMapping(path = "/proyecto/{idProyecto}")
    public ResponseDto findProyectoById(@PathVariable Integer idProyecto){
        ProyectoDTO proyectoDTO = gestionProyectoBl.findProyectoById(idProyecto);
        if (proyectoDTO != null) {
            return new ResponseDto(true, proyectoDTO, null);
        }else {
            return new ResponseDto(true, proyectoDTO,"No existe el proyecto con ese codigo");
        }
    }
    @GetMapping(path = "/proyecto")
    public ResponseDto findAllProyecto(){
        return new ResponseDto(true, gestionProyectoBl.findAllProyecto(),null);
    }
}
