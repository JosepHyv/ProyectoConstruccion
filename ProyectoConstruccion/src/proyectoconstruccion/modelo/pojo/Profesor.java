/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 25/05/22
* Fecha de modificacion: 15/06/22
* Descripcion: Clase que representa a un maestro.
*/
package proyectoconstruccion.modelo.pojo;

import java.util.Objects;

public class Profesor {
    
    private int idProfesor;
    
    private String nombres;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String correo;

    private String tipoProfesor;

    private boolean esActivo;

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
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

    public String getTipoProfesor() {
        return tipoProfesor;
    }

    public boolean isEsActivo() {
        return esActivo;
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

    public void setTipoProfesor(String tipoProfesor) {
        this.tipoProfesor = tipoProfesor;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", tipoProfesor=" + tipoProfesor + ", esActivo=" + esActivo + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (this.idProfesor != other.idProfesor) {
            return false;
        }
        if (this.esActivo != other.esActivo) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.tipoProfesor, other.tipoProfesor)) {
            return false;
        }
        return true;
    }
    
    
}
