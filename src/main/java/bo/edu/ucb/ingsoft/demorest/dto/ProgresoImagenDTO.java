package bo.edu.ucb.ingsoft.demorest.dto;

public class ProgresoImagenDTO {
    private Integer idProgreso;
    private Integer idImagen;
    private String Descripcion;
    public ProgresoImagenDTO(){

    }

    public Integer getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(Integer idProgreso) {
        this.idProgreso = idProgreso;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
