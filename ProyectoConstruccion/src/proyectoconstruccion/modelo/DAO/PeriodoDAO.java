/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 11/05/22
 * Fecha de modificación: 13/06/22
 * Descripcion: DAO de la clase Periodo
 */
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.Periodo;
import proyectoconstruccion.util.Utilidades;

public class PeriodoDAO {
    
    public static Periodo getPeriodoActual(){
        Connection conexionBD = ConexionBD.abrirConexionBD();
        Periodo periodoActual = new Periodo();
        if(conexionBD != null){
            String query = "SELECT * FROM periodo ORDER BY idPeriodo DESC LIMIT 0,1;";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    periodoActual.setIdPeriodo(resultadoConsulta.getInt("idPeriodo"));
                    periodoActual.setFechaInicio(resultadoConsulta.getString("fechaInicio"));
                    periodoActual.setFechaFin(resultadoConsulta.getString("fechaFin"));
                }
                conexionBD.close();
            }catch(SQLException ex){
                Utilidades.mostrarAlerta("Advertencia", "No se puede acceder a la base de datos", Alert.AlertType.ERROR);
            }
        }else{
            periodoActual = null;
        }
        return periodoActual;
    }
    
}
