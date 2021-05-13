package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

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
                    + direccion.id_direccion + ",'"
                    + direccion.zona + ", '"
                    + direccion.calle + ", '"
                    + direccion.ciudad + ", '"
                    + direccion.departamento + ")");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return direccion;
    }
}
