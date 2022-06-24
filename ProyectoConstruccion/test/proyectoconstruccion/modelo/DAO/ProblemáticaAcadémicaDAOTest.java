/*
* Autor: Leonardo Criollo Ramírez
* Fecha de creacion: 15/06/22
* Fecha de modificacion: 15/06/22
* Descripcion: Archivo de pruebas para las operaciones del DAO de problemática académica.
*/
package proyectoconstruccion.modelo.DAO;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectoconstruccion.modelo.pojo.ProblemáticaAcadémica;

public class ProblemáticaAcadémicaDAOTest {
    
    public ProblemáticaAcadémicaDAOTest() {
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
    public void testInsertarProblemáticaAcadémica() {
        System.out.println("insertarProblem\u00e1ticaAcad\u00e9mica");
        ProblemáticaAcadémica problematicaAcademicaRegistro = new ProblemáticaAcadémica();
        problematicaAcademicaRegistro.setCategoria("cátedra");
        problematicaAcademicaRegistro.setDescripcion("Malas clases.");
        problematicaAcademicaRegistro.setGravedad("baja");
        problematicaAcademicaRegistro.setNumAlum(0);
        problematicaAcademicaRegistro.setSolucion("Hablar con el docente.");
        problematicaAcademicaRegistro.setIdReporteTutoria(0);
        problematicaAcademicaRegistro.setIdPeriodo(PeriodoDAO.getPeriodoActual().getIdPeriodo());
        int expResult = 0;
        int result = ProblemáticaAcadémicaDAO.insertarProblemáticaAcadémica(problematicaAcademicaRegistro);
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerProblemáticaAcadémicas() {
        System.out.println("obtenerProblem\u00e1ticaAcad\u00e9micas");
        int periodo = 1;
        ArrayList<ProblemáticaAcadémica> expResult = null;
        ArrayList<ProblemáticaAcadémica> result = ProblemáticaAcadémicaDAO.obtenerProblemáticaAcadémicas(periodo);
        assertEquals(expResult, result);
    }
    
}
