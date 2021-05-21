package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.RecompensaDao;
import bo.edu.ucb.ingsoft.demorest.dto.RecompensaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionRecompensaBl {

    @Autowired
    RecompensaDao recompensaDao;

    public RecompensaDTO crearRecompensa(RecompensaDTO recompensa){
        return recompensaDao.crearRecompensa(recompensa);
    }
}
