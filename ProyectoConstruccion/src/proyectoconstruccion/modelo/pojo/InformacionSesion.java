/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoconstruccion.modelo.pojo;

/**
 *
 * @author JosepHy
 */
public class InformacionSesion {
    private String roolUsuario;
    private int idUsuario;
    private static InformacionSesion instancia;
    private InformacionSesion(){
        
    }
    
    public static InformacionSesion getInformacionSesion(){
        if(instancia == null){
            instancia = new InformacionSesion();
        }
        return instancia;
    }
    
    public String getRol(){
        return this.roolUsuario;
    }
    
    public void setRol(String rol){
        this.roolUsuario = rol;
    }
    
    public int getIdUsuario(){
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUser){
        this.idUsuario = idUser;
    }
    
}
