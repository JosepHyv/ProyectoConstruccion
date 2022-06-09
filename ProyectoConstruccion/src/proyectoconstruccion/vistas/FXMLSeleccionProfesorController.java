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
import javafx.stage.Stage;
import proyectoconstruccion.interfaces.NotificarAsignacion;
import proyectoconstruccion.modelo.DAO.ProfesorDAO;
import proyectoconstruccion.modelo.pojo.Profesor;
import proyectoconstruccion.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLSeleccionProfesorController implements Initializable {

    @FXML
    private TableView<Profesor> tbProfesores;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colCorreo;
    @FXML
    private TableColumn colApellidoPaterno;
    @FXML
    private TableColumn colApellidoMaterno;
    
    private ObservableList<Profesor> infoProfesores;
    
    private  NotificarAsignacion notificarAsignacion;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarInformacion();
    }
    
    private void configurarColumnasTabla() {
        colNombre.setCellValueFactory(new PropertyValueFactory ("nombres"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory ("apellidoPaterno"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory ("apellidoMaterno"));
        colCorreo.setCellValueFactory (new PropertyValueFactory ("correo"));
        infoProfesores = FXCollections.observableArrayList();
    }

    private void cargarInformacion() {
        ArrayList<Profesor> resultadoConsulta = ProfesorDAO.obtenerProfesores();
        if (resultadoConsulta != null) {
            infoProfesores.clear();
            infoProfesores.addAll(resultadoConsulta);
            tbProfesores.setItems(infoProfesores);
        }else{
            Utilidades.mostrarAlerta ("Advertencia", "Por el momento no hay conexión con la Base de Datos", Alert.AlertType.ERROR);
        }
    }
    
    private void valorSeleccionadoTabla(){
        int filaSeleccionada = tbProfesores.getSelectionModel().getSelectedIndex();
        if(filaSeleccionada >= 0){
            Profesor profesor = infoProfesores.get(filaSeleccionada);
            notificarAsignacion.notificarCambio(profesor);
            cerrarVentana();
        }else{
            Utilidades.mostrarAlerta("Profesor no seleccionado",
            "Debes seleccionar un profesor para continuar", 
            Alert.AlertType.WARNING);
        }
    }
    
    public void configurarEscena(NotificarAsignacion notificarAsignacion) {
        this.notificarAsignacion = notificarAsignacion;
    }
        
    private void cerrarVentana(){
        Stage escenario = (Stage) tbProfesores.getScene().getWindow();
        escenario.close();
    }
    
    @FXML
    private void btnGuardar(ActionEvent event) {
        valorSeleccionadoTabla();
    }

    @FXML
    private void btnCancelar(ActionEvent event) {
        cerrarVentana();
    }
      
}
