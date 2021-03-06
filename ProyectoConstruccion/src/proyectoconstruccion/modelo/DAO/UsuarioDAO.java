/*
* Autor: Leonardo Criollo Ramírez
* Fecha de creacion: 29/05/22
* Fecha de modificacion: 15/06/22 por Joseph Hynimoto Aguilar Lopez
* Descripcion: DAO de la clase Usuario.
*/
package proyectoconstruccion.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectoconstruccion.modelo.ConexionBD;
import proyectoconstruccion.modelo.pojo.Usuario;
import static proyectoconstruccion.modelo.pojo.Usuario.usuarioLogin;
import proyectoconstruccion.util.Constantes;

public class UsuarioDAO{

    public static Usuario IniciarSesion(String username, String password){
        Usuario.usuarioLogin = new Usuario();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String consulta = "select usuarios.idUsuario, usuarios.username, usuarios.password, "  
                        + "roles.nombreRol, rolesacademicousuarios.idAcademico from usuarios inner join rolesacademicousuarios on rolesacademicousuarios.idRolUsuario " 
                        + " = usuarios.idRolUsuario inner join roles on roles.idRol = rolesacademicousuarios.idRol " 
                        + "WHERE username = ? AND password = ?";
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);
                prepararConsulta.setString(1, username);
                prepararConsulta.setString(2, password);
                ResultSet resultadoConsulta = prepararConsulta.executeQuery();
                if(resultadoConsulta.next()){
                    usuarioLogin.setIdAcademico(resultadoConsulta.getInt("idAcademico"));
                    usuarioLogin.setUsername(resultadoConsulta.getString("username"));
                    usuarioLogin.setPassword(resultadoConsulta.getString("password"));
                    usuarioLogin.setRol(resultadoConsulta.getString("nombreRol"));
                    usuarioLogin.setCodigoRespuesta(Constantes.CODIGO_OPERACION_CORRECTA);
                }else{
                    usuarioLogin.setCodigoRespuesta(Constantes.CODIGO_CREDENCIALES_INCORRECTAS);
                }
                conexionBD.close();
            } catch (SQLException e) {
                usuarioLogin.setCodigoRespuesta(Constantes.CODIGO_ERROR_CONEXIONBD);
                e.printStackTrace();
            }
        }
        return Usuario.usuarioLogin;
    }

}
