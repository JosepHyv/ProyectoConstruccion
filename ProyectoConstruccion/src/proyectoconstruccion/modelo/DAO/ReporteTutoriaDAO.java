/*
 * Autor: Leonardo Criollo Ramírez, Joseph Hynimoto Aguilar Lopez
 * Fecha de creación: 11/05/22
 * Fecha de modificación: 22/06/22
 * Descripcion: DAO de la clase ReporteTutoria
 */
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.ReporteTutoria;
import proyectoconstruccion.util.Constantes;
import proyectoconstruccion.util.Utilidades;

public class ReporteTutoriaDAO {
    
    public static int insertarReporteTutoria(ReporteTutoria reporteTutoriaRegistro){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "INSERT INTO reportetutoria "
                        + "(fecha, programaEducativo, numAsistencia, numRiesgo, comentarios) "
                        + "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia);
                configurarConsulta.setDate(1, reporteTutoriaRegistro.getFecha());
                configurarConsulta.setString(2, reporteTutoriaRegistro.getProgramaEducativo());
                configurarConsulta.setInt(3, reporteTutoriaRegistro.getNumAsistencia());
                configurarConsulta.setInt(4, reporteTutoriaRegistro.getNumRiesgo());
                configurarConsulta.setString(5, reporteTutoriaRegistro.getComentarios());
                int filasAfectadas = configurarConsulta.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;
                conexionBD.close();
            } catch (SQLException e){
                Utilidades.mostrarAlerta("Advertencia", "No se puede acceder a la base de datos", Alert.AlertType.ERROR);
                e.printStackTrace();
                respuesta = Constantes.CODIGO_ERROR_CONEXIONBD;
            }
        } else {
            respuesta = Constantes.CODIGO_ERROR_CONEXIONBD;
        }
        return respuesta;
    }
    
    public static Integer getIdUltimoReporte(){
        Connection conexionBD = ConexionBD.abrirConexionBD();
        Integer ultimoIdReporte = 0;
        if(conexionBD != null){
            String query = "SELECT max(idReporteTutoria) " +
                    "FROM reportetutoria;";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                if(resultadoConsulta.next()){
                    ultimoIdReporte = resultadoConsulta.getInt("max(idReporteTutoria)");
                    conexionBD.close();                    
                }
                else{
                    ultimoIdReporte = Integer.MIN_VALUE;
                }
            }catch(SQLException ex){
                System.out.println("auxilio:(");
                ex.printStackTrace();
                Utilidades.mostrarAlerta("Advertencia", "No se puede acceder a la base de datos", Alert.AlertType.ERROR);
            }
        }else{
            ultimoIdReporte = Integer.MIN_VALUE;
        }
        System.out.println("ultimo reporte = " + ultimoIdReporte);
        return ultimoIdReporte;
    }
}
