package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.PersonaDireccionDAO;
import bo.edu.ucb.ingsoft.demorest.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionPerDirBL {
    @Autowired
    PersonaDireccionDAO personaDireccionDAO;
    public List<PersonaDTO> findAllPersona(){
        return personaDireccionDAO.findAllPersona();
    }
    public PersonaDTO findPerDirById(Integer idPersona){
        return personaDireccionDAO.findPerDirById(idPersona);
    }
    /**public PersonaDTO crearPersona**/
}
