package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.DireccionDao;
import bo.edu.ucb.ingsoft.demorest.dto.DireccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionDireccionBl {

    @Autowired
    DireccionDao direccionDao;

    public DireccionDTO crearDireccion(DireccionDTO direccionDTO) {
    return direccionDao.crearDireccion(direccionDTO);
    }

    public DireccionDTO findDireccionById(Integer idDireccion) {

        return direccionDao.findDireccionById(idDireccion);
    }

    public List<DireccionDTO> findAllDireccions() {
        return direccionDao.findAllDireccion();
    }
}
