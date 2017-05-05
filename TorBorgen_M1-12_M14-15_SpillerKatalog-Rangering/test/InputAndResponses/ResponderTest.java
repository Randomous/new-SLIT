/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndResponses;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
public class ResponderTest {
    
    public ResponderTest() {
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
     * Test of generateResponse method, of class Responder.
     */
    @Test
    public void testGenerateResponse() {
        System.out.println("Testing generateResponse");
        Responder instance = new Responder();
        String result = instance.generateResponse();
        boolean expResult;
        expResult = instance.answerArray.contains(result);
        //assertEquals(expResult, instance.amountOfResponses());
        assertTrue(result, expResult );
        
        
    }

    /**
     * Test of amountOfResponses method, of class Responder.
     */
    @Test
    public void testAmountOfResponses() {
        System.out.println("Testing amountOfResponses");
        Responder instance;
        instance = new Responder();
        instance.generateResponse();
        int expResult = 1;
        int result = instance.amountOfResponses();
        
        assertEquals(expResult, result);
    }
    
      /**
     * Test of multiple amountOfResponses method, of class Responder.
     */
    @Test
    public void testMultipleAmountOfResponses() {
        System.out.println("Testing multiple amountOfResponses");
        Responder instance;
        instance = new Responder();
        System.out.println(instance.amountOfResponses());
        instance.resetTotalResponses();
        int responseAmount = 0;
        while (responseAmount < 11) {
        instance.generateResponse();
        responseAmount++;
        }
        int expResult = 11;
        int result = instance.amountOfResponses();
        
        //Result becomes 13 due to 2 generated responses by previous tests
        // Var does not reset due to static
        
        assertEquals(expResult, result);
    }
    
}
