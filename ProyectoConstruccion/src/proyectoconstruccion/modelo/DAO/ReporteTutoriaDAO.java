/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 11/05/22
 * Fecha de modificación: 13/06/22
 * Descripcion: DAO de la clase ReporteTutoria
 */
package proyectoconstruccion.modelo.DAO;

public class ReporteTutoriaDAO {
    
    //TODO
    
    /*
    public static int insertarProblemáticaAcadémica(ProblemáticaAcadémica problematicaAcademicaRegistro){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "INSERT INTO problematicaacademica "
                        + "(numAlum, descripcion, gravedad, categoria, idPeriodo, idReporteTutoria) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia);
                configurarConsulta.setInt(1, problematicaAcademicaRegistro.getNumAlum());
                configurarConsulta.setString(2, problematicaAcademicaRegistro.getDescripcion());
                configurarConsulta.setString(3, problematicaAcademicaRegistro.getGravedad());
                configurarConsulta.setString(4, problematicaAcademicaRegistro.getCategoria());
                configurarConsulta.setInt(5, problematicaAcademicaRegistro.getIdPeriodo());
                configurarConsulta.setInt(6, problematicaAcademicaRegistro.getIdReporteTutoria());
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
    */
}
