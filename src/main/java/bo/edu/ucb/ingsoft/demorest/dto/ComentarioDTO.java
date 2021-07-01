package bo.edu.ucb.ingsoft.demorest.dto;

import java.sql.Time;

public class ComentarioDTO {
    private Integer idComentario;
    private Integer idProyecto;
    private Integer idDonador;
    private String Contenido;
    private String Fecha;
    private Time Hora;
    public ComentarioDTO(){

    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdDonador() {
        return idDonador;
    }

    public void setIdDonador(Integer idDonador) {
        this.idDonador = idDonador;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Time getHora() {
        return Hora;
    }

    public void setHora(Time hora) {
        Hora = hora;
    }
}
