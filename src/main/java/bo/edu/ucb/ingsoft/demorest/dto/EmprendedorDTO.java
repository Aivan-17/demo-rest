package bo.edu.ucb.ingsoft.demorest.dto;

public class EmprendedorDTO {
    private Integer idEmprendedor;
    private Integer idImagen;
    private Integer idTipoEmprendimiento;
    private Integer idContrato;
    private Integer idUsuario;
    public EmprendedorDTO(){

    }

    public Integer getIdEmprendedor() {
        return idEmprendedor;
    }

    public void setIdEmprendedor(Integer idEmprendedor) {
        this.idEmprendedor = idEmprendedor;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Integer getIdTipoEmprendimiento() {
        return idTipoEmprendimiento;
    }

    public void setIdTipoEmprendimiento(Integer idTipoEmprendimiento) {
        this.idTipoEmprendimiento = idTipoEmprendimiento;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
