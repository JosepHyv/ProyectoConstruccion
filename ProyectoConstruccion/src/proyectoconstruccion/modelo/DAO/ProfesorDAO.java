/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 29/05/22
* Fecha de modificacion: 13/06/22
* Descripcion: Operaciones en la base de datos relacionadas con Profesores.
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
            String query = "SELECT * FROM profesor WHERE esActivo = 1;";
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
