package proyectoconstruccion.modelo.pojo;

public class ReporteGeneral {
    private String fecha;

    private String objetivo;

    private int totalAlumRegistrados;

    private int totalAlumAsistencia;

    private String comentarios;

    private String getFecha() {
        return fecha;
    }

    private String getObjetivo() {
        return objetivo;
    }

    private int getTotalAlumRegistrados() {
        return totalAlumRegistrados;
    }

    private int getTotalAlumAsistencia() {
        return totalAlumAsistencia;
    }

    private String getComentarios() {
        return comentarios;
    }

    private void setFecha(String fecha) {
        this.fecha = fecha;
    }

    private void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    private void setTotalAlumRegistrados(int totalAlumRegistrados) {
        this.totalAlumRegistrados = totalAlumRegistrados;
    }

    private void setTotalAlumAsistencia(int totalAlumAsistencia) {
        this.totalAlumAsistencia = totalAlumAsistencia;
    }

    private void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
