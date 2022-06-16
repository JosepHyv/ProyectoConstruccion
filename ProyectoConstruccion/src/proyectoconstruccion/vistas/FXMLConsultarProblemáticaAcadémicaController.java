/*

 */
package proyectoconstruccion.vistas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import proyectoconstruccion.modelo.DAO.ProblemáticaAcadémicaDAO;
import proyectoconstruccion.modelo.pojo.ProblemáticaAcadémica;
import proyectoconstruccion.util.Utilidades;

public class FXMLConsultarProblemáticaAcadémicaController implements Initializable {

    @FXML
    private TableView<ProblemáticaAcadémica> tbProblematicas;
    @FXML
    private TableColumn coNumeroAlumnos;
    @FXML
    private TableColumn coGravedad;
    @FXML
    private TableColumn coCategoria;
    @FXML
    private TableColumn coDescripcion;
    @FXML
    private TableColumn coSolucion;
    
    private ObservableList<ProblemáticaAcadémica> infoProblematicas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarInformacion();
    }    

    @FXML
    private void btSalir(ActionEvent event) {
        cerrarVentana();
    }

    private void configurarColumnasTabla() {
        coNumeroAlumnos.setCellValueFactory(new PropertyValueFactory("numAlum"));
        coGravedad.setCellValueFactory(new PropertyValueFactory("gravedad"));
        coCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
        coDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        coSolucion.setCellValueFactory(new PropertyValueFactory("solucion"));
    }

    private void cargarInformacion() {
        ArrayList<ProblemáticaAcadémica> resultadoConsulta = ProblemáticaAcadémicaDAO.obtenerProblemáticaAcadémica();
        if(resultadoConsulta != null){
            tbProblematicas.getItems().clear();
            infoProblematicas.addAll(resultadoConsulta);
            tbProblematicas.setItems(infoProblematicas);
        }else{
            Utilidades.mostrarAlerta("Error", "No hay conexion con la base de datos.", Alert.AlertType.ERROR);
            cerrarVentana();
        }
    }

    private void cerrarVentana() {
        Stage escenario = (Stage) tbProblematicas.getScene().getWindow();
        escenario.close();
    }
    
}
