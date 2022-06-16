/*
* Autor: Juan Pablo Peredo Martínez
* Fecha de creacion: 15/06/22
* Fecha de modificacion: 15/06/22
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

    /**
     * Test of obtenerExperienciaEducativas method, of class ExperienciaEducativaDAO.
     */
    @Test
    public void testObtenerExperienciaEducativas() {
        System.out.println("obtenerExperienciaEducativas");
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setNombre("Redes");
        experienciaEducativa.setIdExperienciaEducativa(1);
        experienciaEducativa.setNrc("0001");
        experienciaEducativa.setProgramaEducativo("Ingenieria en Software");
        experienciaEducativa.setArea("Economico Administrativa");
        experienciaEducativa.setSemestreRecomendado(5);
        ArrayList<ExperienciaEducativa> expResult = new ArrayList<>();
        expResult.add(experienciaEducativa);
        ArrayList<ExperienciaEducativa> result = ExperienciaEducativaDAO.obtenerExperienciaEducativas();
        assertEquals(expResult.get(0), result.get(0));
    }

    /**
     * Test of obtenerExperienciaEducativasSinProfesor method, of class ExperienciaEducativaDAO.
     */
    @Test
    public void testObtenerExperienciaEducativasSinProfesor() {
        System.out.println("obtenerExperienciaEducativasSinProfesor");
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setNombre("Principios De Construccion de Software");
        experienciaEducativa.setIdExperienciaEducativa(3);
        experienciaEducativa.setNrc("0003");
        experienciaEducativa.setProgramaEducativo("Ingenieria en Software");
        experienciaEducativa.setArea(null);
        experienciaEducativa.setSemestreRecomendado(0);
        ArrayList<ExperienciaEducativa> expResult = new ArrayList<>();
        expResult.add(experienciaEducativa);
        ArrayList<ExperienciaEducativa> result = ExperienciaEducativaDAO.obtenerExperienciaEducativasSinProfesor();
        assertEquals(expResult.get(0), result.get(0));
    }

    /**
     * Test of asignarProfesorAExperiencia method, of class ExperienciaEducativaDAO.
     */
    @Test
    public void testAsignarProfesorAExperiencia() {
        System.out.println("asignarProfesorAExperiencia");
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(2);
        profesor.setNombres("Peter");
        profesor.setApellidoPaterno("Benjamin");
        profesor.setApellidoMaterno("Parker");
        profesor.setCorreo("peterParker@uv.mx");
        profesor.setTipoProfesor("Doctor");
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setNombre("Principios De Construccion de Software");
        experienciaEducativa.setIdExperienciaEducativa(3);
        experienciaEducativa.setNrc("0003");
        experienciaEducativa.setProgramaEducativo("Ingenieria en Software");
        experienciaEducativa.setArea(null);
        experienciaEducativa.setSemestreRecomendado(0);
        int expResult = 200;
        int result = ExperienciaEducativaDAO.asignarProfesorAExperiencia(profesor, experienciaEducativa);
        assertEquals(expResult, result);
    }
    
}
