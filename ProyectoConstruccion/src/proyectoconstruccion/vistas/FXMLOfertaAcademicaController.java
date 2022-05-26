/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconstruccion.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLOfertaAcademicaController implements Initializable {

    @FXML
    private TableView<?> tbExperiencias;
    @FXML
    private TextField tfBuscar;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colNRC;
    @FXML
    private TableColumn<?, ?> colProgramaEducativo;
    @FXML
    private TableColumn<?, ?> colSemestreRecomendado;
    @FXML
    private TableColumn<?, ?> colArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //configurarColumnasTabla();
        //cargarInformacion();
    }

    private void configurarColumnasTabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void cerrarVentana(){
        Stage escenario = (Stage) tfBuscar.getScene().getWindow();
        escenario.close();
    }
    
    @FXML
    private void btnSalir(ActionEvent event) {
        cerrarVentana();
    }
}
