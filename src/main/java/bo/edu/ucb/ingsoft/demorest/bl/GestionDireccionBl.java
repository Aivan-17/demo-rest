package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.DireccionDao;
import bo.edu.ucb.ingsoft.demorest.dto.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionDireccionBl {

    @Autowired
    DireccionDao direccionDao;

    public Direccion crearDireccion(Direccion direccion) {
    return direccionDao.crearDireccion(direccion);
    }

    public Direccion findDireccionById(Integer idDireccion) {
        return direccionDao.findDireccionById(idDireccion);
    }

    public List<Direccion> findAllDireccions() {
        return direccionDao.findAllDireccion();
    }
}
