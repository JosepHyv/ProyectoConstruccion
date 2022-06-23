/*
* Autor: Leonardo Criollo Ramírez
* Fecha de creacion: 29/05/22
* Fecha de modificacion: 15/06/22
* Descripcion: Definicion de la clase ReporteTutoria.
*/
package proyectoconstruccion.modelo.pojo;

import java.sql.Date;
import java.time.LocalDate;

public class ReporteTutoria {
    
    private Integer idReporte;
    
    private Integer numReporte;

    private Date fecha;

    private String programaEducativo;

    private Integer numAsistencia;

    private Integer numRiesgo;

    private String comentarios;

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Integer getNumReporte() {
        return numReporte;
    }

    public void setNumReporte(Integer numReporte) {
        this.numReporte = numReporte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public Integer getNumAsistencia() {
        return numAsistencia;
    }

    public void setNumAsistencia(Integer numAsistencia) {
        this.numAsistencia = numAsistencia;
    }

    public Integer getNumRiesgo() {
        return numRiesgo;
    }

    public void setNumRiesgo(Integer numRiesgo) {
        this.numRiesgo = numRiesgo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
