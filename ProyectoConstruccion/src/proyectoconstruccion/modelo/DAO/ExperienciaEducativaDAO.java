/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 26/05/22
* Fecha de modificacion: 13/06/22
* Descripcion: Operaciones en la base de datos relacionadas con experiencias educativas.
*/
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.ExperienciaEducativa;
import proyectoconstruccion.modelo.pojo.Profesor;
import proyectoconstruccion.util.Constantes;
import proyectoconstruccion.util.Utilidades;

/**
 *
 * @author Panther
 */
public class ExperienciaEducativaDAO {
    public static ArrayList<ExperienciaEducativa> obtenerExperienciaEducativas(){
        ArrayList<ExperienciaEducativa> experienciasEducativas = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if (conexionBD != null) {
            String query = "SELECT idExperienciaEducativa,nombre,nrc,programaEducativo,semestreRecomendado,area " +
                "FROM sistematutorias.experienciaeducativa " +
                "WHERE esOfertada = 1;";
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    ExperienciaEducativa experienciaEducativaTemp = new ExperienciaEducativa();
                    experienciaEducativaTemp.setNombre(resultadoConsulta.getString("nombre"));
                    experienciaEducativaTemp.setIdExperienciaEducativa(resultadoConsulta.getInt("idExperienciaEducativa"));
                    experienciaEducativaTemp.setNrc(resultadoConsulta.getString("nrc"));
                    experienciaEducativaTemp.setProgramaEducativo(resultadoConsulta.getString("programaEducativo"));
                    experienciaEducativaTemp.setSemestreRecomendado(resultadoConsulta.getInt("semestreRecomendado"));
                    experienciaEducativaTemp.setArea(resultadoConsulta.getString("area"));
                    experienciasEducativas.add (experienciaEducativaTemp);
                }
                conexionBD.close();
            } catch (SQLException e) {
                Utilidades.mostrarAlerta("Advertencia", "ERROR: No hay conexión con la base de datos", Alert.AlertType.NONE);
            }
        }else{
            experienciasEducativas = null;
        }
        return experienciasEducativas;
    }
    public static ArrayList<ExperienciaEducativa> obtenerExperienciaEducativasSinProfesor(){
        ArrayList<ExperienciaEducativa> experienciasEducativas = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if (conexionBD != null) {
            String query = "SELECT * FROM experienciaeducativa WHERE idProfesor IS NULL;";
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    ExperienciaEducativa experienciaEducativaTemp = new ExperienciaEducativa();
                    experienciaEducativaTemp.setIdExperienciaEducativa(resultadoConsulta.getInt("idExperienciaEducativa"));
                    experienciaEducativaTemp.setNombre(resultadoConsulta.getString("nombre"));
                    experienciaEducativaTemp.setNrc(resultadoConsulta.getString("nrc"));
                    experienciaEducativaTemp.setProgramaEducativo(resultadoConsulta.getString("programaEducativo"));
                    experienciasEducativas.add (experienciaEducativaTemp);
                }
                conexionBD.close();
            } catch (SQLException e) {
                Utilidades.mostrarAlerta("Advertencia", "No se puede acceder a la base de datos", Alert.AlertType.NONE);
            }
        }else{
            experienciasEducativas = null;
        }
        return experienciasEducativas;
    }
    public static int asignarProfesorAExperiencia(Profesor profesor, ExperienciaEducativa experienciaEducativa){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if (conexionBD != null) {
            String query = "UPDATE experienciaeducativa SET idProfesor = ? WHERE idExperienciaEducativa = ?;";
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                configurarConsulta.setInt(1, profesor.getIdProfesor());
                configurarConsulta.setInt(2, experienciaEducativa.getIdExperienciaEducativa());
                int filasAfectadas = configurarConsulta.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;
                conexionBD.close();
            } catch (SQLException e) {
                respuesta = Constantes.CODIGO_ERROR_CONEXIONBD;
            }
        } else {
            respuesta = Constantes.CODIGO_ERROR_CONEXIONBD;
        }
        return respuesta;
    }
}
