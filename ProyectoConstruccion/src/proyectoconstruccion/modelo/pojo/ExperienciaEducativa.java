package proyectoconstruccion.modelo.pojo;

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

}
