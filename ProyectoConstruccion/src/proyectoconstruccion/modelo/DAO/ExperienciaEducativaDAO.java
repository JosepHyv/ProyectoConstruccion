/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 26/05/22
* Fecha de modificacion: 21/06/22
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

public class ExperienciaEducativaDAO {
    public static ArrayList<ExperienciaEducativa> obtenerExperienciaEducativas(){
        ArrayList<ExperienciaEducativa> experienciasEducativas = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if (conexionBD != null) {
            String query = "SELECT distinct experienciaeducativa.idExperienciaEducativa,experienciaeducativa.nrc,\n" +
            "experienciaeducativa.nombre,experienciaeducativa.area,\n" +
            "experienciaeducativa.programaEducativo,experienciaeducativa.semestreRecomendado,imparte.idAcademico,\n" +
            "CASE WHEN imparte.idAcademico IS NULL THEN NULL ELSE academico.nombres END AS nombreProfesor\n" +
            "FROM experienciaeducativa INNER JOIN imparte\n" +
            "ON experienciaeducativa.idExperienciaEducativa = imparte.idExperienciaEducativa\n" +
            "INNER JOIN academico\n" +
            "ON academico.idAcademico = imparte.idAcademico OR imparte.idAcademico is null\n" +
            "WHERE esOfertada = 1";
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
                    experienciaEducativaTemp.setProfesor(resultadoConsulta.getString("nombreProfesor"));
                    experienciasEducativas.add (experienciaEducativaTemp);
                }
                conexionBD.close();
            } catch (SQLException e) {
                Utilidades.mostrarAlerta("Advertencia", "Error: No hay conexión con la base de datos", Alert.AlertType.WARNING);
                e.printStackTrace();
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
            String query = "SELECT experienciaeducativa.idExperienciaEducativa,nombre,nrc,programaEducativo,semestreRecomendado,area\n" +
            "FROM experienciaeducativa\n" +
            "INNER JOIN imparte\n" +
            "ON experienciaeducativa.idExperienciaEducativa = imparte.idExperienciaEducativa\n" +
            "WHERE imparte.idAcademico IS NULL;";
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    ExperienciaEducativa experienciaEducativaTemp = new ExperienciaEducativa();
                    experienciaEducativaTemp.setIdExperienciaEducativa(resultadoConsulta.getInt("idExperienciaEducativa"));
                    experienciaEducativaTemp.setNombre(resultadoConsulta.getString("nombre"));
                    experienciaEducativaTemp.setNrc(resultadoConsulta.getString("nrc"));
                    experienciaEducativaTemp.setProgramaEducativo(resultadoConsulta.getString("programaEducativo"));
                    experienciasEducativas.add(experienciaEducativaTemp);
                }
                conexionBD.close();
            } catch (SQLException e) {
                //Utilidades.mostrarAlerta("Advertencia", "No se puede acceder a la base de datos", Alert.AlertType.WARNING);
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
            String query = "UPDATE imparte SET idAcademico = ? WHERE idExperienciaEducativa = ?;";
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
