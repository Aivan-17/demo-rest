package bo.edu.ucb.ingsoft.demorest.dto;

public class ImagenDTO {
    private Integer idImagen;
    private String SrcImagen;
    private String Img;
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

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }
}
