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
        Responder instance = new Responder();
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
        Responder instance = new Responder();
        //System.out.println(instance.amountOfResponses());
        //instance.resetTotalResponses();
        int responseAmount = 0;
        while (responseAmount < 11) {
        instance.generateResponse();
        responseAmount++;
        }
        int expResult = 11;
        int result = instance.amountOfResponses();
        
        //Result becomes 13 due to 2 generated responses by previous tests
        // Var does not reset due to private static
        // Implemented loop to calculate for difference but chosing to keep err
        
        assertEquals(expResult, result);
    }
    
}
