package Test;
import javax.jws.WebMethod;
import javax.jws.WebService;
import InputAndResponses.Start;
import java.util.HashSet;
import InputAndResponses.CommandFolder.Commands;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
    @WebService
public class Test {
        
        public String name;
        public String help;
        public Start start;
        public Commands com;
        public String commands;
    public Test() {
        name = null;
        help = null;
       commands = null;
       start = new Start();
       com = new Commands();
        
        
    }
 

    public String getName() {
       return name;
    }
    
    public String getHelp() {
        
        return help = start.printWelcome();
    }
    public String getCommands() {
        return commands = com.displayCommands();
    }
    public void setHelp(String help) {
         
         help = start.printWelcome();
         //help = "tettet";
         //this.help = help;
    }

    public void setName(String name) {
       //this.name = name;
        //Start start = new Start();
        HashSet<String> find = new HashSet<>();
        String newname = name.trim().toUpperCase();
        String[] wordArray = newname.split(" ");
        
        for(String word : wordArray) {
        find.add(word);
        }
        
        //find.add(name);
        name = start.start(find);
        this.name = name;
       
    }

}
    

