/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndResponses;

import java.util.HashSet;
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
public class GamerRegisterTest {
    
    public GamerRegisterTest() {
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
     * Test of fillGamers method, of class GamerRegister.
     */
    @Test
    public void testFillGamers() {
        System.out.println("fillGamers");
        GamerRegister instance = new GamerRegister();
        instance.fillGamers();
        int expSize;
        expSize = instance.gamerRegister.size();
        int expResult = 3;
        assertEquals(expSize, expResult);
    }

    /**
     * Test of findGamer method, of class GamerRegister.
     */
    @Test
    public void testFindGamer() {
        System.out.println("ScoopeX");
        
        GamerRegister instance = new GamerRegister();
        String expResult = "SCOOPEX";
        HashSet<String> words = new HashSet<>();
        words.add(expResult);
        String result = instance.findGamer(words);
        assertEquals(expResult, result);
    }

    /**
     * Test of gamertagsResolved method, of class GamerRegister.
     */
    @Test
    public void testGamertagsResolved() {
        System.out.println("gamertagsResolved");
        GamerRegister instance = new GamerRegister();
        int expResult = 0;
        int result = instance.gamertagsResolved();
        assertEquals(expResult, result);
      
    }
    
}
