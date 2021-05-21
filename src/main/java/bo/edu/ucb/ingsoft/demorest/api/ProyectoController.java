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
