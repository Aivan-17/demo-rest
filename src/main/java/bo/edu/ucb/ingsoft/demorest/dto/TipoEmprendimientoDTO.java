package bo.edu.ucb.ingsoft.demorest.dto;

public class TipoEmprendimientoDTO {
    private Integer idTipoEmprendimiento;
    private String Tipo;
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

}
