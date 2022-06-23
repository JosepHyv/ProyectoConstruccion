/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 13/05/22
 * Fecha de modificación: 15/06/22
 * Descripcion: Controlador de la ventana RegistrarProblemáticaAcadémica
 */
package proyectoconstruccion.vistas;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyectoconstruccion.modelo.pojo.Periodo;
import proyectoconstruccion.modelo.pojo.ProblemáticaAcadémica;
import proyectoconstruccion.util.Utilidades;

public class FXMLRegistrarProblemáticaAcadémicaController implements Initializable {

    @FXML
    private TextField tfNumeroAlumnos;
    @FXML
    private ComboBox<String> cbGravedad;
    @FXML
    private ComboBox<String> cbCategoria;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private TextArea taSolucion;
    @FXML
    private Label lbErrorNumero;
    
    private int idReporte;

    private int idPeriodo;
    
    private ProblemáticaAcadémica problematicaAcademicaRegistro;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarCampos();
    }    
    
    public void configurarCampos(){
        taDescripcion.setWrapText(true);
        taSolucion.setWrapText(true);
        lbErrorNumero.setText("");
        
        tfNumeroAlumnos.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                if(!newValue.matches("^[0-9]+$")){
                    lbErrorNumero.setText("Campo inválido.");
                }else{
                    lbErrorNumero.setText("");
                }
            }
        });
        
        ObservableList<String> gravedades = FXCollections.observableArrayList();
        gravedades.add("Baja");
        gravedades.add("Moderada");
        gravedades.add("Alta");
        gravedades.add("Crítica");
        cbGravedad.setItems(gravedades);
        
        ObservableList<String> categorias = FXCollections.observableArrayList();
        categorias.add("Catedra");
        categorias.add("Administracion");
        categorias.add("Asistencia");
        categorias.add("COVID");
        categorias.add("Clases en Linea");
        categorias.add("Acoso");
        categorias.add("Otro");
        cbCategoria.setItems(categorias);
        
        
    }

    @FXML
    private void btnCancelar(ActionEvent event) {
        cerrarVentana();
    }

    @FXML
    private void btnGuardar(ActionEvent event) {
        if(comprobarCampos()){
            insertarProblemáticaAcadémica();
            cerrarVentana();
        }else{
            Utilidades.mostrarAlertaConfirmacion("Campos inválidos", "Uno o más campos no han sido llenados correctamente.", Alert.AlertType.WARNING);
        }
    }

    private void cerrarVentana() {
        Stage escenario = (Stage) tfNumeroAlumnos.getScene().getWindow();
        escenario.close();    
    }

    private boolean comprobarCampos() {
        boolean camposCorrectos = true;
        if(tfNumeroAlumnos.getText().isEmpty() || !tfNumeroAlumnos.getText().matches("^[0-9]+$")){
            camposCorrectos = false;
        }
        if(cbGravedad.getSelectionModel().isEmpty()){
            camposCorrectos = false;
        }
        if(cbCategoria.getSelectionModel().isEmpty()){
            camposCorrectos = false;
        }
        if(taDescripcion.getText().isEmpty()){
            camposCorrectos = false;
        }
        return camposCorrectos;
    }

    private void insertarProblemáticaAcadémica() {
        problematicaAcademicaRegistro = new ProblemáticaAcadémica();
        problematicaAcademicaRegistro.setNumAlum(parseInt(tfNumeroAlumnos.getText()));
        problematicaAcademicaRegistro.setDescripcion(taDescripcion.getText());
        problematicaAcademicaRegistro.setGravedad(cbGravedad.getSelectionModel().getSelectedItem());
        problematicaAcademicaRegistro.setCategoria(cbCategoria.getSelectionModel().getSelectedItem());
        problematicaAcademicaRegistro.setIdReporteTutoria(idReporte);
        problematicaAcademicaRegistro.setIdPeriodo(idPeriodo);
        String solucion;                                                        /*Preparar ingreso de solucion en caso de que esta esté vacía.*/
        if(taSolucion.getText().isEmpty()){
            solucion = null;
        }else{
            solucion = taSolucion.getText();
        }
        problematicaAcademicaRegistro.setSolucion(solucion);
    }

    public void configurarIDs(Periodo periodo) {
        idPeriodo = periodo.getIdPeriodo();
    }

    public ProblemáticaAcadémica getProblematicaAcademicaRegistro() {
        return problematicaAcademicaRegistro;
    }
}
