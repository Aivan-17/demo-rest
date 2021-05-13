package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.dto.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/direccion/{id_direccion}")
    public Direccion findDireccionById(@PathVariable Integer id_direccion) {
        Direccion result = new Direccion();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id_direccion,zona,calle,ciudad,departamento from direccion WHERE id_departamento =" + id_direccion);
            if (rs.next()) {
                result.id_direccion = rs.getInt("id_direccion");
                result.zona = rs.getString("zona");
                result.calle = rs.getString("calle");
                result.ciudad = rs.getString("ciudad");
                result.departamento = rs.getString("departamento");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping(path = "/direccion")
    public List<Direccion> findAllDireccion() {
        List<Direccion> result = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id_direccion,zona,calle,ciudad,departamento from direccion WHERE id_departamento ");
            while (rs.next()) {
                Direccion recom = new Direccion();
                recom.id_direccion = rs.getInt("id_direccion");
                recom.zona = rs.getString("zona");
                recom.calle = rs.getString("calle");
                recom.ciudad = rs.getString("ciudad");
                recom.departamento = rs.getString("departamento");
                result.add(recom);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @PostMapping(path = "/direccion")
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        //validar que los datos enviados son correctos
        if (direccion.zona == null || direccion.zona.equals("")) {

        }

        return direccion;
    }
}