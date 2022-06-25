/*
* Autor: Joseph Hynimoto Aguilar Lopez
* Fecha de creacion: 17/06/22
* Fecha de modificacion: 20/06/22 
* Descripcion: Archivo de pruebas para el metodo getPeriodo del DAO Periodo
*/
package proyectoconstruccion.modelo.DAO;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectoconstruccion.modelo.pojo.Periodo;

/**
 *
 * @author JosepHy
 */
public class PeriodoDAOTest {
    
    public PeriodoDAOTest() {
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
     * Test of getPeriodoActual method, of class PeriodoDAO.
     */
    
    public Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }
    
    @Test
    public void testGetPeriodoActual() {
        System.out.println("getPeriodoActual");
        Periodo expResult = new Periodo();
        expResult.setIdPeriodo(2);
        Date fechas = StringToDate("2022-08-15");
        expResult.setFechaInicio(fechas);
        fechas  = StringToDate("2022-12-2");
        expResult.setFechaFin(fechas);
        System.out.println(fechas);
        Periodo result = PeriodoDAO.getPeriodoActual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
