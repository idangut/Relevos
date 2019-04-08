/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.relevos.Principal;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author duvan
 */
public class NewEmptyJUnitTest {
    Principal p = new Principal(1);
    static char[] equipoAmarrilo = new char[50];
    
    public NewEmptyJUnitTest() {
        
    }
      
     @Test
     public void prueba(){
         boolean esperado = p.llenar();
         assertTrue(esperado);
     }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
