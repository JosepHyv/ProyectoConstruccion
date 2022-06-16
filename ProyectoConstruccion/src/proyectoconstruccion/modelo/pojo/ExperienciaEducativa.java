/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 25/05/22
* Fecha de modificacion: 15/06/22
* Descripcion: Clase que representa a una experiencia educativa.
*/
package proyectoconstruccion.modelo.pojo;

import java.util.Objects;

public class ExperienciaEducativa {
    private String nombre;

    private String nrc;

    private String programaEducativo;

    private boolean esOfertada;

    private int semestreRecomendado;

    private String area;
    
    private int idExperienciaEducativa;

    public int getIdExperienciaEducativa() {
        return idExperienciaEducativa;
    }

    public void setIdExperienciaEducativa(int idExperienciaEducativa) {
        this.idExperienciaEducativa = idExperienciaEducativa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNrc() {
        return nrc;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public boolean isEsOfertada() {
        return esOfertada;
    }

    public int getSemestreRecomendado() {
        return semestreRecomendado;
    }

    public String getArea() {
        return area;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public void setEsOfertada(boolean esOfertada) {
        this.esOfertada = esOfertada;
    }

    public void setSemestreRecomendado(int semestreRecomendado) {
        this.semestreRecomendado = semestreRecomendado;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ExperienciaEducativa{" + "nombre=" + nombre + ", nrc=" + nrc + ", programaEducativo=" + programaEducativo + ", semestreRecomendado=" + semestreRecomendado + ", area=" + area + ", idExperienciaEducativa=" + idExperienciaEducativa + '}';
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
        final ExperienciaEducativa other = (ExperienciaEducativa) obj;
        if (this.esOfertada != other.esOfertada) {
            return false;
        }
        if (this.semestreRecomendado != other.semestreRecomendado) {
            return false;
        }
        if (this.idExperienciaEducativa != other.idExperienciaEducativa) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.nrc, other.nrc)) {
            return false;
        }
        if (!Objects.equals(this.programaEducativo, other.programaEducativo)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        return true;
    }
    
}
