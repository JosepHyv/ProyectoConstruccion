/*
* Autor: Leonardo Criollo Ramírez
* Fecha de creacion: 15/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Archivo de pruebas del Controlador de la ventana RegistrarProblemáticaAcadémica.
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
import proyectoconstruccion.modelo.pojo.Periodo;

public class FXMLRegistrarProblemáticaAcadémicaControllerTest {
    
    public FXMLRegistrarProblemáticaAcadémicaControllerTest() {
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
        FXMLRegistrarProblemáticaAcadémicaController instance = new FXMLRegistrarProblemáticaAcadémicaController();
        instance.initialize(url, rb);
    }

    @Test
    public void testConfigurarCampos() {
        System.out.println("configurarCampos");
        FXMLRegistrarProblemáticaAcadémicaController instance = new FXMLRegistrarProblemáticaAcadémicaController();
        instance.configurarCampos();
    }

    /**
     * Test of setControlador method, of class FXMLRegistrarProblemáticaAcadémicaController.
     */
    @Test
    public void testSetControlador() {
        System.out.println("setControlador");
        FXMLLlenarReorteDeTutoriasController controlador = null;
        FXMLRegistrarProblemáticaAcadémicaController instance = new FXMLRegistrarProblemáticaAcadémicaController();
        instance.setControlador(controlador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of configurarIDs method, of class FXMLRegistrarProblemáticaAcadémicaController.
     */
    @Test
    public void testConfigurarIDs() {
        System.out.println("configurarIDs");
        Periodo periodo = null;
        FXMLRegistrarProblemáticaAcadémicaController instance = new FXMLRegistrarProblemáticaAcadémicaController();
        instance.configurarIDs(periodo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
