/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 24/05/22
 * Fecha de modificación: 08/06/22
 * Descripcion: Definición de la clase Estudiante
 */
package proyectoconstruccion.modelo.pojo;

public class Estudiante {
    private String nombres;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String correo;

    private String matricula;

    private String semestre;

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

    private String getMatricula() {
        return matricula;
    }

    private String getSemestre() {
        return semestre;
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

    private void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    private void setSemestre(String semestre) {
        this.semestre = semestre;
    }

}
