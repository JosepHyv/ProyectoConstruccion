package proyectoconstruccion.modelo.pojo;

public class ProblemáticaAcadémica {
    private int numAlum;

    private String descripcion;

    private String gravedad;

    private String categoria;

    private String solucion;

    private int getNumAlum() {
        return numAlum;
    }

    private String getDescripcion() {
        return descripcion;
    }

    private String getGravedad() {
        return gravedad;
    }

    private String getCategoria() {
        return categoria;
    }

    private String getSolucion() {
        return solucion;
    }

    private void setNumAlum(int numAlum) {
        this.numAlum = numAlum;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    private void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private void setSolucion(String solucion) {
        this.solucion = solucion;
    }

}
