/*
* Autor: Leonardo Criollo Ramírez
* Fecha de creacion: 15/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Archivo de pruebas del Controlador de la ventana ConsultarProblemáticaAcadémica.
*/
package proyectoconstruccion.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FXMLConsultarProblemáticaAcadémicaControllerTest {
    
    public FXMLConsultarProblemáticaAcadémicaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        FXMLConsultarProblemáticaAcadémicaController instance = new FXMLConsultarProblemáticaAcadémicaController();
        instance.initialize(url, rb);
    }
    
}
