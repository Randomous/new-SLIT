package InputAndResponses;

import java.util.HashSet;
import java.util.Scanner;
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
    private final GamerRegister gamerRegister;

    /**
     * Constructor for objects of class Interface
     */
    public Start()
    {
        // initialise instance variables
       reader = new InputReader();
       responder = new Responder();
       gamerRegister = new GamerRegister();
       start();
    }
    

    /**
     * start initiates the inputReader for terminal input
     * "!EXIT" ends the application
     * Anything else generates either a random response or a match in responder
     * HashMap containing gamertag values.
     */
    private void start()
    {
        boolean finished = false;
        
        //printWelcome();
        System.out.println("################################################");
        System.out.println("#######Welcome to CastleDev's G-FD System#######");
        System.out.println("################################################");
        System.out.println("Please enter what you wish to do.");
        System.out.println("Enter a friends gamertag to get the stored info");
        gamerRegister.displayGamers();
        responder.displayCommands();
        help();
        
        
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
                gamerRegister.displayGamers();
            }
            
            else if(input.contains("!RESOLVEDREPLIES"))
            {
                responder.amountOfResponses();
            }
            
            else if(input.contains("!RESOLVEDGAMERS"))
            {
                gamerRegister.gamertagsResolved();
            }
            else if (input.contains("!HELP"))
            {
                help();
            }
            
            else 
            {
                String gamerReg = gamerRegister.findGamer(input);
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
       
    }
    
        /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("Have a nice day, bye!");
    }
    
    private void help()
    {
        System.out.println("Type !gamers or !commands to list available input");
        System.out.println("Type '!exit' to exit the system.");
        System.out.println("Type '!help' at any time to get help");
    }
}
