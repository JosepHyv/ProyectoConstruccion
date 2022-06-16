/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 11/05/22
 * Fecha de modificación: 13/06/22
 * Descripcion: DAO de la clase ProblemáticaAcadémica
 */
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.ProblemáticaAcadémica;
import proyectoconstruccion.util.Constantes;

public class ProblemáticaAcadémicaDAO {
    
    public static int insertarProblemáticaAcadémica(ProblemáticaAcadémica problematicaAcademicaRegistro){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "INSERT INTO problematicaacademica "
                        + "(numAlum, descripcion, gravedad, categoria, idPeriodo) "
                        + "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia);
                configurarConsulta.setInt(1, problematicaAcademicaRegistro.getNumAlum());
                configurarConsulta.setString(2, problematicaAcademicaRegistro.getDescripcion());
                configurarConsulta.setString(3, problematicaAcademicaRegistro.getGravedad());
                configurarConsulta.setString(4, problematicaAcademicaRegistro.getCategoria());
                configurarConsulta.setInt(5, problematicaAcademicaRegistro.getIdPeriodo());
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
    
    public static ArrayList<ProblemáticaAcadémica> obtenerProblemáticaAcadémica(){
        ArrayList<ProblemáticaAcadémica> problemáticaAcadémicaDB = new ArrayList();

        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            String consulta ="SELECT * FROM problematicaacademica";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    ProblemáticaAcadémica problematicaAcademicaTemp = new ProblemáticaAcadémica();
                    problematicaAcademicaTemp.setIdProblemáticaAcadémica(resultadoConsulta.getInt("idProblematicaAcademica"));
                    problematicaAcademicaTemp.setNumAlum(resultadoConsulta.getInt("numAlum"));
                    problematicaAcademicaTemp.setDescripcion(resultadoConsulta.getString("descripcion"));
                    problematicaAcademicaTemp.setGravedad(resultadoConsulta.getString("descripcion"));
                    problematicaAcademicaTemp.setCategoria(resultadoConsulta.getString("categoria"));
                    problematicaAcademicaTemp.setSolucion(resultadoConsulta.getString("solucion"));
                    problematicaAcademicaTemp.setIdPeriodo(resultadoConsulta.getInt("idPeriodo"));
                    problematicaAcademicaTemp.setIdReporteTutoria(resultadoConsulta.getInt("idReporteTutoria"));
                    problemáticaAcadémicaDB.add(problematicaAcademicaTemp);
                }
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            problemáticaAcadémicaDB = null;
        }
        return problemáticaAcadémicaDB;
    }
    
}
