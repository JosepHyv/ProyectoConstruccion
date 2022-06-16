/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 15/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Archivo de pruebas del Controlador de la ventana AsignarExperienciaAProfesor.
*/
package proyectoconstruccion.vistas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import proyectoconstruccion.modelo.pojo.ExperienciaEducativa;
import proyectoconstruccion.modelo.pojo.Profesor;

/**
 *
 * @author Panther
 */
public class FXMLAsignarExperienciaAProfesorControllerTest {
    
    public FXMLAsignarExperienciaAProfesorControllerTest() {
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
     * Test of asignarProfesor method, of class FXMLAsignarExperienciaAProfesorController.
     */
    @Test
    public void testAsignarProfesor() {
        System.out.println("asignarProfesor");
        Profesor profesor = null;
        ExperienciaEducativa experienciaEducativa = null;
        FXMLAsignarExperienciaAProfesorController instance = new FXMLAsignarExperienciaAProfesorController();
        instance.asignarProfesor(profesor, experienciaEducativa);
    }
    
}
