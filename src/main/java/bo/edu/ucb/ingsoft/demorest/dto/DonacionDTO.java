package bo.edu.ucb.ingsoft.demorest.dto;

import java.sql.Time;

public class DonacionDTO {
    private Integer idDonacion;
    private Integer idProyecto;
    private Integer idDonador;
    private Float Monto;
    private Time Hora;
    private String FechaDonacion;
    public DonacionDTO(){

    }

    public Integer getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Integer idDonacion) {
        this.idDonacion = idDonacion;
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

    public Float getMonto() {
        return Monto;
    }

    public void setMonto(Float monto) {
        Monto = monto;
    }

    public Time getHora() {
        return Hora;
    }

    public void setHora(Time hora) {
        Hora = hora;
    }

    public String getFechaDonacion() {
        return FechaDonacion;
    }

    public void setFechaDonacion(String fechaDonacion) {
        FechaDonacion = fechaDonacion;
    }
}
