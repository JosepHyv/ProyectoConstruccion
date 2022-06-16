/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 11/05/22
 * Fecha de modificación: 13/06/22
 * Descripcion: DAO de la clase ReporteTutoria
 */
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.ReporteTutoria;
import proyectoconstruccion.util.Constantes;

public class ReporteTutoriaDAO {
    
    public static int insertarReporteTutoria(ReporteTutoria reporteTutoriaRegistro){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "INSERT INTO reportetutoria "
                        + "(numReporte, fecha, programaEducativo, numAsistencia, numRiesgo, comentarios) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia);
                configurarConsulta.setInt(1, reporteTutoriaRegistro.getNumReporte());
                configurarConsulta.setString(2, reporteTutoriaRegistro.getFecha());
                configurarConsulta.setString(3, reporteTutoriaRegistro.getProgramaEducativo());
                configurarConsulta.setInt(4, reporteTutoriaRegistro.getNumAsistencia());
                configurarConsulta.setInt(5, reporteTutoriaRegistro.getNumRiesgo());
                configurarConsulta.setString(6, reporteTutoriaRegistro.getComentarios());
                int filasAfectadas = configurarConsulta.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;
                conexionBD.close();
            } catch (SQLException e){
                e.printStackTrace();
                respuesta = Constantes.CODIGO_ERROR_CONEXIONBD;
            }
        } else {
            respuesta = Constantes.CODIGO_ERROR_CONEXIONBD;
        }
        return respuesta;
    }
    
    public static int getNumeroReporteMasActual(){
        int idReporte = 1;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "SELECT * FROM reportetutoria ORDER BY idReporteTutoria DESC LIMIT 0,1";
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    idReporte = resultadoConsulta.getInt("idReporteTutoria") + 1;
                }
            }catch (SQLException e){
                e.printStackTrace();
                idReporte = Integer.MIN_VALUE;
            }
        }else {
            idReporte = Integer.MIN_VALUE;
        }
        return idReporte;
    }
}
