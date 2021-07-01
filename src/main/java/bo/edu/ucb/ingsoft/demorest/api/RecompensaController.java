package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionRecompensaBl;
import bo.edu.ucb.ingsoft.demorest.dto.RecompensaDTO;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class RecompensaController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionRecompensaBl gestionRecompensaBl;

    @PostMapping(path = "/recompensa")
    public ResponseDto crearRecompensa(@RequestBody RecompensaDTO recompensaDTO) {
        if (recompensaDTO.getRangoInicial() == null || recompensaDTO.getRangoInicial().equals("")) {
            return new ResponseDto(false, null, "El valor inicial es obligatorio");
        }
        if (recompensaDTO.getRangoFinal() == null || recompensaDTO.getRangoFinal().equals("")) {
            return new ResponseDto(false, null, "El valor final es obligatorio");
        }
        if (recompensaDTO.getRecompensa() == null || recompensaDTO.getRecompensa().trim().equals("")) {
            return new ResponseDto(false, null, "la descripcion es obligatorio");
        }
        if (recompensaDTO.getIdProyecto() == null || recompensaDTO.getIdProyecto().equals("")) {
            return new ResponseDto(false, null, "El id del proyecto es obligatorio");
        }
        return new ResponseDto(true, gestionRecompensaBl.crearRecompensa(recompensaDTO), null);
    }

    @GetMapping(path = "/recompensa/{idRecompensa}")
    public ResponseDto findRecompensaById(@PathVariable Integer idRecompensa){
        RecompensaDTO recompensaDTO = gestionRecompensaBl.findRecompensaById(idRecompensa);
        if (recompensaDTO !=null){
            return new ResponseDto(true, recompensaDTO,null);
        }else{
            return new ResponseDto(true, recompensaDTO,"NO Existe la RECOMPENSA con numero");
        }
    }
    @GetMapping(path = "/recompensa")
    public ResponseDto findallRecompensa(){
        return new ResponseDto(true,gestionRecompensaBl.findAllRecompensa(),null);
    }
}