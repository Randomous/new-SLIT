package WebInput;
import javax.jws.WebService;
import InputAndResponses.Start;


    @WebService
public class Input {
        public String welcome;
        public Start start;
        
public Input() {
        welcome = null;
        start = new Start();
    }
    
    //get help from method, returns string
    public String getHelp() {
        
        return welcome = start.GetWebWelcome();
    }
}
    

