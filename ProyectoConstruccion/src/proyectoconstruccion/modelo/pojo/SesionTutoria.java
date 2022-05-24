package proyectoconstruccion.modelo.pojo;

public class SesionTutoria {
    private String fechaLimite;

    private int numSesion;

    private String getFechaLimite() {
        return fechaLimite;
    }

    private int getNumSesion() {
        return numSesion;
    }

    private void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    private void setNumSesion(int numSesion) {
        this.numSesion = numSesion;
    }

}
