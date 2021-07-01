package bo.edu.ucb.ingsoft.demorest.dto;

public class DonadorDTO {
    private Integer idDonador;
    private Integer idContrato;
    private Integer idUsuario;
    public DonadorDTO(){

    }

    public Integer getIdDonador() {
        return idDonador;
    }

    public void setIdDonador(Integer idDonador) {
        this.idDonador = idDonador;
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
