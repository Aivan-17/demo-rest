package bo.edu.ucb.ingsoft.demorest.dto;

public class ImagenDTO {
    private Integer idImagen;
    private String SrcImagen;
    private String Imagen;
    public ImagenDTO(){

    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getSrcImagen() {
        return SrcImagen;
    }

    public void setSrcImagen(String srcImagen) {
        SrcImagen = srcImagen;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
