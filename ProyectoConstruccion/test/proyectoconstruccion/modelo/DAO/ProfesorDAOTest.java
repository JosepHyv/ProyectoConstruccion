/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        profesor.setIdProfesor(1);
        profesor.setNombres("Jaun");
        profesor.setApellidoPaterno("Clau");
        profesor.setApellidoMaterno("Van Dame");
        profesor.setCorreo("correo@example.com");
        profesor.setTipoProfesor("tiempo completo");
        ArrayList<Profesor> expResult = new ArrayList<>();
        expResult.add(profesor);
        ArrayList<Profesor> result = ProfesorDAO.obtenerProfesores();
        assertEquals(expResult.get(0), result.get(0));
    }
    
}
