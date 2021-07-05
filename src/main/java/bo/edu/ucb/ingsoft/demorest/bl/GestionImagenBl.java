package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.ImagenDAo;
import bo.edu.ucb.ingsoft.demorest.dto.ImagenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionImagenBl {
    @Autowired
    ImagenDAo imagenDAo;
    public ImagenDTO crearImagen(ImagenDTO imagenDTO)throws SQLException {
        return imagenDAo.crearImagen(imagenDTO);
    }
    public  ImagenDTO UpdateImagen(ImagenDTO imagenDTO)throws SQLException{
        return imagenDAo.UpdateImagen(imagenDTO);
    }
    public List<ImagenDTO> findAllImagen()throws SQLException{
        return imagenDAo.findAllImagen();
    }
    public ImagenDTO findImagenById(Integer idImagen) throws SQLException {
        return imagenDAo.findImagenById(idImagen);
    }
    public ImagenDTO DeleteImagen(Integer idImagen)throws SQLException{
        return imagenDAo.DeleteImagen(idImagen);
    }
}
