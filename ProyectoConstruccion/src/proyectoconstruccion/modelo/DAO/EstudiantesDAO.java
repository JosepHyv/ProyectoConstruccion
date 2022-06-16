/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.Estudiante;
import proyectoconstruccion.util.Utilidades;
import proyectoconstruccion.modelo.pojo.InformacionSesion;

/**
 *
 * @author JosepHy
 */
public class EstudiantesDAO {
    public static ArrayList<Estudiante> obtenerEstudiantesPorTutor(){
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            String query = "SELECT * FROM estudiante WHERE idTutorAcademico = ?;";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                configurarConsulta.setInt(1,InformacionSesion.getInformacionSesion().getIdUsuario());
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    Estudiante estudianteTemporal = new Estudiante();
                    estudianteTemporal.setNombres(resultadoConsulta.getString("nombres"));
                    estudianteTemporal.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                    estudianteTemporal.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                    estudianteTemporal.setCorreo(resultadoConsulta.getString("correo"));
                    estudianteTemporal.setSemestre(resultadoConsulta.getString("semestre"));
                    estudiantes.add(estudianteTemporal);
                }
                conexionBD.close();
            }catch(SQLException ex){
                Utilidades.mostrarAlerta("Advertencia", "No se puede acceder a la base de datos", Alert.AlertType.ERROR);
            }
        }else{
            estudiantes = null;
        }
        return estudiantes;
    }
    
}
