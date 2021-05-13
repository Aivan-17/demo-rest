package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionUserBl;
import bo.edu.ucb.ingsoft.demorest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;

@RestController
public class UserController {

    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionUserBl gestionUserBl;

    @PostMapping(path = "/user")
    public User createUser(@RequestBody User user) {
        // Validar que los datos enviados son correctos.
        if (user.username == null || user.username.trim().equals("")) {  // nombre: "     "
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
        }
        if (user.contrasenia == null || user.contrasenia.trim().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El apellido debe ser obligatorio" );
        }

        return gestionUserBl.createUser(user);
    }
}
