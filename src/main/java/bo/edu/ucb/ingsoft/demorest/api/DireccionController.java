package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionDireccionBl;
import bo.edu.ucb.ingsoft.demorest.dto.DireccionDTO;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class DireccionController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionDireccionBl gestionDireccionBl;

    @PostMapping(path = "/direccion")
    public ResponseDto createDireccion(@RequestBody DireccionDTO direccionDTO) {
        //validar que los datos enviados son correctos
        if(direccionDTO.getZona() == null || direccionDTO.getZona().trim().equals("")){
            return new ResponseDto( false , null,"La zona debe ser Obligatoria");
        }
        if(direccionDTO.getCalle() == null || direccionDTO.getCalle().trim().equals("")) {
            return new ResponseDto( false , null,"La calle debe ser Obligatoria");
        }
        if(direccionDTO.getCiudad() == null || direccionDTO.getCiudad().trim().equals("")) {
            return new ResponseDto( false , null,"La ciudad debe ser Obligatoria");
        }
        if(direccionDTO.getDepartamento() == null || direccionDTO.getDepartamento().trim().equals("")) {
            return new ResponseDto( false , null,"el departamento debe ser Obligatoria");
        }
            return new ResponseDto(true, gestionDireccionBl.crearDireccion(direccionDTO), null);

    }

    @GetMapping(path = "/direccion/{idDireccion}")
    public ResponseDto findDireccionById(@PathVariable Integer idDireccion) {
        DireccionDTO direccionDTO = gestionDireccionBl.findDireccionById(idDireccion);
        if (direccionDTO != null) {
            return new ResponseDto( true, direccionDTO,null);
        } else {
            return new ResponseDto( true, null ,"No existe la persona con codigo:");
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/direccion")
    public ResponseDto findAllDireccions() {
       return new ResponseDto( true, gestionDireccionBl.findAllDireccions(),null);
    }
}
