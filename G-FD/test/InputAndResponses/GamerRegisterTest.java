/*
 * Copyright 2017 Tor Borgen <Tor Borgen at CastleDev>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
        System.out.println("testing fillGamers map size");
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
        System.out.println("Testing find gamer ScoopeX");
        
        GamerRegister instance = new GamerRegister();
        String expResult = "SCOOPEX";
        Gamer objExpected = instance.gamerRegister.get("ScoopeX");
        HashSet<String> words = new HashSet<>();
        words.add(expResult);
        Gamer objResult = instance.gamerRegister.get(words);
        
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
        Gamer objExpected = instance.gamerRegister.get("SCOOPEX");
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
