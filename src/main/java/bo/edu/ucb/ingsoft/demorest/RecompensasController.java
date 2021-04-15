package bo.edu.ucb.ingsoft.demorest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecompensasController {

    @GetMapping(path = "/recompensas")
    public Recompensas helloWorld(){
        Recompensas dum = new Recompensas();
        dum.IdRecompensa=10;
        dum.valorMin=100;
        dum.valorMax=1000;
        dum.recompensa="Prueba";
        dum.Idproyecto=11;
        return dum;
    }
}
