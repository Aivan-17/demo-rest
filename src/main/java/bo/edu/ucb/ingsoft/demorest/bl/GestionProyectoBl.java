package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.ProyectoDAO;
import bo.edu.ucb.ingsoft.demorest.dto.ProyectoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionProyectoBl {

    @Autowired
    ProyectoDAO proyectoDAO;

    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO){
        return proyectoDAO.crearProyecto(proyectoDTO);
    }
    public ProyectoDTO findProyectoById(Integer idProyecto){
        return proyectoDAO.findProyectoById(idProyecto);
    }

    public List<ProyectoDTO> findAllProyecto(){
        return proyectoDAO.findAllProyecto();
    }
}
