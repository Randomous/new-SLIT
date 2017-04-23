/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebInput;

import InputAndResponses.Start;
import java.util.HashSet;

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
public class Info {
        
        public String name;
        public String help;
    public Info() {
        Start start = new Start();
        help = start.printWelcomeHTML();
       
        
        
    }
    public void setHelp() {
       /**this.name = name;
        Start start = new Start();
        HashSet<String> find = new HashSet<>();
        find.add(name);
        name = start.start(find);
        this.name = name;
        */
        help = "test";
    }

}
