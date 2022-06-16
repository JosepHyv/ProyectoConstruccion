/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 29/05/22
* Fecha de modificacion: 13/06/22
* Descripcion: Controlador para la ventana AsignarExperienciaAProfesor.
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
import javafx.stage.Stage;
import proyectoconstruccion.modelo.DAO.ExperienciaEducativaDAO;
import proyectoconstruccion.modelo.pojo.ExperienciaEducativa;
import proyectoconstruccion.modelo.pojo.Profesor;
import proyectoconstruccion.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author Panther
 */
public class FXMLAsignarExperienciaAProfesorController implements Initializable{
    
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
            if (resultadoConsulta.isEmpty()) {
                Utilidades.mostrarAlerta("Advertencia", "No hay Experiencias educativas sin asignar", Alert.AlertType.WARNING);
            }
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
    
    public void asignarProfesor(Profesor profesor, ExperienciaEducativa experienciaEducativa){
        if(profesor != null){
            ExperienciaEducativaDAO.asignarProfesorAExperiencia(profesor,experienciaEducativa);
            cargarInformacion();
        }
    }
    
    private void irSeleccionProfesor(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSeleccionProfesor.fxml"));
            Parent root = loader.load();
            FXMLSeleccionProfesorController controladorFormulario = loader.getController();
            controladorFormulario.pasarExperienciaEducativa(experienciaEducativa);
            Stage escenarioPrincipal = (Stage) tbExperienciasEducativas.getScene().getWindow();
            Scene pantallaAlumnos = new Scene(root);
            escenarioPrincipal.setScene(pantallaAlumnos);
            escenarioPrincipal.setTitle("Asignar profesor a experiencia educativa");
            escenarioPrincipal.show();            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
