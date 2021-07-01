package bo.edu.ucb.ingsoft.demorest.dto;

public class CuentaDTO {
    private Integer idCuenta;
    private Integer idBanco;
    private String NumeroCuenta;
    private Integer idEmprendedor;
    private String TipoCuenta;
    public CuentaDTO(){

    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }

    public Integer getIdEmprendedor() {
        return idEmprendedor;
    }

    public void setIdEmprendedor(Integer idEmprendedor) {
        this.idEmprendedor = idEmprendedor;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        TipoCuenta = tipoCuenta;
    }
}
