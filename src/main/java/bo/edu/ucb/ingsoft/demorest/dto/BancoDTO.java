package bo.edu.ucb.ingsoft.demorest.dto;

public class BancoDTO {
    private Integer idBanco;
    private String NombreBanco;
    public BancoDTO(){

    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombreBanco() {
        return NombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        NombreBanco = nombreBanco;
    }
}
