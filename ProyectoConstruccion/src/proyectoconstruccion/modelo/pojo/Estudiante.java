/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 24/05/22
 * Fecha de modificación: 08/06/22
 * Descripcion: Definición de la clase Estudiante
 */
package proyectoconstruccion.modelo.pojo;

import javafx.scene.control.CheckBox;

public class Estudiante {
    private String nombres;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String correo;

    private String matricula;

    private String semestre;
    
    private CheckBox cbAsistencia;

    private CheckBox cbRiesgo;
    
    public Estudiante(){
        this.cbAsistencia = new CheckBox();
        this.cbRiesgo = new CheckBox();
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setCbAsistencia(CheckBox select)
    {
        this.cbAsistencia = select;
    }
    
    public CheckBox getCbAsistencia()
    {
        return this.cbAsistencia;
    }
    
    public void setCbRiesgo(CheckBox select)
    {
        this.cbRiesgo = select;
    }
    
    public CheckBox getCbRiesgo()
    {
        return this.cbRiesgo;
    }
}
