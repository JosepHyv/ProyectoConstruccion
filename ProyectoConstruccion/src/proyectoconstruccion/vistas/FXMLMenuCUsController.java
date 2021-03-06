/*
 * Autor: Leonardo Criollo Ramírez
 * Fecha de creación: 15/06/22
 * Fecha de modificación: 22/06/22
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectoconstruccion.modelo.pojo.Usuario;
import proyectoconstruccion.util.Utilidades;

public class FXMLMenuCUsController implements Initializable {

    @FXML
    private Label lbBienvenido;
    @FXML
    private Button btnLlenarReporte;
    @FXML
    private Button btnConsultarProblematicaAcademica;
    @FXML
    private Button btnConsultarOfertaAcademica;
    @FXML
    private Button btnAsignarExperienciaEducativa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final String ROL_USUARIO = Usuario.usuarioLogin.getRol();//InformacionSesion.getInformacionSesion().getRol();
        configurarBotones(ROL_USUARIO);
    }    

    @FXML
    private void btLlenarReporteTutorias(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLlenarReorteDeTutorias.fxml"));
           Parent root = loader.load();
           Scene escenaReporteTutorias = new Scene(root);
           Stage escenarioReporteTutorias = new Stage();
           escenarioReporteTutorias.getIcons().add(new Image("proyectoconstruccion/resources/icono.png"));
           escenarioReporteTutorias.setScene(escenaReporteTutorias);
           escenarioReporteTutorias.initModality(Modality.APPLICATION_MODAL);
           escenarioReporteTutorias.centerOnScreen();
           escenarioReporteTutorias.showAndWait();
        }catch(IOException e){
            Utilidades.mostrarAlerta("Error", "Error al mostrar ventana", Alert.AlertType.ERROR);
        }
    }

    private void btRegistrarProblematica(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistrarProblemáticaAcadémica.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarProblematica = new Scene(root);
           Stage escenarioRegistrarProblematica = new Stage();
           escenarioRegistrarProblematica.getIcons().add(new Image("proyectoconstruccion/resources/icono.png"));
           escenarioRegistrarProblematica.setScene(escenaRegistrarProblematica);
           escenarioRegistrarProblematica.initModality(Modality.APPLICATION_MODAL);
           escenarioRegistrarProblematica.centerOnScreen();
           escenarioRegistrarProblematica.showAndWait();
        }catch(IOException e){
            Utilidades.mostrarAlerta("Error", "Error al mostrar ventana", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void btnConsultarProblematica(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLConsultarProblemáticaAcadémica.fxml"));
           Parent root = loader.load();
           Scene escenaConsultarProblematica = new Scene(root);
           Stage escenarioConsultarProblematica = new Stage();
           escenarioConsultarProblematica.getIcons().add(new Image("proyectoconstruccion/resources/icono.png"));
           escenarioConsultarProblematica.setScene(escenaConsultarProblematica);
           escenarioConsultarProblematica.initModality(Modality.APPLICATION_MODAL);
           escenarioConsultarProblematica.centerOnScreen();
           escenarioConsultarProblematica.showAndWait();
        }catch(IOException e){
            Utilidades.mostrarAlerta("Error", "Error al mostrar ventana", Alert.AlertType.ERROR);
        
        }
    }

    @FXML
    private void btConsultarOfertaAcademica(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLOfertaAcademica.fxml"));
           Parent root = loader.load();
           Scene escenaOfertaAcademica = new Scene(root);
           Stage escenarioOfertaAcademica = new Stage();
           escenarioOfertaAcademica.getIcons().add(new Image("proyectoconstruccion/resources/icono.png"));
           escenarioOfertaAcademica.setScene(escenaOfertaAcademica);
           escenarioOfertaAcademica.initModality(Modality.APPLICATION_MODAL);
           escenarioOfertaAcademica.centerOnScreen();
           escenarioOfertaAcademica.showAndWait();
        }catch(IOException e){
            Utilidades.mostrarAlerta("Error", "Error al mostrar ventana", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void btAsignarExperienciaEducativa(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAsignarExperienciaAProfesor.fxml"));
           Parent root = loader.load();
           Scene escenaAsignarExperiencia = new Scene(root);
           Stage escenarioAsignarExperiencia = new Stage();
           escenarioAsignarExperiencia.getIcons().add(new Image("proyectoconstruccion/resources/icono.png"));
           escenarioAsignarExperiencia.setScene(escenaAsignarExperiencia);
           escenarioAsignarExperiencia.initModality(Modality.APPLICATION_MODAL);
           escenarioAsignarExperiencia.centerOnScreen();
           escenarioAsignarExperiencia.showAndWait();
        }catch(IOException e){
            Utilidades.mostrarAlerta("Error", "Error al mostrar ventana", Alert.AlertType.ERROR);            
        }
    }
    
    @FXML
    private void btCerrarSesion(ActionEvent event) {
        if(Utilidades.mostrarAlertaConfirmacion("Advertencia", "¿Seguro que desea cerrar sesión?", Alert.AlertType.CONFIRMATION).get() == ButtonType.OK){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInicioDeSesion.fxml"));
                Parent root = loader.load();
                Stage escenarioPrincipal = (Stage) lbBienvenido.getScene().getWindow();
                Scene pantallaAlumnos = new Scene(root);
                escenarioPrincipal.setScene(pantallaAlumnos);
                escenarioPrincipal.setTitle("Asignar profesor a experiencia educativa");
                escenarioPrincipal.centerOnScreen();
                escenarioPrincipal.show();
            } catch (IOException e) {
                Utilidades.mostrarAlerta("Error", "Error al mostrar ventana", Alert.AlertType.ERROR);
            }
        }
    }
    
    private void cerrarVentana() {
        Stage escenario = (Stage) lbBienvenido.getScene().getWindow();
        escenario.close();
    }

    private void configurarBotones(String rolUsuario) {
        if(rolUsuario.toLowerCase().equals("tutor")){
            btnAsignarExperienciaEducativa.setVisible(false);
        }else if(rolUsuario.toLowerCase().equals("coordinador")){
            btnLlenarReporte.setVisible(false);
            btnConsultarProblematicaAcademica.setVisible(false);
            btnAsignarExperienciaEducativa.setVisible(false);
        }else if(rolUsuario.toLowerCase().equals("administrador")){
            btnLlenarReporte.setVisible(false);
            btnConsultarProblematicaAcademica.setVisible(false);
            btnConsultarOfertaAcademica.setVisible(false);
        }
    }
    
}
