/*
* Autor: Joseph Hynimoto Aguilar Lopez
* Fecha de creacion: 17/06/22
* Fecha de modificacion: 20/06/22 
* Descripcion: Archivo de pruebas para el metodo Iniciar Sesion de Usuario DAO
*/
package proyectoconstruccion.modelo.DAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectoconstruccion.modelo.pojo.Usuario;
import proyectoconstruccion.util.Constantes;
/**
 *
 * @author JosepHy
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
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
     * Test of IniciarSesion method, of class UsuarioDAO.
     */
    @Test
    public void testIniciarSesion() {
        System.out.println("IniciarSesion");
        String username = "angels";
        String password = "USERTUTOR";
        int expResult = Constantes.CODIGO_OPERACION_CORRECTA;
        UsuarioDAO.IniciarSesion(username, password);
        int result = Usuario.usuarioLogin.getCodigoRespuesta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
