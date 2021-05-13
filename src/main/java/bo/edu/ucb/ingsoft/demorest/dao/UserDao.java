package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Service
public class UserDao {

    @Autowired
    public DataSource dataSource;

    public User createUser(User user){
        try {
            Connection conn=dataSource.getConnection();
            Statement stmt=conn.createStatement();
            stmt.execute("INSERT INTO usuario VALUES ("
                    +user.idUsuario+", '"
                    +user.username+", '"
                    +user.contrasenia+", '"
                    +user.correoElectronico+", '"
                    +user.telefono+", '"
                    +user.tipoUsuario+")'");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

}
