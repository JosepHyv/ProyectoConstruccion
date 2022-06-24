/*
* Autor: Joseph Hynimoto
* Fecha de creacion: 13/06/22
* Fecha de modificacion: 19/06/22
* Descripcion: Controlador de la Ventana de llenado de reporte de tutorias.
*/
package proyectoconstruccion.vistas;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectoconstruccion.modelo.pojo.Periodo;
import proyectoconstruccion.modelo.pojo.ProblemáticaAcadémica;
import proyectoconstruccion.modelo.pojo.Estudiante;
import proyectoconstruccion.modelo.pojo.ReporteTutoria;
import proyectoconstruccion.util.Utilidades;
import proyectoconstruccion.modelo.DAO.EstudiantesDAO;
import proyectoconstruccion.modelo.DAO.PeriodoDAO;
import proyectoconstruccion.modelo.DAO.ProblemáticaAcadémicaDAO;
import proyectoconstruccion.modelo.DAO.ReporteTutoriaDAO;
import proyectoconstruccion.util.Constantes;

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
    
    private Periodo periodo;
    
    private Integer idReporte;
    
    private ArrayList<ProblemáticaAcadémica> problematicas = new ArrayList();
    

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
           controlador.configurarIDs(periodo);
           controlador.setControlador(this);
           Scene escenaRegistrarProblematica = new Scene(root);
           Stage escenarioRegistrarProblematica = new Stage();
           escenarioRegistrarProblematica.getIcons().add(new Image("proyectoconstruccion/resources/icono.png"));
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
        cerrarVentana(true);
    }

    private void cerrarVentana(boolean confirmacion) {
        Stage escenario = (Stage) btnCancelar.getScene().getWindow();
        if(confirmacion){
            if(Utilidades.mostrarAlertaConfirmacion("Advertencia", "¿Seguro que desea cancelar la operación?"
                    + " Se perderá toda la informacion y problemáticas guardadas.", Alert.AlertType.CONFIRMATION).get() == ButtonType.OK){
                escenario.close();
            }
        }else{
            escenario.close();
        }
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
    }

    @FXML
    private void btGuardar(ActionEvent event) {
        guardarReporte();
        guardarProblematicas();
        cerrarVentana(false);
    }

    private void guardarReporte() {
        ReporteTutoria reporteRegistro = new ReporteTutoria();
        reporteRegistro.setFecha(Date.valueOf(LocalDate.now()));
        reporteRegistro.setProgramaEducativo("Ingeniería en Software");
        reporteRegistro.setNumAsistencia(contarAsistencia());
        reporteRegistro.setNumRiesgo(contarRiesgo());
        reporteRegistro.setComentarios(taComentarios.getText());
        switch(ReporteTutoriaDAO.insertarReporteTutoria(reporteRegistro)){
            case Constantes.CODIGO_OPERACION_CORRECTA:
                System.out.println("Problematica Registrada");
                break;
            case Constantes.CODIGO_OPERACION_DML_FALLIDA:
                Utilidades.mostrarAlerta("Operacion fallida", "No se pudo realizar la operacion.", Alert.AlertType.WARNING);
                break;
            case Constantes.CODIGO_ERROR_CONEXIONBD:
                Utilidades.mostrarAlerta("Error de conexion", "No se pudo conectar con la base de datos, "
                        + "por favor intentelo de nuevo más tarde.", Alert.AlertType.ERROR);
                break;
            default:
                Utilidades.mostrarAlerta("Error", "Ocurrió un error desconocido", Alert.AlertType.ERROR);
        }
    }

    private Integer contarAsistencia() {
        int numAsistencia = 0;
        for (Estudiante estudiante : infoEstudiante){
            if(estudiante.getCbAsistencia().isSelected()){
                numAsistencia++;
            }
        }
        return numAsistencia;
    }

    private Integer contarRiesgo() {
        int numRiesgo = 0;
        for (Estudiante estudiante : infoEstudiante){
            if(estudiante.getCbRiesgo().isSelected()){
                numRiesgo++;
            }
        }
        return numRiesgo;
    }

    private void guardarProblematicas() {
        idReporte = ReporteTutoriaDAO.getIdUltimoReporte();
        if(idReporte != Integer.MIN_VALUE){
            for(ProblemáticaAcadémica problematicaAcademica : problematicas){
                problematicaAcademica.setIdReporteTutoria(idReporte);
                switch(ProblemáticaAcadémicaDAO.insertarProblemáticaAcadémica(problematicaAcademica)){
                    case Constantes.CODIGO_OPERACION_CORRECTA:
                        Utilidades.mostrarAlerta("Operacion correcta", "La Problemática Académica se registro de forma correcta", Alert.AlertType.INFORMATION);
                        break;
                   case Constantes.CODIGO_OPERACION_DML_FALLIDA:
                        Utilidades.mostrarAlerta("Operacion fallida", "No se pudo realizar la operacion.", Alert.AlertType.WARNING);
                        break;
                    case Constantes.CODIGO_ERROR_CONEXIONBD:
                        Utilidades.mostrarAlerta("Error de conexion", "No se pudo conectar con la base de datos, "
                                + "por favor intentelo de nuevo más tarde.", Alert.AlertType.ERROR);
                        break;
                    default:
                        Utilidades.mostrarAlerta("Error", "Ocurrió un error desconocido", Alert.AlertType.ERROR);
                }
            }
        }
    }

    public ArrayList<ProblemáticaAcadémica> getProblematicas() {
        return problematicas;
    }

    public void setProblematicas(ArrayList<ProblemáticaAcadémica> problematicas) {
        this.problematicas = problematicas;
    }
}
