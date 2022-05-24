package proyectoconstruccion.modelo.pojo;

public class ReporteTutoria {
    private int numReporte;

    private String fecha;

    private String programaEducativo;

    private int numAsistencia;

    private int numRiesgo;

    private String comentarios;

    private int getNumReporte() {
        return numReporte;
    }

    private String getFecha() {
        return fecha;
    }

    private String getProgramaEducativo() {
        return programaEducativo;
    }

    private int getNumAsistencia() {
        return numAsistencia;
    }

    private int getNumRiesgo() {
        return numRiesgo;
    }

    private String getComentarios() {
        return comentarios;
    }

    private void setNumReporte(int numReporte) {
        this.numReporte = numReporte;
    }

    private void setFecha(String fecha) {
        this.fecha = fecha;
    }

    private void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    private void setNumAsistencia(int numAsistencia) {
        this.numAsistencia = numAsistencia;
    }

    private void setNumRiesgo(int numRiesgo) {
        this.numRiesgo = numRiesgo;
    }

    private void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
