package proyectoconstruccion.modelo.pojo;

public class Profesor {
    private String nombres;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String correo;

    private String tipoProfesor;

    private boolean esActivo;

    private String getNombres() {
        return nombres;
    }

    private String getApellidoPaterno() {
        return apellidoPaterno;
    }

    private String getApellidoMaterno() {
        return apellidoMaterno;
    }

    private String getCorreo() {
        return correo;
    }

    private String getTipoProfesor() {
        return tipoProfesor;
    }

    private boolean isEsActivo() {
        return esActivo;
    }

    private void setNombres(String nombres) {
        this.nombres = nombres;
    }

    private void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    private void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    private void setCorreo(String correo) {
        this.correo = correo;
    }

    private void setTipoProfesor(String tipoProfesor) {
        this.tipoProfesor = tipoProfesor;
    }

    private void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

}
