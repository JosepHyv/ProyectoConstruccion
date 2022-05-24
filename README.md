# ProyectoConstruccion
Sistema Básico para gestión de Tutorias Académicas de la Universidad Veracruzana Facultad de Estadística e Informática


# Propiedades 
 Se utilizará una configuracion base para todas las pantallas, las cuales son las siguientes:
## Resolcuion 
* 720 x 480 en cada una de las escenas.
* Habilitar Set Resizeable.
``` java

	stage.setResizeable(false);
	/// :P
```
* Icono de aplicación [icono Chido]()
``` java

import javafx.scene.image.Image;

public void start(....){
		Parent root = FXMLLoader.load(getClass().getResource("vistas/FXMLInicioSesion.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.getIcons().add(new Image("directory"));
        stage.setScene(scene);
        stage.setTitle("Inicio de Sesión");
        stage.show();
}

```

## Utilidades
``` java 

import org.apache.commons.lang3.StringUtils; /// for java  >= 11 .jar needed

if(StringUtils.isBlank(password)){
            lbErrorContrasenia.setText("Campo Contraseña Requerido");
            valido = false;
        }

```



 
