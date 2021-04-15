package bo.edu.ucb.ingsoft.demorest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartamentoController {
    @Autowired
    public DataSource dataSource;

    @GetMapping(path = "/departamento/{IdDepartamento}")
    public Departamento findDepartamentoById(@PathVariable Integer IdDepartamento){
       Departamento result = new Departamento();
        try{
            Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_departamento, departamento FROM departamento WHERE id_departamento ="+IdDepartamento);
            if (rs.next()){
                result.IdDepartamento = rs.getInt("id_departamento");
                result.Departamento = rs.getString("departamento");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    @GetMapping(path = "/departamento")
    public List<Departamento> findAllDepartamento(){
        List<Departamento> result = new ArrayList<>();

        try{
            Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_departamento, departamento FROM departamento");
            while (rs.next()){
                Departamento recom =new Departamento();
                recom.IdDepartamento = rs.getInt("id_departamento");
                recom.Departamento = rs.getString("departamento");
                result.add(recom);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    @PostMapping(path = "/departamento")
    public Departamento createDepartamento(@RequestBody Departamento departamento){
        try{
            Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            stmt.execute("INSERT INTO departamento VALUES ("
                    +departamento.IdDepartamento +",'"
                    +departamento.Departamento+"')");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return departamento;
    }
}
