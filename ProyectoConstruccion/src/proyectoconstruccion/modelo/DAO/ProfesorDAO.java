/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.Profesor;
import proyectoconstruccion.util.Utilidades;

/**
 *
 * @author Panther
 */
public class ProfesorDAO {
    public static ArrayList<Profesor> obtenerProfesores(){
        ArrayList<Profesor> profesores = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            String query = "SELECT * FROM profesor;";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    Profesor profesorTemp = new Profesor();
                    profesorTemp.setIdProfesor(resultadoConsulta.getInt("idProfesor"));
                    profesorTemp.setNombres(resultadoConsulta.getString("nombres"));
                    profesorTemp.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                    profesorTemp.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                    profesorTemp.setCorreo(resultadoConsulta.getString("correo"));
                    profesorTemp.setTipoProfesor(resultadoConsulta.getString("tipoDeProfesor"));
                    profesorTemp.setNombreCompleto(resultadoConsulta.getString("nombres")+
                            " "+resultadoConsulta.getString("apellidoPaterno")+
                            " "+resultadoConsulta.getString("apellidoMaterno"));
                    profesores.add(profesorTemp);
                }
                conexionBD.close();
            }catch(SQLException ex){
                Utilidades.mostrarAlerta("Advertencia", "No se puede acceder a la base de datos", Alert.AlertType.ERROR);
            }
        }else{
            profesores = null;
        }
        return profesores;
    }
}
