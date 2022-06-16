/*
* Autor: Joseph Hynimoto
* Fecha de creacion: 13/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Controlador de la Ventana de llenado de reporte de tutorias.
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectoconstruccion.modelo.pojo.Periodo;
import proyectoconstruccion.modelo.pojo.Estudiante;
import proyectoconstruccion.modelo.pojo.ReporteTutoria;
import proyectoconstruccion.util.Utilidades;
import proyectoconstruccion.modelo.DAO.EstudiantesDAO;
import proyectoconstruccion.modelo.DAO.PeriodoDAO;
import proyectoconstruccion.modelo.DAO.ReporteTutoriaDAO;

public class FXMLLlenarReorteDeTutoriasController implements Initializable {

    @FXML
    private TableView<Estudiante> tbReporte;
    @FXML
    private TextArea taComentarios;
    @FXML
    private Button btnRegistroProblematica;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    
    private Periodo periodo;
    
    private Integer idReporte;
    
    private ObservableList<Estudiante> infoEstudiante;
    @FXML
    private TableColumn coAsistencia;
    @FXML
    private TableColumn coNombre;
    @FXML
    private TableColumn coApellidoPaterno;
    @FXML
    private TableColumn coApellidoMaterno;
    @FXML
    private TableColumn coMatricula;
    @FXML
    private TableColumn coSemestre;
    @FXML
    private TableColumn coCorreo;
    @FXML
    private TableColumn coRiesgo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarInformacion();
    }    

    @FXML
    private void irRegistrarProblematica(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistrarProblemáticaAcadémica.fxml"));
           Parent root = loader.load();
           FXMLRegistrarProblemáticaAcadémicaController controlador = loader.getController();
           controlador.configurarIDs(idReporte, periodo);
           Scene escenaRegistrarProblematica = new Scene(root);
           Stage escenarioRegistrarProblematica = new Stage();
           escenarioRegistrarProblematica.setScene(escenaRegistrarProblematica);
           escenarioRegistrarProblematica.initModality(Modality.APPLICATION_MODAL);
           escenarioRegistrarProblematica.showAndWait();
        }catch(IOException e){
            Utilidades.mostrarAlerta("Error", "Error al mostrar ventana", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    private void btCancelar(ActionEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage escenario = (Stage) btnCancelar.getScene().getWindow();
        escenario.close();
    }
    
    private void configurarColumnasTabla() {
        coAsistencia.setCellValueFactory(new PropertyValueFactory("cbAsistencia"));
        coNombre.setCellValueFactory(new PropertyValueFactory("nombres"));
        coApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        coApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        coMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        coSemestre.setCellValueFactory(new PropertyValueFactory("semestre"));
        coCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        coRiesgo.setCellValueFactory(new PropertyValueFactory("cbRiesgo"));
        infoEstudiante = FXCollections.observableArrayList();
    }
    
    private void cargarInformacion() {
        ArrayList<Estudiante> resultadoConsulta = EstudiantesDAO.obtenerEstudiantesPorTutor();
        if(resultadoConsulta != null){
            try{
            tbReporte.getItems().clear();
            infoEstudiante.addAll(resultadoConsulta);
            tbReporte.setItems(infoEstudiante);
            }catch(NullPointerException e){
                e.printStackTrace();
            }
        }else{
            Utilidades.mostrarAlerta("Error", "No hay conexion con la base de datos.", Alert.AlertType.ERROR);
        }
        this.periodo = PeriodoDAO.getPeriodoActual();
        if(ReporteTutoriaDAO.getNumeroReporteMasActual() == Integer.MIN_VALUE){
            Utilidades.mostrarAlerta("Error", "Error obteniendo número reporte más reciente", Alert.AlertType.ERROR);
        }else{
            this.idReporte = ReporteTutoriaDAO.getNumeroReporteMasActual();
        }
    }

    @FXML
    private void btGuardar(ActionEvent event) {
        guardarReporte();

    }

    private void guardarReporte() {
        ReporteTutoria reporteRegistro = new ReporteTutoria();
        reporteRegistro.setComentarios(taComentarios.getText());
        reporteRegistro.setProgramaEducativo("Ingeniería en Software");
        reporteRegistro.setFecha("null");
        reporteRegistro.setNumAsistencia(tbReporte.getItems().size());
        reporteRegistro.setNumReporte(tbReporte.getItems().size());
        ReporteTutoriaDAO.insertarReporteTutoria(reporteRegistro);
    }
    
}
