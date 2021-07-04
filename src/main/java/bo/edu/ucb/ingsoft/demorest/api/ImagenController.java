package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionImagenBl;
import bo.edu.ucb.ingsoft.demorest.dto.ImagenDTO;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class ImagenController {
    @Autowired
    private GestionImagenBl gestionImagenBl;
    @GetMapping(path = "/imagen")
    public ResponseDto findAllImagen()throws SQLException{
        return new ResponseDto(true,gestionImagenBl.findAllImagen(),"Exito");
    }
    @GetMapping(path = "/imagen/{idImagen}")
    public ResponseDto findImagenById(@PathVariable Integer idImagen)throws SQLException{
        ImagenDTO imagenDTO=gestionImagenBl.finfImagenById(idImagen);
        if(imagenDTO!=null){
            return new ResponseDto(true,imagenDTO,"Exito");
        }else{
            return new ResponseDto(false,null,"No encontrado");
        }
    }
    @PostMapping(path = "/imagen")
    public ResponseDto NewImagen(@RequestBody ImagenDTO imagenDTO)throws SQLException{
        ImagenDTO imagenDTO1=gestionImagenBl.NewImagen(imagenDTO);
        if(imagenDTO1.getSrcImagen()==null || imagenDTO1.getSrcImagen().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if (imagenDTO1.getImg()==null || imagenDTO1.getImg().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagenDTO1,"Exito");
    }
    @DeleteMapping(path = "/imagen/{idImagen}")
    public ResponseDto DeleteImagen(@PathVariable Integer idImagen)throws SQLException{
        ImagenDTO imagenDTO = gestionImagenBl.DeleteImagen(idImagen);
        if(imagenDTO!=null){
            return new ResponseDto(true,imagenDTO,"Exito");
        }else {
         return new ResponseDto(false,null,null);
        }
    }
    @PutMapping(path = "/imagen")
    public ResponseDto UpdateImagen(@RequestBody ImagenDTO imagenDTO) throws SQLException {
        ImagenDTO imagenDTO1 =gestionImagenBl.UpdateImagen(imagenDTO);
        if(imagenDTO1.getSrcImagen() ==null || imagenDTO1.getSrcImagen().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(imagenDTO1.getImg()==null || imagenDTO1.getImg().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagenDTO1,"");
    }
}
