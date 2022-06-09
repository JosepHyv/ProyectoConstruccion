/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconstruccion.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectoconstruccion.interfaces.NotificarAsignacion;
import proyectoconstruccion.modelo.DAO.ExperienciaEducativaDAO;
import proyectoconstruccion.modelo.pojo.ExperienciaEducativa;
import proyectoconstruccion.modelo.pojo.Profesor;
import proyectoconstruccion.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLAsignarExperienciaAProfesorController implements Initializable,NotificarAsignacion {
    
    @FXML
    private TableView<ExperienciaEducativa> tbExperienciasEducativas;
    @FXML
    private TableColumn colExperienciaEducativa;
    @FXML
    private TableColumn colNRC;
    
    private ExperienciaEducativa experienciaEducativa;
    
    private ObservableList<ExperienciaEducativa> infoExperienciasEducativas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarInformacion();
    }
    
    private void irSeleccionProfesor(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSeleccionProfesor.fxml"));
            Parent root = loader.load();
            FXMLSeleccionProfesorController controladorFormulario = loader.getController();
            controladorFormulario.configurarEscena(this);
            Scene escenaFormulario = new Scene(root);
            Stage escenarioFormulario = new Stage();
            escenarioFormulario.setScene(escenaFormulario);
            escenarioFormulario.initModality(Modality.APPLICATION_MODAL);
            escenarioFormulario.showAndWait();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void configurarColumnasTabla() {
        colExperienciaEducativa.setCellValueFactory (new PropertyValueFactory ("nombre"));
        colNRC.setCellValueFactory (new PropertyValueFactory ("nrc"));
        infoExperienciasEducativas = FXCollections.observableArrayList();
    }

    private void cargarInformacion() {
        ArrayList<ExperienciaEducativa> resultadoConsulta = ExperienciaEducativaDAO.obtenerExperienciaEducativasSinProfesor();
        if (resultadoConsulta != null) {
            infoExperienciasEducativas.clear();
            infoExperienciasEducativas.addAll(resultadoConsulta);
            tbExperienciasEducativas.setItems(infoExperienciasEducativas);
        }else{
            Utilidades.mostrarAlerta ("Error de conexión",
            "Por el momento no hay conexión con la Base de Datos", Alert.AlertType.ERROR);
        }
    }
    
    private void valorSeleccionadoTabla(){
        int filaSeleccionada = tbExperienciasEducativas.getSelectionModel().getSelectedIndex();
        if(filaSeleccionada >= 0){
            experienciaEducativa = infoExperienciasEducativas.get(filaSeleccionada);
            irSeleccionProfesor();
        }else{
            Utilidades.mostrarAlerta("Experiencia Educativa no seleccionada",
            "Debes seleccionar una Experiencia Educativa para continuar", 
            Alert.AlertType.WARNING);
        }
    }
    
    private void asignarProfesor(Profesor profesor, ExperienciaEducativa experienciaEducativa){
        ExperienciaEducativaDAO.asignarProfesorAExperiencia(profesor,experienciaEducativa);
        System.out.println();
        cargarInformacion();
    }
    
    @Override
    public void notificarCambio(Profesor profesor) {
        System.out.println("Profesor: " + profesor.getNombreCompleto() + "EE: " + experienciaEducativa.getIdExperienciaEducativa());
        asignarProfesor(profesor,experienciaEducativa);
    }
    
    private void cerrarVentana(){
        Stage escenario = (Stage) tbExperienciasEducativas.getScene().getWindow();
        escenario.close();
    }
    
    @FXML
    private void btnCancelar(ActionEvent event) {
        cerrarVentana();
    }
    
    @FXML
    private void clicExperienciaEducativa(MouseEvent event) {
        if(event.getClickCount() == 2){
            valorSeleccionadoTabla();
        }
    }
    
}
