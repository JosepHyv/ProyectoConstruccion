/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 15/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Archivo de pruebas del Controlador de la ventana SeleccionProfesor.
*/
package proyectoconstruccion.vistas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import proyectoconstruccion.modelo.pojo.ExperienciaEducativa;

/**
 *
 * @author Panther
 */
public class FXMLSeleccionProfesorControllerTest {
    
    public FXMLSeleccionProfesorControllerTest() {
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
    
    /**
     * Test of pasarExperienciaEducativa method, of class FXMLSeleccionProfesorController.
     */
    @Test
    public void testPasarExperienciaEducativa() {
        System.out.println("pasarExperienciaEducativa");
        ExperienciaEducativa experienciaEducativa = null;
        FXMLSeleccionProfesorController instance = new FXMLSeleccionProfesorController();
        instance.pasarExperienciaEducativa(experienciaEducativa);
    }
    
}
