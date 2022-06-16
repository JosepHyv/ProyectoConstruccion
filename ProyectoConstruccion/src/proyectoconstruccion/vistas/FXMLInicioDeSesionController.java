/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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

/**
 * FXML Controller class
 *
 * @author JosepHy
 */
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
        if(validarCampos())
        {
            ValidarUsuarioBD(tfUsuario.getText(), pfPassword.getText());
        }
    }
    
    
    public boolean validarCampos()
    {
        boolean validos = true;
        lbPassword.setText("");
        lbUsuario.setText("");
        String MESSAGE = "El campo es obligatorio";
        
        if(tfUsuario.getText().isEmpty())
        {
            validos = false;
            lbUsuario.setText(MESSAGE);
        }
        
        if(pfPassword.getText().isEmpty())
        {
            validos = false;
            lbPassword.setText(MESSAGE);
        }
        
        return validos;
    }
    
    private void ValidarUsuarioBD(String username, String password){
        Usuario usuarioLogin = UsuarioDAO.IniciarSesion(username, password);
        if(usuarioLogin.getCodigoRespuesta() == Constantes.CODIGO_OPERACION_CORRECTA){
            Utilidades.mostrarAlerta("Usuario Verificado","Bienvenido al sistema.",Alert.AlertType.INFORMATION);
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
        Scene pantallaAlumnos = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenuCUs.fxml")));
        escenarioPrincipal.setScene(pantallaAlumnos);
        escenarioPrincipal.setTitle("Ventana principal");
        escenarioPrincipal.show();
        } catch (IOException e) {
            Utilidades.mostrarAlertaConfirmacion("Error", "No se puede cargar la pantalla principal", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
