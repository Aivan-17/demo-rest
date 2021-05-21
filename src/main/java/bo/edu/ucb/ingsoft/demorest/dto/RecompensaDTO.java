package bo.edu.ucb.ingsoft.demorest.dto;

public class RecompensaDTO {
    private Integer recompensaId;
    private Double rangoInicial;
    private Double rangoFinal;
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

    public Double getRangoInicial() {
        return rangoInicial;
    }

    public void setRangoInicial(Double rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    public Double getRangoFinal() {
        return rangoFinal;
    }

    public void setRangoFinal(Double rangoFinal) {
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
