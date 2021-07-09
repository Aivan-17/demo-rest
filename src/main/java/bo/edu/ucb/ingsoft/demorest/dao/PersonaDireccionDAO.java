package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.PersonaDTO;
import bo.edu.ucb.ingsoft.demorest.dto.DireccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaDireccionDAO {
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private DataSource dataSource;

    /**public PersonaDTO crearPerDir(PersonaDTO personaDTO){
        personaDTO.setIdPersona(sequenceDao.getPrimaryKeyForTable("persona"));
        personaDTO.setIdDireccion(sequenceDao.getPrimaryKeyForTable("direccion"));
    }**/
    public List<PersonaDTO> findAllPersona(){
        List<PersonaDTO> result = new ArrayList<>();
        try{
            Connection conn=dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select p.nombre_persona,p.apellido,p.fecha_nacimiento,d.zona,d.calle,d.ciudad,d.departamento from persona p join direccion d on d.id_direccion = p.id_direccion");
            while (rs.next()){
                PersonaDTO personaDTO = new PersonaDTO();
               // personaDTO.setIdPersona(rs.getInt("id_persona"));
                personaDTO.setNombrePersona(rs.getString("nombre_persona"));
                personaDTO.setApellido(rs.getString("apellido"));
               // personaDTO.setIdDireccion(rs.getInt("id_direccion"));
                personaDTO.setFechaNacimiento(rs.getString("fecha_nacimiento"));
               // personaDTO.setId_Direccion(rs.getInt("id_direccion"));
                personaDTO.setZona(rs.getString("zona"));
                personaDTO.setCalle(rs.getString("calle"));
                personaDTO.setCiudad(rs.getString("ciudad"));
                personaDTO.setDepartamento(rs.getString("departamento"));
                result.add(personaDTO);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public PersonaDTO findPerDirById(Integer idPersona){
        PersonaDTO result = new PersonaDTO();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("Select p.id_persona, p.nombre_persona,p.apellido,d.ciudad from persona p JOIN direccion d on d.id_direccion = p.id_direccion where id_persona=?")
        ){
        pstmt.setInt(1,idPersona);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()){
            result.setIdPersona(rs.getInt("id_persona"));
            result.setNombrePersona(rs.getString("nombre_persona"));
            result.setApellido(rs.getString("apellido"));
            result.setCiudad(rs.getString("ciudad"));
        }else {
            result = null;
        }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    public PersonaDTO crearPersona(PersonaDTO personaDTO)throws SQLException{
        personaDTO.setIdPersona(sequenceDao.getPrimaryKeyForTable("persona"));
        personaDTO.setId_Direccion(sequenceDao.getPrimaryKeyForTable("direccion"));
        Connection con=null;
        try {
            con=dataSource.getConnection();
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("Insert Into persona (id_persona, nombre_persona, apellido, id_direccion, fecha_nacimiento) values(?,?,?,?,?);");
            pstmt.setInt(1,personaDTO.getIdPersona());
            pstmt.setString(2,personaDTO.getNombrePersona());
            pstmt.setString(3,personaDTO.getApellido());
            pstmt.setInt(4,personaDTO.getIdDireccion());
            pstmt.setString(5,personaDTO.getFechaNacimiento());
            pstmt.executeUpdate();
            PreparedStatement pstmt1;
            pstmt1 = con.prepareStatement("INSERT INTO direccion (id_direccion, zona, calle, ciudad, departamento) values (?,?,?,?,?);");
            pstmt1.setInt(1,personaDTO.getId_Direccion());
            pstmt1.setString(2,personaDTO.getZona());
            pstmt1.setString(3,personaDTO.getCalle());
            pstmt1.setString(4,personaDTO.getCiudad());
            pstmt1.setString(5,personaDTO.getDepartamento());
            pstmt1.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(con !=null){
                try {
                    con.close();
                }catch (SQLException sqex){}
            }
        }
        return personaDTO;
    }
}
