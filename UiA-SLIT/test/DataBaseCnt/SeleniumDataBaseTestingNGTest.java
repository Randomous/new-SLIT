package DataBaseCnt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class SeleniumDataBaseTestingNGTest {
    
    public SeleniumDataBaseTestingNGTest() {
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
     * Test of setUp method, of class SeleniumDataBaseTesting.
     */
    @Test
    public void testSetUp() {
        System.out.println("setUp");
        SeleniumDataBaseTesting instance = new SeleniumDataBaseTesting();
        instance.setUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeesFromDataBase method, of class SeleniumDataBaseTesting.
     */
    @Test
    public void testGetEmployeesFromDataBase() {
        System.out.println("getEmployeesFromDataBase");
        SeleniumDataBaseTesting instance = new SeleniumDataBaseTesting();
        instance.getEmployeesFromDataBase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tearDown method, of class SeleniumDataBaseTesting.
     */
    @Test
    public void testTearDown() {
        System.out.println("tearDown");
        SeleniumDataBaseTesting instance = new SeleniumDataBaseTesting();
        instance.tearDown();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private static class SeleniumDataBaseTesting {

        public SeleniumDataBaseTesting() {
        }

        private void tearDown() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void getEmployeesFromDataBase() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setUp() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
