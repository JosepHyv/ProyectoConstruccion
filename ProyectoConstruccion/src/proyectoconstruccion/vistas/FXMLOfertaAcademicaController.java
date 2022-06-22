/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 25/05/22
* Fecha de modificacion: 13/06/22
* Descripcion: Controlador para la ventana OfertaAcademica.
*/
package proyectoconstruccion.vistas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    @FXML
    private TableColumn colProfesor;
    
    private ObservableList<ExperienciaEducativa> infoExperienciasEducativas;
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
        colNombre.setCellValueFactory (new PropertyValueFactory ("nombre"));
        colNRC.setCellValueFactory (new PropertyValueFactory ("nrc"));
        colProgramaEducativo.setCellValueFactory (new PropertyValueFactory ("programaEducativo"));
        colSemestreRecomendado.setCellValueFactory (new PropertyValueFactory ("semestreRecomendado"));
        colArea.setCellValueFactory (new PropertyValueFactory ("area"));
        colProfesor.setCellValueFactory(new PropertyValueFactory("profesor"));
        infoExperienciasEducativas = FXCollections.observableArrayList();
    }

    private void cargarInformacion() {
        ArrayList<ExperienciaEducativa> resultadoConsulta = ExperienciaEducativaDAO.obtenerExperienciaEducativas();
        if (resultadoConsulta != null) {
            infoExperienciasEducativas.clear();
            infoExperienciasEducativas.addAll(resultadoConsulta);
            tbExperiencias.setItems(infoExperienciasEducativas);
            configurarBusquedaOferta();
        }else{
            Utilidades.mostrarAlerta ("Error de conexión",
            "Por el momento no hay conexión con la Base de Datos", Alert.AlertType.ERROR);
        }
    }
    
    private void cerrarVentana(){
        Stage escenario = (Stage) tfBuscar.getScene().getWindow();
        escenario.close();
    }
    
    private void configurarBusquedaOferta() {
        if(infoExperienciasEducativas.size() > 0){
            FilteredList<ExperienciaEducativa> listaFiltrada = new FilteredList<>(infoExperienciasEducativas,p->true);
            tfBuscar.textProperty().addListener(new ChangeListener<String>(){
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    listaFiltrada.setPredicate(busqueda ->{
                        //Regla 1
                        if(newValue == null || newValue.isEmpty()){
                            return true;
                        }
                        //Regla 2
                        if(busqueda.getNombre().toLowerCase().contains(newValue.toLowerCase())){
                            return true;
                        }
                        //Regla 3
                        else if(busqueda.getNrc().toLowerCase().contains(newValue.toLowerCase())){
                            return true;
                        }
                        return false;
                    });
                }
            });
            SortedList<ExperienciaEducativa> ordenamientoAlumnos = new SortedList<>(listaFiltrada);
            ordenamientoAlumnos.comparatorProperty().bind(tbExperiencias.comparatorProperty());
            tbExperiencias.setItems(ordenamientoAlumnos);
        }
    }
    
    @FXML
    private void btnSalir(ActionEvent event) {
        cerrarVentana();
    }
    
}
