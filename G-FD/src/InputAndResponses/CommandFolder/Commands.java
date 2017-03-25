/*
 * 
 */
package InputAndResponses.CommandFolder;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Commands contains the HashMap for commands as well as methods for retruning
 * returning them 
 * 
 * @author CastleDev / Tor Borgen
 * @version 1.09
 */
public class Commands {
    
        //Creates the HashMap for commands
    private final HashMap<String, CommandWords> commandRegister;
   
    public Commands() 
    {
        commandRegister = new HashMap<>();
        fillCommands();
    
    }
    
    /**
     * This fills the commandRegister with all commands 
    */
    private void fillCommands()
    {
        commandRegister.put("!EXIT",CommandWords.EXIT); 
        commandRegister.put("!GAMERS", CommandWords.GAMERS);
        commandRegister.put("!COMMANDS", CommandWords.COMMANDS);
        commandRegister.put("!RESOLVEDGAMERS", CommandWords.RESOLVEDGAMERS);
        commandRegister.put("!RESOLVEDREPLIES", CommandWords.RESOLVEDREPLIES);
        commandRegister.put("!HELP", CommandWords.HELP);
        commandRegister.put("!ADDGAMER", CommandWords.ADDGAMER);
        commandRegister.put("!LEADERBOARD", CommandWords.LEADERBOARD);
        commandRegister.put("!CONTENT", CommandWords.CONTENT);
        commandRegister.put("!SUPER", CommandWords.SUPER);
    }
    
    /**
     *
     * @param input expected input from user, searches for command and
     * @return Either found command or default unknown command
     */
    public CommandWords getCommand(HashSet<String> input)
    {
        CommandWords command;
        
        for (String commands : input)
        {
            command = commandRegister.get(commands);
        if (command != null)
        {
            return command;
        }
        }
        return CommandWords.UNKNOWN;
    }
      /**
     * Shows the available commands and a corresponding description
     */
    
    public void displayCommands()
    {   System.out.println("The available commands are:");
        commandRegister.keySet().forEach((String display) -> {
            System.out.println(display);
        });
        System.out.println("These are not case sensitive");
    }
    
    /**
     * Displays the help commands if they are registered in the system
     */
    public void displayHelp()
    {
        if (commandRegister.containsKey("!GAMERS"))
        {
        System.out.println("Type !gamers to see registered gamers in the system");
        }
        if (commandRegister.containsKey("!COMMANDS"))
        {
        System.out.println("Type !commands to list all available commands");
        }
        if (commandRegister.containsKey("!EXIT"))
        {
        System.out.println("Type !exit to exit the system.");
        }
        if (commandRegister.containsKey("!HELP"))
        {
        System.out.println("Type !help at any time to get help");
        }
    }
    
}
