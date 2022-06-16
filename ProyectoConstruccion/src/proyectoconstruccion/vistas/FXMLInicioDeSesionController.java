/*
* Autor: Joseph Hynimoto
* Fecha de creacion: 13/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Controlador de la Ventana de inicio de sesión.
*/
package proyectoconstruccion.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyectoconstruccion.util.Utilidades;
import proyectoconstruccion.util.Constantes;
import proyectoconstruccion.modelo.DAO.UsuarioDAO;
import proyectoconstruccion.modelo.pojo.Usuario;
import proyectoconstruccion.modelo.pojo.InformacionSesion;

public class FXMLInicioDeSesionController implements Initializable {

    @FXML
    private TextField tfUsuario;
    @FXML
    private Label lbUsuario;
    @FXML
    private Label lbPassword;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btnInicioSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicIniciarSesion(ActionEvent event) {
        if(validarCampos()){
            ValidarUsuarioBD(tfUsuario.getText(), pfPassword.getText());
        }
    }
    
    
    public boolean validarCampos(){
        boolean validos = true;
        lbPassword.setText("");
        lbUsuario.setText("");
        String MESSAGE = "El campo es obligatorio";
        
        if(tfUsuario.getText().isEmpty()){
            validos = false;
            lbUsuario.setText(MESSAGE);
        }
        
        if(pfPassword.getText().isEmpty()){
            validos = false;
            lbPassword.setText(MESSAGE);
        }
        
        return validos;
    }
    
    private void ValidarUsuarioBD(String username, String password){
        Usuario usuarioLogin = UsuarioDAO.IniciarSesion(username, password);
        if(usuarioLogin.getCodigoRespuesta() == Constantes.CODIGO_OPERACION_CORRECTA){
            Utilidades.mostrarAlerta("Usuario Verificado","Bienvenido al sistema.",Alert.AlertType.INFORMATION);
            InformacionSesion.getInformacionSesion().setRol(usuarioLogin.getRol());
            InformacionSesion.getInformacionSesion().setIdUsuario(usuarioLogin.getIdUsuario());
            irPantallaPrincipal();
        }else if(usuarioLogin.getCodigoRespuesta() == Constantes.CODIGO_CREDENCIALES_INCORRECTAS){
            Utilidades.mostrarAlerta("Credenciales incorrectas","Usuario o contraseña incorrectas.",Alert.AlertType.WARNING);
        }else if(usuarioLogin.getCodigoRespuesta() == Constantes.CODIGO_ERROR_CONEXIONBD){
            Utilidades.mostrarAlerta("Error de conexion","No existe conexion con la base de datos.",Alert.AlertType.ERROR);
        }
    }
    
    private void irPantallaPrincipal(){
        try{
        Stage escenarioPrincipal = (Stage) tfUsuario.getScene().getWindow();
        Scene menu = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenuCUs.fxml")));
        escenarioPrincipal.setScene(menu);
        escenarioPrincipal.setTitle("Menu");
        escenarioPrincipal.show();
        } catch (IOException e) {
            Utilidades.mostrarAlertaConfirmacion("Error", "No se puede cargar el menu", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
