/*
* Autor: Joseph Hynimoto
* Fecha de creacion: 13/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Controlador de la Ventana de inicio de sesión.
*/
package proyectoconstruccion.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    }
    
}
