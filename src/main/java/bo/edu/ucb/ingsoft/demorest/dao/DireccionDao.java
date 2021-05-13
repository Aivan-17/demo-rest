package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class DireccionDao {

    @Autowired
    public DataSource dataSource;

    public Direccion crearDireccion(Direccion direccion){

        // Si todo esta bien procedemos a insertar en BBDD
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO direccion VALUES ("
                    + direccion.idDireccion + ",'"
                    + direccion.zona + ", '"
                    + direccion.calle + ", '"
                    + direccion.ciudad + ", '"
                    + direccion.departamento + ")");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direccion;
    }
    public Direccion findDireccionById(Integer idDireccion) {
        Direccion result = new Direccion();

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id_direccion, zona, calle,ciudad,departamento from direccion" +
                    "  WHERE id_direccion = " + idDireccion);  //FIXME SQL INJECTION !!!!!
            if (rs.next()) {
                result.idDireccion = rs.getInt("id_direccion");
                result.zona = rs.getString("zona");
                result.calle = rs.getString("calle");
                result.ciudad=rs.getString("ciudad");
                result.departamento=rs.getString("departamento");
            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<Direccion> findAllDireccion() {
        List<Direccion> result = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id_direccion, zona, calle,ciudad,departamento from direccion");
            while (rs.next()) {
                Direccion direccion = new Direccion();
                direccion.idDireccion = rs.getInt("id_direccion");
                direccion.zona = rs.getString("zona");
                direccion.calle = rs.getString("calle");
                direccion.ciudad=rs.getString("ciudad");
                direccion.departamento=rs.getString("departamento");
                result.add(direccion);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
