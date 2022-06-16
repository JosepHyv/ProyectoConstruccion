/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 24/05/22
 * Fecha de modificación: 08/06/22
 * Descripcion: Definición de la clase Periodo
 */
package proyectoconstruccion.modelo.pojo;

public class Periodo {
    
    private Integer idPeriodo;
    
    private String fechaInicio;

    private String fechaFin;

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

}
