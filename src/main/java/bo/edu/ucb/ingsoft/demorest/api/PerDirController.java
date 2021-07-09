package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionPerDirBL;
import bo.edu.ucb.ingsoft.demorest.dto.PersonaDTO;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class PerDirController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionPerDirBL gestionPerDirBL;
    @GetMapping(path = "/persona")
    public ResponseDto findAllPersona(){
        return new ResponseDto(true,gestionPerDirBL.findAllPersona(),"Exito mostrar personas");
    }

    @GetMapping(path = "/persona/{idPersona}")
    public ResponseDto findPerDirById(@PathVariable Integer idPersona){
        PersonaDTO personaDTO = gestionPerDirBL.findPerDirById(idPersona);
        if (personaDTO != null){
            return new ResponseDto(true, personaDTO, "Exito findPerDirById");
        }else {
            return new ResponseDto(false, null, "No existe findPerDirById");
        }
    }
}
