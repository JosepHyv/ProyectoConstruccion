/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 15/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Archivo de pruebas para las operaciones del DAO de profesor.
*/
package proyectoconstruccion.modelo.DAO;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectoconstruccion.modelo.pojo.Profesor;

/**
 *
 * @author Panther
 */
public class ProfesorDAOTest {
    
    public ProfesorDAOTest() {
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
     * Test of obtenerProfesores method, of class ProfesorDAO.
     */
    @Test
    public void testObtenerProfesores() {
        System.out.println("obtenerProfesores");
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(2);
        profesor.setNombres("Peter");
        profesor.setApellidoPaterno("Benjamin");
        profesor.setApellidoMaterno("Parker");
        profesor.setCorreo("peterParker@uv.mx");
        profesor.setTipoProfesor("Doctor");
        ArrayList<Profesor> expResult = new ArrayList<>();
        expResult.add(profesor);
        ArrayList<Profesor> result = ProfesorDAO.obtenerProfesores();
        assertEquals(expResult.get(0), result.get(0));
    }
    
}
