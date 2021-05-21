package bo.edu.ucb.ingsoft.demorest.dto;

public class RecompensaDTO {
    private Integer recompensaId;
    private Integer rangoInicial;
    private Integer rangoFinal;
    private String recompensa;
    private Integer proyectoId;

    public RecompensaDTO(){

    }

    public Integer getRecompensaId() {
        return recompensaId;
    }

    public void setRecompensaId(Integer recompensaId) {
        this.recompensaId = recompensaId;
    }

    public Integer getRangoInicial() {
        return rangoInicial;
    }

    public void setRangoInicial(Integer rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    public Integer getRangoFinal() {
        return rangoFinal;
    }

    public void setRangoFinal(Integer rangoFinal) {
        this.rangoFinal = rangoFinal;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public Integer getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }
}
