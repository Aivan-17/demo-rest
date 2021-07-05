package bo.edu.ucb.ingsoft.demorest.dto;

public class ProyectoDTO {
    private Integer idProyecto;
    private String nombre;
    private String descripcion;
    private Float montoRecaudar;
    private Integer idEmprendedor;
    private String fechaInicio;
    private String fechaFin;
    private Integer idEstado;
    public ProyectoDTO(){

    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getMontoRecaudar() {
        return montoRecaudar;
    }

    public void setMontoRecaudar(Float montoRecaudar) {
        this.montoRecaudar = montoRecaudar;
    }

    public Integer getIdEmprendedor() {
        return idEmprendedor;
    }

    public void setIdEmprendedor(Integer idEmprendedor) {
        this.idEmprendedor = idEmprendedor;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }
}
