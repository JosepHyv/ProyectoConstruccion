package proyectoconstruccion.modelo.pojo;

public class HorarioSesion {
    private String horaInicio;

    private String horaFin;

    private String modalidad;

    private String locacion;

    private String getHoraInicio() {
        return horaInicio;
    }

    private String getHoraFin() {
        return horaFin;
    }

    private String getModalidad() {
        return modalidad;
    }

    private String getLocacion() {
        return locacion;
    }

    private void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    private void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    private void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    private void setLocacion(String locacion) {
        this.locacion = locacion;
    }

}
