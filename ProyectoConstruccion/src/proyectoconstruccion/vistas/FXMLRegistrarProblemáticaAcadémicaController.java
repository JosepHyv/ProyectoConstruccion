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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyectoconstruccion.modelo.DAO.ProblemáticaAcadémicaDAO;
import proyectoconstruccion.modelo.pojo.ProblemáticaAcadémica;
import proyectoconstruccion.util.Constantes;
import proyectoconstruccion.util.Utilidades;

/**
 * FXML Controller class
 *
 * @author ctr305
 */
public class FXMLRegistrarProblemáticaAcadémicaController implements Initializable {

    @FXML
    private TextField tfNumeroAlumnos;
    @FXML
    private TextField tfGravedad;
    @FXML
    private TextField tfCategoria;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private TextArea taSolucion;
    @FXML
    private Label lbErrorNumero;
    @FXML
    private Label lbErrorGravedad;
    @FXML
    private Label lbErrorCategoria;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarCampos();
    }    
    
    public void configurarCampos(){
        taDescripcion.setWrapText(true);
        taSolucion.setWrapText(true);
        lbErrorNumero.setText("");
        lbErrorGravedad.setText("");
        lbErrorCategoria.setText("");
        
        tfNumeroAlumnos.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                if(newValue.matches("[a-zA-Z]+")){
                    lbErrorNumero.setText("Campo inválido.");
                }else if(newValue.isEmpty()){
                    lbErrorNumero.setText("");
                }
            }
        });
        
        tfGravedad.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                if(newValue.matches("[0-9]+")){
                    lbErrorGravedad.setText("Campo inválido.");
                }else if(newValue.isEmpty()){
                    lbErrorGravedad.setText("");
                }
            }
        });
        
        tfCategoria.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                if(newValue.matches("[0-9]+")){
                    lbErrorCategoria.setText("Campo inválido.");
                }else if(newValue.isEmpty()){
                    lbErrorCategoria.setText("");
                }
            }
        });
        
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
        if(tfNumeroAlumnos.getText().isEmpty() || tfNumeroAlumnos.getText().matches("[a-zA-Z]+")){
            camposCorrectos = false;
        }
        if(tfGravedad.getText().isEmpty() || tfGravedad.getText().matches("[0-9]+")){
            camposCorrectos = false;
        }
        if(tfCategoria.getText().isEmpty() || tfCategoria.getText().matches("[0-9]+")){
            camposCorrectos = false;
        }
        if(taDescripcion.getText().isEmpty()){
            camposCorrectos = false;
        }
        return camposCorrectos;
    }

    private void insertarProblemáticaAcadémica() {
        ProblemáticaAcadémica problemáticaAcadémicaRegistro = new ProblemáticaAcadémica();
        problemáticaAcadémicaRegistro.setNumAlum(parseInt(tfNumeroAlumnos.getText()));
        problemáticaAcadémicaRegistro.setDescripcion(taDescripcion.getText());
        problemáticaAcadémicaRegistro.setGravedad(tfGravedad.getText());
        problemáticaAcadémicaRegistro.setCategoria(tfCategoria.getText());
        String solucion;                                                        /*Preparar ingreso de solucion en caso de que esta esté vacía.*/
        if(taSolucion.getText().isEmpty()){
            solucion = null;
        }else{
            solucion = taSolucion.getText();
        }
        problemáticaAcadémicaRegistro.setSolucion(solucion);
            
        switch(ProblemáticaAcadémicaDAO.insertarProblemáticaAcadémica(problemáticaAcadémicaRegistro)){
            case Constantes.CODIGO_OPERACION_CORRECTA:
                Utilidades.mostrarAlerta("Operacion correcta", "La Problemática Académica se registro de forma correcta", Alert.AlertType.CONFIRMATION);
                break;
            case Constantes.CODIGO_OPERACION_DML_FALLIDA:
                Utilidades.mostrarAlerta("Operacion fallida", "No se pudo realizar la operacion.", Alert.AlertType.WARNING);
                break;
            case Constantes.CODIGO_ERROR_CONEXIONBD:
                Utilidades.mostrarAlerta("Error de conexion", "Nose pudo conectar con la base de datos, "
                        + "por favor intentelo de nuevo más tarde.", Alert.AlertType.ERROR);
                break;
            default:
                Utilidades.mostrarAlerta("Error", "Ocurrió un error desconocido", Alert.AlertType.ERROR);
        }
    }
}
