/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Content;

import Content.StudentRegister;
import Content.student;
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
public class StudentRegisterTest {
    
    public StudentRegisterTest() {
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
     * Test of fillStudents method, of class StudentRegister.
     */
    @Test
    public void testFillStudents() {
        System.out.println("testing fillStudents map size");
        StudentRegister instance = new StudentRegister();
        instance.fillRegister();
        int expSize;
        expSize = instance.STUDENTREGISTER.size();
        int expResult = 3;
        
        assertEquals(expSize, expResult);
    }

    /**
     * Test of findStudent method, of class StudentRegister.
     */
    @Test
    public void testFindStudent() {
        System.out.println("Testing find student Eirik");
        
        StudentRegister instance = new StudentRegister();
        String expResult = "EIRIK";
        student objExpected = instance.STUDENTREGISTER.get("Eirik");
        HashSet<String> words = new HashSet<>();
        words.add(expResult);
        student objResult = instance.STUDENTREGISTER.get(words);
        
        assertEquals(objExpected, objResult);
    }
    
       /**
     * Test of findStudent method, of class StudentRegister.
     */
    @Test
    public void testFailFindStudent() {
        System.out.println("Testing fail to find student Eirik");
        
        StudentRegister instance = new StudentRegister();
        String expResult = "EIRIK";
        student objExpected = instance.STUDENTREGISTER.get("EIRIK");
        HashSet<String> words = new HashSet<>();
        words.add(expResult);
        student objResult = instance.findStudent(words);
        
        assertEquals(objExpected, objResult);
    }

    /**
     * Test of firstnamesResolved method, of class StudentRegister.
     */
    @Test
    public void testFirstnamesResolved() {
        System.out.println("Testing firstnamesResolved");
        StudentRegister instance = new StudentRegister();
        int expResult = 0;
        int result = instance.firstnamesResolved();
        
        assertEquals(expResult, result);
      
    }
    
    /**
     * Test with multiple firstname lookups in firstnamesResolved method, of class
     * StudentRegister
     */
    @Test
    public void testMultipleFirstnamesResolved() {
        System.out.println("Testing multiple firstnamesResolved");
        StudentRegister instance = new StudentRegister();
        //System.out.println(instance.firstnamesResolved());
        //instance.studentMatchReset();
        //System.out.println(instance.firstnamesResolved());
        String firstTest = "EIRIK";
        HashSet<String> words = new HashSet<>();
        words.add(firstTest);
        instance.findStudent(words);
        
        String secondTest = "KÅRE";
        HashSet<String> word2 = new HashSet<>();
        word2.add(secondTest);
        instance.findStudent(word2);
        
        String thirdTest = "EIRIK";
        HashSet<String> word3 = new HashSet<>();
        word3.add(thirdTest);
        instance.findStudent(word3);
        
        int expResult = 3;
        int result = instance.firstnamesResolved();
        
        assertEquals(expResult, result);
    }
}