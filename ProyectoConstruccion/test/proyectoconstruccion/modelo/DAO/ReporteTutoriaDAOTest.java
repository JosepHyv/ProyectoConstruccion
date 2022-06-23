
package proyectoconstruccion.modelo.DAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectoconstruccion.modelo.pojo.ReporteTutoria;

public class ReporteTutoriaDAOTest {
    
    public ReporteTutoriaDAOTest() {
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
    public void testInsertarReporteTutoria() {
        System.out.println("insertarReporteTutoria");
        ReporteTutoria reporteTutoriaRegistro = null;
        int expResult = 0;
        int result = ReporteTutoriaDAO.insertarReporteTutoria(reporteTutoriaRegistro);
        assertEquals(expResult, result);
    }
}
