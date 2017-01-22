/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndResponses;

import InputAndResponses.Start;
import java.io.ByteArrayInputStream;

/**
 *
 * @author Tor
 */
public class AutoTester {
    
public  AutoTester() {
    
    Start start = new Start();
    
}

public void tests() {
    //tester tlfeldig svar
    String generic;
    generic = "testing this random answer";
    System.setIn(new ByteArrayInputStream(generic.getBytes()));
    
    
}

    
}
