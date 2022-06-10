package proyectoconstruccion.modelo.pojo;

public class ProblemáticaAcadémica {
    
    private Integer idProblemáticaAcadémica;
    
    private Integer numAlum;

    private String descripcion;

    private String gravedad;

    private String categoria;

    private String solucion;
    
    private Integer idPeriodo;
    
    private Integer idReporteTutoria;

    public Integer getIdProblemáticaAcadémica() {
        return idProblemáticaAcadémica;
    }

    public void setIdProblemáticaAcadémica(Integer idProblemáticaAcadémica) {
        this.idProblemáticaAcadémica = idProblemáticaAcadémica;
    }
    
    public Integer getNumAlum() {
        return numAlum;
    }

    public void setNumAlum(Integer numAlum) {
        this.numAlum = numAlum;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdReporteTutoria() {
        return idReporteTutoria;
    }

    public void setIdReporteTutoria(Integer idReporteTutoria) {
        this.idReporteTutoria = idReporteTutoria;
    }

}
