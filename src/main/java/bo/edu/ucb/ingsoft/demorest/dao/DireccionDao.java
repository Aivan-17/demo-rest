package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.DireccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DireccionDao {
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private DataSource dataSource;

    public DireccionDTO crearDireccion(DireccionDTO direccionDTO){
        // Si todo esta bien procedemos a insertar en BBDD
        direccionDTO.setIdDireccion(sequenceDao.getPrimaryKeyForTable("direccion"));
        Connection conn=null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO direccion VALUES (?,?,?,?,?) ");
            pstmt.setInt(1, direccionDTO.getIdDireccion());
            pstmt.setString(2, direccionDTO.getZona());
            pstmt.setString(3, direccionDTO.getCalle());
            pstmt.setString(4, direccionDTO.getCiudad());
            pstmt.setString(5, direccionDTO.getDepartamento());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                }catch (SQLException sqex){

                  return null;
                }
            }
        }
        return direccionDTO;
    }
    public DireccionDTO findDireccionById(Integer direccionid) {
        DireccionDTO result = new DireccionDTO();

        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT id_direccion,zona, calle, ciudad, departamento FROM direccion WHERE id_direccion = ? ")
        ){ //TRY WITH RESOURCES
            pstmt.setInt(1, direccionid);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setIdDireccion(rs.getInt("id_direccion"));
                result.setZona(rs.getString("zona"));
                result.setCalle(rs.getString("calle"));
                result.setCiudad(rs.getString("ciudad"));
                result.setDepartamento(rs.getString("departamento"));
            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<DireccionDTO> findAllDireccion() {
        List<DireccionDTO> result = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_direccion,zona,calle,ciudad,departamento FROM direccion");
            while (rs.next()) {
                DireccionDTO direccionDTO = new DireccionDTO();
                direccionDTO.setIdDireccion(rs.getInt("id_direccion"));
                direccionDTO.setZona(rs.getString("zona"));
                direccionDTO.setCalle(rs.getString("calle"));
                direccionDTO.setCiudad(rs.getString("ciudad"));
                direccionDTO.setDepartamento(rs.getString("departamento"));
                result.add(direccionDTO);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
