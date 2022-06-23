/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 24/05/22
 * Fecha de modificación: 08/06/22
 * Descripcion: Definición de la clase Periodo
 */
package proyectoconstruccion.modelo.pojo;

import java.util.Date;

public class Periodo {
    
    private Integer idPeriodo;
    
    private Date fechaInicio;

    private Date fechaFin;

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
