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
 * @author adm-tor
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
        System.out.println("generateResponse");
        Responder instance = new Responder();
        String result = instance.generateResponse();
        boolean expResult;
        expResult = instance.answerArray.contains(result);
        //assertEquals(expResult, instance.amountOfResponses());
        assertTrue(result, true );
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of amountOfResponses method, of class Responder.
     */
    @Test
    public void testAmountOfResponses() {
        System.out.println("amountOfResponses");
        Responder instance = new Responder();
        instance.generateResponse();
        int expResult = 1;
        int result = instance.amountOfResponses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
