/*
* Autor: Leonardo Criollo Ramírez
* Fecha de creacion: 17/05/22
* Fecha de modificacion: 21/06/22
* Descripcion: Clase principal del programa.
*/
package proyectoconstruccion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ProyectoConstruccion extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vistas/FXMLInicioDeSesion.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.getIcons().add(new Image("proyectoconstruccion/resources/icono.png"));
        stage.setScene(scene);
        stage.setTitle("Inicio de Sesión");
        stage.setX(0);
        stage.setY(0);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
