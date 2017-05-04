/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Content;

import Content.GamerRegister;
import Content.Gamer;
import java.util.HashSet;
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
        System.out.println("testing fillGamers map size");
        GamerRegister instance = new GamerRegister();
        instance.fillRegister();
        int expSize;
        expSize = instance.GAMERREGISTER.size();
        int expResult = 3;
        
        assertEquals(expSize, expResult);
    }

    /**
     * Test of findGamer method, of class GamerRegister.
     */
    @Test
    public void testFindGamer() {
        System.out.println("Testing find gamer ScoopeX");
        
        GamerRegister instance = new GamerRegister();
        String expResult = "SCOOPEX";
        Gamer objExpected = instance.GAMERREGISTER.get("ScoopeX");
        HashSet<String> words = new HashSet<>();
        words.add(expResult);
        Gamer objResult = instance.GAMERREGISTER.get(words);
        
        assertEquals(objExpected, objResult);
    }
    
       /**
     * Test of findGamer method, of class GamerRegister.
     */
    @Test
    public void testFailFindGamer() {
        System.out.println("Testing fail to find gamer ScoopeX");
        
        GamerRegister instance = new GamerRegister();
        String expResult = "SCOOPEX";
        Gamer objExpected = instance.GAMERREGISTER.get("SCOOPEX");
        HashSet<String> words = new HashSet<>();
        words.add(expResult);
        Gamer objResult = instance.findGamer(words);
        
        assertEquals(objExpected, objResult);
    }

    /**
     * Test of gamertagsResolved method, of class GamerRegister.
     */
    @Test
    public void testGamertagsResolved() {
        System.out.println("Testing gamertagsResolved");
        GamerRegister instance = new GamerRegister();
        int expResult = 0;
        int result = instance.gamertagsResolved();
        
        assertEquals(expResult, result);
      
    }
    
    /**
     * Test with multiple gamertag lookups in gamertagsResolved method, of class
     * GamerRegister
     */
    @Test
    public void testMultipleGamertagsResolved() {
        System.out.println("Testing multiple gamertagsResolved");
        GamerRegister instance = new GamerRegister();
        //System.out.println(instance.gamertagsResolved());
        //instance.gamerMatchReset();
        //System.out.println(instance.gamertagsResolved());
        String firstTest = "SCOOPEX";
        HashSet<String> words = new HashSet<>();
        words.add(firstTest);
        instance.findGamer(words);
        
        String secondTest = "DERPINA";
        HashSet<String> word2 = new HashSet<>();
        word2.add(secondTest);
        instance.findGamer(word2);
        
        String thirdTest = "SCOOPEX";
        HashSet<String> word3 = new HashSet<>();
        word3.add(thirdTest);
        instance.findGamer(word3);
        
        int expResult = 3;
        int result = instance.gamertagsResolved();
        
        assertEquals(expResult, result);
    }
}