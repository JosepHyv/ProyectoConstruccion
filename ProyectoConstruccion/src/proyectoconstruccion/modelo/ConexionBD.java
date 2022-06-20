/*
* Autor: Joseph Hynimoto
* Fecha de creacion: 17/05/22
* Fecha de modificacion: 15/06/22
* Descripcion: Archivo para establecer conexion con la base de datos.
*/
package proyectoconstruccion.modelo;

import java.io.File;
import java.net.URL;
import java.nio.file.Path; 
import java.io.IOException;
import java.sql.Connection;
import java.nio.file.Paths; 
import java.util.Properties;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;

/**
 *
 * @author ctr305
 * @author JosepHy
 */
public class ConexionBD {

    /*private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE = "sistematutorias";
    private static final String HOSTNAME = "localhost";
    private static final String PORT = "3306";
    private static final String URL_CONEXION = "jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DATABASE+"?serverTimezone=UTC";

    private static final String USERNAME = "administrador";
    private static final String PASSWORD = "";*/
    
    //private Connection conexion;
    
    
    public static Connection abrirConexionBD() {
        Connection conexion = null;
        try{
            Path CURRENT_FILE = Paths.get("");
            String directory = CURRENT_FILE.toAbsolutePath().toString();
            directory = Paths.get(directory, "src", "proyectoconstruccion", "modelo", "dbconfig.txt").toString();
            System.err.println("File directory is " + directory); // err for debbug
            URL url = new File(directory).toURI().toURL();
            FileInputStream archivoConfiguracion = new FileInputStream(new File(url.getPath()));
            Properties atributos = new Properties();
            atributos.load(archivoConfiguracion);
            archivoConfiguracion.close();
            Class.forName("java.sql.Driver");
            String direccionBD = atributos.getProperty("DireccionBD");
            String usuario = atributos.getProperty("Usuario");
            String contrasenia = atributos.getProperty("Contrasenia");
            conexion = DriverManager.getConnection(direccionBD, usuario, contrasenia);
        }catch (FileNotFoundException fnfException) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, fnfException);
        } catch (IOException ioException){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ioException);
        } catch (ClassNotFoundException cnfException) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, cnfException);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    
    
}
