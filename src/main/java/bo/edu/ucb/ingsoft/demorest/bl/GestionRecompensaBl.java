package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.RecompensaDao;
import bo.edu.ucb.ingsoft.demorest.dto.RecompensaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionRecompensaBl {

    @Autowired
    RecompensaDao recompensaDao;

    public RecompensaDTO crearRecompensa(RecompensaDTO recompensaDTO){
        return recompensaDao.crearRecompensa(recompensaDTO);
    }
    public RecompensaDTO findRecompensaById(Integer idrecompensa){
        return recompensaDao.findRecompensaById(idrecompensa);
    }
    public List<RecompensaDTO> findAllRecompensa(){
        return recompensaDao.findallRecompensa();
    }
}
