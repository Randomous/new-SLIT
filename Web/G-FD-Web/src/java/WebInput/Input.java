package WebInput;
import Content.GamerRegister;
import javax.jws.WebService;
import InputAndResponses.Start;
import java.util.HashSet;
import InputAndResponses.CommandFolder.Commands;
import Content.LeaderboardRegister;

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
    @WebService
public class Input {
        
        public String name;
        public String help;
        public Start start;
        public Commands com;
        public String commands;
        public LeaderboardRegister leaderboard;
        
    public Input() {
        name = null;
        help = null;
       commands = null;
       start = new Start();
       com = new Commands();
       leaderboard = new LeaderboardRegister();
       
       
        
        
    }
 
    public String getLeaderboard() {
        return leaderboard.displayLeaderboard();
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
    

