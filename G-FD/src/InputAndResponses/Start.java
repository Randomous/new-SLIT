package InputAndResponses;

import java.util.HashSet;
/**
 * The Interface initiates the application with the constructor
 * It initiates the InputReader and responder
 * Thereafter it can be started with the start method
 * It takes input from the terminal in form of text.
 * All commands and instructions appear when start method is called
 * 
 * @author CastleDev / Tor Borgen 
 * @version 1.4
 */
public class Start
{
    // initiates the inputReader for terminal input
    private final InputReader reader;
    // initiates the responder with maps, arrays and randomiser
    private final Responder responder;

    /**
     * Constructor for objects of class Interface
     */
    public Start()
    {
        // initialise instance variables
       reader = new InputReader();
       responder = new Responder();
       start();
    }

    /**
     * start initiates the inputReader for terminal input
     * "!EXIT" ends the application
     * Anything else generates either a random respondernse or a match in responder
     * HashMap containing gamertag values.
     */
    private void start()
    {
        boolean finished = false;
        
        printWelcome();
        
        while(!finished) 
        {
            HashSet<String> input = reader.getInput();
                        
            if(input.contains("!EXIT"))
            {
                finished = true;
            }
            
            else if(input.contains("!COMMANDS")){
                responder.displayCommands();
            }
                
            else if (input.contains("!GAMERS"))
            {
                responder.displayGamers();
            }
            
            else if(input.contains("!RESOLVEDREPLIES"))
            {
                responder.amountOfResponses();
            }
            
            else if(input.contains("!RESOLVEDGAMERS"))
            {
                responder.gamertagsResolved();
            }
            else if (input.contains("FUCK"))
            {
                System.out.println("Don't swear m8");
            }
            
            else 
            {
                String gamerReg = responder.findGamer(input);
                System.out.println(gamerReg);   
            }
        }
        
        printGoodbye();
    }
    
       /**
     * Print the welcome message and instructions
     */
    private void printWelcome()
    {
        System.out.println("################################################");
        System.out.println("Welcome to CastleDev's GamerLookup interface.");
        System.out.println("################################################");
        System.out.println("Please enter what you wish to do.");
        System.out.println("Enter a friends name to get the stores info");
        responder.displayGamers();
        responder.displayCommands();
        System.out.println("At any time type !gamers or !commands to list available input");
        System.out.println("Please type '!exit' to exit the system.");
    }
    
        /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("Have a nice day, bye!");
    }
}
