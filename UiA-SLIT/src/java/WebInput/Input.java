package WebInput;
import javax.jws.WebService;
import InputAndResponses.Start;
import java.util.HashSet;
import InputAndResponses.CommandFolder.Commands;
import Content.ModuleRegister;


    @WebService
public class Input {
        
        public String name;
        public String help;
        public Start start;
        public Commands com;
        public String commands;
        public ModuleRegister module;
        
public Input() {
        name = null;
        help = null;
       commands = null;
       start = new Start();
       com = new Commands();
       module = new ModuleRegister();
    }
    
    //Get and return the module as string
    public String getModule() {
        return module.getRegister();
    }
    //get name returned as string
    public String getName() {
       return name;
    }
    //get help from method, returns string
    public String getHelp() {
        
        return help = start.GetWebWelcome();
    }
    //get commands returned as string
    public String getCommands() {
        return commands = com.displayCommands();
    }
    //set help
    public void setHelp(String help) {
         
         help = start.GetWebWelcome();
         //help = "tettet";
         //this.help = help;
    }
    //Set name from input
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
    

