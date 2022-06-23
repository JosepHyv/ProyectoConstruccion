/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 15/06/22
* Fecha de modificacion: 22/06/22
* Descripcion: Archivo de pruebas para las operaciones del DAO de experiencia educativa.
*/
package proyectoconstruccion.modelo.DAO;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectoconstruccion.modelo.pojo.ExperienciaEducativa;
import proyectoconstruccion.modelo.pojo.Profesor;

/**
 *
 * @author Panther
 */
public class ExperienciaEducativaDAOTest {
    
    public ExperienciaEducativaDAOTest() {
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
    public void testObtenerExperienciaEducativas() {
        System.out.println("obtenerExperienciaEducativas");
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setNombre("Matemáticas");
        experienciaEducativa.setIdExperienciaEducativa(1);
        experienciaEducativa.setNrc("74282");
        experienciaEducativa.setProgramaEducativo("Ingenieria de Software");
        experienciaEducativa.setArea("Básica");
        experienciaEducativa.setSemestreRecomendado(2);
        ArrayList<ExperienciaEducativa> expResult = new ArrayList<>();
        expResult.add(experienciaEducativa);
        ArrayList<ExperienciaEducativa> result = ExperienciaEducativaDAO.obtenerExperienciaEducativas();
        assertEquals(expResult.get(0), result.get(0));
    }

    @Test
    public void testObtenerExperienciaEducativasSinProfesor() {
        System.out.println("obtenerExperienciaEducativasSinProfesor");
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setNombre("Inglés");
        experienciaEducativa.setIdExperienciaEducativa(2);
        experienciaEducativa.setNrc("45689");
        experienciaEducativa.setProgramaEducativo("Ingenieria de Software");
        experienciaEducativa.setArea(null);
        experienciaEducativa.setSemestreRecomendado(0);
        ArrayList<ExperienciaEducativa> expResult = new ArrayList<>();
        expResult.add(experienciaEducativa);
        ArrayList<ExperienciaEducativa> result = ExperienciaEducativaDAO.obtenerExperienciaEducativasSinProfesor();
        assertEquals(expResult.get(0), result.get(0));
    }

    @Test
    public void testAsignarProfesorAExperiencia() {
        System.out.println("asignarProfesorAExperiencia");
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(1);
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setIdExperienciaEducativa(1);
        int expResult = 200;
        int result = ExperienciaEducativaDAO.asignarProfesorAExperiencia(profesor, experienciaEducativa);
        assertEquals(expResult, result);
    }
    
}
