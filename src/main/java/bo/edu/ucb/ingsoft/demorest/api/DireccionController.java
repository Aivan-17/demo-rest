package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionDireccionBl;
import bo.edu.ucb.ingsoft.demorest.dto.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DireccionController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionDireccionBl gestionDireccionBl;

    @PostMapping(path = "/direccion")
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        //validar que los datos enviados son correctos

        return gestionDireccionBl.crearDireccion(direccion);
    }

    @GetMapping(path = "/direccion/{idDireccion}")
    public Direccion findDireccionById(@PathVariable Integer idDireccion) {
        Direccion direccion = gestionDireccionBl.findDireccionById(idDireccion);
        if (direccion != null) {
            return gestionDireccionBl.findDireccionById(idDireccion);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la persona con codigo:" + idDireccion );
        }
    }
    @GetMapping(path = "/direccion")
    public List<Direccion> findAllDireccions() {
        return gestionDireccionBl.findAllDireccions();
    }
}