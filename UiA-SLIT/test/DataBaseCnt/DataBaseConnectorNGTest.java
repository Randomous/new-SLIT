/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseCnt;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author danie
 */
public class DataBaseConnectorNGTest {
    
    public DataBaseConnectorNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of executeSQLQuery method, of class DataBaseConnector.
     */
    @Test
    public void testExecuteSQLQuery() {
        System.out.println("executeSQLQuery");
        String testEnv = "";
        String sqlQuery = "";
        String expResult = "";
        String result = DataBaseConnector.executeSQLQuery(testEnv, sqlQuery);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeSQLQuery_List method, of class DataBaseConnector.
     */
    @Test
    public void testExecuteSQLQuery_List() {
        System.out.println("executeSQLQuery_List");
        String testEnv = "";
        String sqlQuery = "";
        ArrayList expResult = null;
        ArrayList result = DataBaseConnector.executeSQLQuery_List(testEnv, sqlQuery);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
