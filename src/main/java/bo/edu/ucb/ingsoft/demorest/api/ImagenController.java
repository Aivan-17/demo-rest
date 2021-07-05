package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionImagenBl;
import bo.edu.ucb.ingsoft.demorest.dto.ImagenDTO;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
public class ImagenController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionImagenBl gestionImagenBl;

    @PostMapping(path = "/imagen")
    public ResponseDto crearImagen(@RequestBody ImagenDTO imagenDTO)throws SQLException {
        if(imagenDTO.getSrc_Imagen() == null || imagenDTO.getSrc_Imagen().trim().equals("")){
            return new ResponseDto(false,null,"SRC es obligatorio");
        }
        if(imagenDTO.getNombre() == null || imagenDTO.getNombre().trim().equals("")){
            return new ResponseDto(false,null,"IMG es obligatorio");
        }
            return new ResponseDto(true, gestionImagenBl.crearImagen(imagenDTO), "Exito Subida");
    }
    @PutMapping(path = "/imagen")
    public ResponseDto UpdateImagen(@RequestBody ImagenDTO imagenDTO)throws SQLException {
        if(imagenDTO.getSrc_Imagen() == null || imagenDTO.getSrc_Imagen().trim().equals("")){
            return new ResponseDto(false,null,"SRC es obligatorio");
        }
        if(imagenDTO.getNombre() == null || imagenDTO.getNombre().trim().equals("")){
            return new ResponseDto(false,null,"IMG es obligatorio");
        }
        return new ResponseDto(true, gestionImagenBl.UpdateImagen(imagenDTO), "Exito Subida");
    }
    @GetMapping(path = "/imagen")
    public ResponseDto findAllImagen()throws SQLException{
        return new ResponseDto(true,gestionImagenBl.findAllImagen(),"Motrando toldas las imagenes");
    }
    @GetMapping(path = "/imagen/{idImagen}")
    public ResponseDto findImagenById(@PathVariable Integer idImagen)throws SQLException{
        ImagenDTO imagenDTO = gestionImagenBl.findImagenById(idImagen);
        if(imagenDTO == null){
            return new ResponseDto(false,null, "No Existe la Imagen");
        }
        return new ResponseDto(true,imagenDTO,"Exito");
    }
    @DeleteMapping(path = "/imagen/{idImagen}")
    public ResponseDto DeleteImagen(@PathVariable Integer idImagen)throws SQLException{
        ImagenDTO imagenDTO = gestionImagenBl.DeleteImagen(idImagen);
        if (imagenDTO==null){
            return new ResponseDto(false,null,"No se encuentra el elemento");
        }
        return new ResponseDto(true,imagenDTO,"Elemento Borrado con exito");
    }
}
