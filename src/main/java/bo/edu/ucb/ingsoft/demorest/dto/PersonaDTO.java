package bo.edu.ucb.ingsoft.demorest.dto;

public class PersonaDTO {
    private Integer idPersona;
    private String NombrePersona;
    private String Apellido;
    private Integer idDireccion;
    private String FechaNacimiento;
    //taabla direccion
    private Integer id_Direccion;
    private String zona;
    private String calle;
    private String ciudad;
    private String departamento;
    public PersonaDTO(){

    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return NombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        NombrePersona = nombrePersona;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public Integer getId_Direccion() {
        return id_Direccion;
    }

    public void setId_Direccion(Integer id_Direccion) {
        this.id_Direccion = id_Direccion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
