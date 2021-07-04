package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.ImagenDAO;
import bo.edu.ucb.ingsoft.demorest.dto.ImagenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionImagenBl {
    @Autowired
    ImagenDAO imagenDAO;
    public ImagenDTO NewImagen(ImagenDTO imagenDTO)throws SQLException{
        return imagenDAO.NewImagen(imagenDTO);
    }
    public List<ImagenDTO> findAllImagen()throws SQLException{
        return imagenDAO.findAllImagen();
    }
    public ImagenDTO finfImagenById(Integer idImagen)throws SQLException{
        return imagenDAO.findImagenById(idImagen);
    }
    public ImagenDTO DeleteImagen(Integer idImagen)throws SQLException{
        return imagenDAO.DeleteImagen(idImagen);
    }
    public ImagenDTO UpdateImagen(ImagenDTO imagenDTO)throws SQLException{
        return imagenDAO.UpdateImagen(imagenDTO);
    }
}
