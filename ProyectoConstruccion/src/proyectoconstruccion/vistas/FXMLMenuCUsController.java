/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 15/06/22
 * Fecha de modificación: 15/06/22
 * Descripcion: Controlador de la ventana MenuCUs
 */
package proyectoconstruccion.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectoconstruccion.util.Utilidades;

public class FXMLMenuCUsController implements Initializable {

    @FXML
    private Label lbBienvenido;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void btLlenarReporteTutorias(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLlenarReporteDeTutoriasAcademicas"));
           Parent root = loader.load();
           FXMLLlenarReporteTutoriasController controladorReporteTutorias = loader.getController();
           Scene escenaReporteTutorias = new Scene(root);
           Stage escenarioReporteTutorias = new Stage();
           escenarioReporteTutorias.setScene(escenaReporteTutorias);
           escenarioReporteTutorias.initModality(Modality.APPLICATION_MODAL);
           escenarioReporteTutorias.showAndWait();
        }catch(IOException e){
            Utilidades.mostrarAlerta("Error", "Error al mostrar ventana", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    private void btRegistrarProblematica(ActionEvent event) {
    }

    @FXML
    private void btnConsultarProblematica(ActionEvent event) {
    }

    @FXML
    private void btConsultarOfertaAcademica(ActionEvent event) {
    }

    @FXML
    private void btAsignarExperienciaEducativa(ActionEvent event) {
    }

    @FXML
    private void btSalir(ActionEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage escenario = (Stage) lbBienvenido.getScene().getWindow();
        escenario.close();
    }
    
}
