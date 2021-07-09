package bo.edu.ucb.ingsoft.demorest.dto;

public class ImagenDTO {
    private Integer idImagen;
    private String src_Imagen;
    private String nombre;
    public ImagenDTO(){
    }
    public ImagenDTO(String nombre, String src_Imagen) {
        this.nombre = nombre;
        this.src_Imagen = src_Imagen;
       // this.public_id = public_id;
    }
    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getSrc_Imagen() {
        return src_Imagen;
    }

    public void setSrc_Imagen(String src_Imagen) {
        this.src_Imagen = src_Imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
