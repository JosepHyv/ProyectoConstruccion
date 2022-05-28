/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconstruccion.vistas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import proyectoconstruccion.modelo.DAO.ExperienciaEducativaDAO;
import proyectoconstruccion.modelo.pojo.ExperienciaEducativa;
import proyectoconstruccion.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLOfertaAcademicaController implements Initializable {

    @FXML
    private TableView<ExperienciaEducativa> tbExperiencias;
    @FXML
    private TextField tfBuscar;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colNRC;
    @FXML
    private TableColumn colProgramaEducativo;
    @FXML
    private TableColumn colSemestreRecomendado;
    @FXML
    private TableColumn colArea;
    
    private ObservableList<ExperienciaEducativa> infoExperienciasEducativas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarInformacion();
    }

    private void configurarColumnasTabla() {
        colNombre.setCellValueFactory (new PropertyValueFactory ("nombre"));
        colNRC.setCellValueFactory (new PropertyValueFactory ("nrc"));
        colProgramaEducativo.setCellValueFactory (new PropertyValueFactory ("programaEducativo"));
        colSemestreRecomendado.setCellValueFactory (new PropertyValueFactory ("semestreRecomendado"));
        colArea.setCellValueFactory (new PropertyValueFactory ("area"));
        infoExperienciasEducativas = FXCollections.observableArrayList();
    }

    private void cargarInformacion() {
        ArrayList<ExperienciaEducativa> resultadoConsulta = ExperienciaEducativaDAO.obtenerExperienciaEducativas();
        if (resultadoConsulta != null) {
            infoExperienciasEducativas.addAll(resultadoConsulta);
            tbExperiencias.setItems(infoExperienciasEducativas);
        }else{
            Utilidades.mostrarAlerta ("Error de conexión",
            "Por el momento no hay conexión con la Base de Datos", Alert.AlertType.ERROR);
        }
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
