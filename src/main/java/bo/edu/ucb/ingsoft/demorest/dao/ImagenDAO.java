package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.ImagenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImagenDAO {
    //Se inicia SequenceDao para auto incremento
    @Autowired
    private SequenceDao sequenceDao;
    //Conexion a base de datos
    @Autowired
    public DataSource dataSource;
    /**
     * La funcion se encargara de almacenar una imagen en la tabla imagen
     */
    public ImagenDTO NewImagen(ImagenDTO imagenDTO)throws SQLException{
        imagenDTO.setIdImagen(sequenceDao.getPrimaryKeyForTable("imagen"));
        //Connection con=null;
        try (Connection con=dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO imagen(id_imagen,src_imagen,img) VALUES (?,?,?)")){
            pstmt.setInt(1,imagenDTO.getIdImagen());
            pstmt.setString(2, imagenDTO.getSrcImagen());
            pstmt.setString(3,imagenDTO.getImg());
            pstmt.executeUpdate();
            pstmt.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return imagenDTO;
    }
    /**
     * la siguiente funcion se encarga de llamar todos los datos de la tabla imagen
     */
    public List<ImagenDTO> findAllImagen()throws SQLException{
        List<ImagenDTO> result =new ArrayList<>();
        try{Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT id_imagen,src_imagen,img from imagen");
        /**try(Connection con=dataSource.getConnection();
            PreparedStatement pstmt=con.prepareStatement("SELECT id_imagen, src_imagen, img from imagen");)
        {**/
            //ResultSet resultSet=pstmt.executeQuery();
            while (resultSet.next()){
                ImagenDTO imagenDTO = new ImagenDTO();
                imagenDTO.setIdImagen(resultSet.getInt("id_imagen"));
                imagenDTO.setSrcImagen(resultSet.getString("src_imagen"));
                imagenDTO.setImg(resultSet.getString("img"));
                result.add(imagenDTO);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /**
     * La siguiente funcion se encarga de llamar por id los datos de la tabla
     */
    public ImagenDTO findImagenById(Integer idImagen)throws SQLException{
        ImagenDTO imagenDTO = new ImagenDTO();
        try (Connection conn= dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT id_imagen, src_imagen,img FROM imagen where id_imagen=?");)
        {
            pstmt.setInt(1,idImagen);
            ResultSet resultSet=pstmt.executeQuery();
            if(resultSet.next()){
                imagenDTO.setIdImagen(resultSet.getInt("id_imagen"));
                imagenDTO.setSrcImagen(resultSet.getString("src_imagen"));
                imagenDTO.setImg(resultSet.getString("img"));

            }else {
                resultSet=null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return imagenDTO;
    }
    /**
     * La siguiente funcion se encarga de eliminar un elemento de la lista buscandolo por id.
     */
    public ImagenDTO DeleteImagen(Integer idImagen)throws SQLException{
        ImagenDTO imagenDTO=new ImagenDTO();
        try(Connection con= dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement("delete from imagen where id_imagen=?"))
        {
            pstmt.setInt(1,idImagen);
            ResultSet resultSet= pstmt.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return imagenDTO;
    }
    /**
     * La siguiente funcion se encarga de la actualizacion de los datos de la tabla en busqueda de id .
     */
    public ImagenDTO UpdateImagen(ImagenDTO imagenDTO)throws SQLException{
        try (Connection con=dataSource.getConnection();
            PreparedStatement pstmt =con.prepareStatement("UPDATE imagen SET src_imagen=?,img=? where id_imagen=?")) {
            pstmt.setInt(3, imagenDTO.getIdImagen());
            pstmt.setString(1, imagenDTO.getSrcImagen());
            pstmt.setString(2, imagenDTO.getImg());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return imagenDTO;
    }
}
