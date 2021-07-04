package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.ProyectoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoDAO {
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private DataSource dataSource;
    /**Crear nuevo proyecto**/
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO) {
        proyectoDTO.setIdProyecto(sequenceDao.getPrimaryKeyForTable("proyecto"));

        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO proyecto VALUES (?,?,?,?,?,?,?,?,?,?)")){
            pstmt.setInt(1, proyectoDTO.getIdProyecto());
            pstmt.setString(2, proyectoDTO.getNombre());
            pstmt.setString(3, proyectoDTO.getDescripcion());
            pstmt.setFloat(4, proyectoDTO.getMontoRecaudar());
            pstmt.setInt(5, proyectoDTO.getIdEmprendedor());
            pstmt.setString(6, proyectoDTO.getHoraInicio());
            pstmt.setString(7, proyectoDTO.getHoraFin());
            pstmt.setInt(8, proyectoDTO.getIdEstado());
            pstmt.setString(9, proyectoDTO.getFechaInicio());
            pstmt.setString(10, proyectoDTO.getFechaFin());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return proyectoDTO;
    }

    /**Busqueda de proyectos por id
    public ProyectoDTO findProyectoById(Integer idproyecto) {
        ProyectoDTO result = new ProyectoDTO();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT id_proyecto,nombre_proyecto, descripcion, monto_recaudar FROM proyecto where id_proyecto = ?")
        ) {
            pstmt.setInt(1, idproyecto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setIdProyecto(rs.getInt("id_proyecto"));
                result.setNombre(rs.getString("nombre_proyecto"));
                result.setDescripcion(rs.getString("descripcion"));
                result.setMontoRecaudar(rs.getFloat("monto_recaudar"));
            } else {
                result = null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }**/
    /**Despliegue de todos los proyectos **/
    public List<ProyectoDTO> findAllProyecto(){
        List<ProyectoDTO> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select id_proyecto,nombre_proyecto,descripcion,monto_recaudar FROM proyecto limit 10")){
            while (rs.next()){
                ProyectoDTO proyectoDTO=new ProyectoDTO();
                proyectoDTO.setIdProyecto(rs.getInt("id_proyecto"));
                proyectoDTO.setNombre(rs.getString("nombre_proyecto"));
                proyectoDTO.setDescripcion(rs.getString("descripcion"));
                proyectoDTO.setMontoRecaudar(rs.getFloat("monto_recaudar"));
                result.add(proyectoDTO);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /** Busqueda por nombre no conseguido**/
    public List<ProyectoDTO> findProyectoByName(String nombre) throws SQLException{
        List<ProyectoDTO> array=new ArrayList<>();
        try(Connection con=dataSource.getConnection();
        PreparedStatement pre=con.prepareStatement("SELECT id_proyecto,nombre_proyecto,descripcion,monto_recaudar from proyecto where nombre_proyecto ILIKE ?")) {
            pre.setString(1,"%"+nombre+"%");
            ResultSet res=pre.executeQuery();
            while (res.next()){
                ProyectoDTO ob = new ProyectoDTO();
                ob.setIdProyecto(res.getInt("id_proyecto"));
                ob.setNombre(res.getString("nombre_proyecto"));
                ob.setDescripcion(res.getString("descripcion"));
                ob.setMontoRecaudar(res.getFloat("monto_recaudar"));
                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return array;

    }
}
