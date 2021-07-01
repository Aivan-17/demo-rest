package bo.edu.ucb.ingsoft.demorest.dto;

public class TipoEmprendimientoDTO {
    private Integer idTipoEmprendimiento;
    private String Tipo;
    private String Area;
    public TipoEmprendimientoDTO(){

    }

    public Integer getIdTipoEmprendimiento() {
        return idTipoEmprendimiento;
    }

    public void setIdTipoEmprendimiento(Integer idTipoEmprendimiento) {
        this.idTipoEmprendimiento = idTipoEmprendimiento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }
}
