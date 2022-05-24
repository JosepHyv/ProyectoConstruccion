package proyectoconstruccion.modelo.pojo;

public class ExperienciaEducativa {
    private String nombre;

    private String nrc;

    private String programaEducativo;

    private boolean esOfertada;

    private int semestreRecomendado;

    private String area;

    private String getNombre() {
        return nombre;
    }

    private String getNrc() {
        return nrc;
    }

    private String getProgramaEducativo() {
        return programaEducativo;
    }

    private boolean isEsOfertada() {
        return esOfertada;
    }

    private int getSemestreRecomendado() {
        return semestreRecomendado;
    }

    private String getArea() {
        return area;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setNrc(String nrc) {
        this.nrc = nrc;
    }

    private void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    private void setEsOfertada(boolean esOfertada) {
        this.esOfertada = esOfertada;
    }

    private void setSemestreRecomendado(int semestreRecomendado) {
        this.semestreRecomendado = semestreRecomendado;
    }

    private void setArea(String area) {
        this.area = area;
    }

}
