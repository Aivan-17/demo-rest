package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.GestionImagenBl;
import bo.edu.ucb.ingsoft.demorest.dto.ImagenDTO;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demorest.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@RestController
public class ImagenController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private GestionImagenBl gestionImagenBl;

    @CrossOrigin
            (origins = "http://localhost:4200")
    @PostMapping("/upload")
    public ResponseEntity<Integer> uploadFiles(@RequestParam("files") MultipartFile files) {
        System.out.println("ESTOY AQUI");
        int x=0;
        try {
            Map result = CloudinaryService.upload(files);
            ImagenDTO imagenDTO = new ImagenDTO((String) result.get("original_filename"), (String) result.get("url"));
            gestionImagenBl.crearImagen(imagenDTO);
            //x = gestionImagenBl.upload(files, imagen);
        }catch(Exception ex ){
            x=0;
        } return new ResponseEntity(x, HttpStatus.OK); }

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
