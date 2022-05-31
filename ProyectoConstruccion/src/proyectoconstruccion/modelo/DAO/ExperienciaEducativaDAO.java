/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.ExperienciaEducativa;

/**
 *
 * @author Panther
 */
public class ExperienciaEducativaDAO {
    public static ArrayList<ExperienciaEducativa> obtenerExperienciaEducativas(){
        ArrayList<ExperienciaEducativa> experienciasEducativas = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if (conexionBD != null) {
            String query = "SELECT idExperienciaEducativa,nrc,programaEducativo,semestreRecomendado,area " +
                "FROM sistematutorias.experienciaeducativa " +
                "WHERE esOfertada = true;";
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(query);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    ExperienciaEducativa experienciaEducativaTemp = new ExperienciaEducativa();
                    experienciaEducativaTemp.setIdExperienciaEducativa(resultadoConsulta.getInt("idExperienciaEducativa"));
                    experienciaEducativaTemp.setNrc(resultadoConsulta.getString("nrc"));
                    experienciaEducativaTemp.setProgramaEducativo(resultadoConsulta.getString("programaEducativo"));
                    experienciaEducativaTemp.setSemestreRecomendado(resultadoConsulta.getInt("semestreRecomendado"));
                    experienciaEducativaTemp.setArea(resultadoConsulta.getString("area"));
                    experienciasEducativas.add (experienciaEducativaTemp);
                }
                conexionBD.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            experienciasEducativas = null;
        }
        return experienciasEducativas;
    }
}
