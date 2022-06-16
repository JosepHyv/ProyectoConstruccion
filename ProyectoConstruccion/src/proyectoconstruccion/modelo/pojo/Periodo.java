/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 24/05/22
 * Fecha de modificación: 08/06/22
 * Descripcion: Definición de la clase Periodo
 */
package proyectoconstruccion.modelo.pojo;

public class Periodo {
    private String fechaInicio;

    private String fechaFin;

    private String getFechaInicio() {
        return fechaInicio;
    }

    private String getFechaFin() {
        return fechaFin;
    }

    private void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    private void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

}
