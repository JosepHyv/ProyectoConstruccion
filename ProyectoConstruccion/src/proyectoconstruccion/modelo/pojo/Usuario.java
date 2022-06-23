/*
* Autor: Leonardo Criollo Ramírez
* Fecha de creacion: 29/05/22
* Fecha de modificacion: 15/06/22
* Descripcion: Definicion de la clase Usuario.
*/
package proyectoconstruccion.modelo.pojo;

public class Usuario {

    public static Usuario usuarioLogin;

    private Integer idAcademico;
    private String username;
    private String password;
    private String rol;
    private Integer codigoRespuesta;

    public Usuario(){
    }

    public Usuario(Integer idAcademico, String username, String password, String rol, Integer codigoRespuesta){
        this.idAcademico = idAcademico;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.codigoRespuesta = codigoRespuesta;
    }

    public static Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public static void setUsuarioLogin(Usuario usuarioLogin) {
        Usuario.usuarioLogin = usuarioLogin;
    }

    public Integer getIdAcademico() {
        return this.idAcademico;
    }

    public void setIdAcademico(Integer idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getRol(){
        return rol;
    }

    public void setRol(String rol){
        this.rol = rol;
    }
}
