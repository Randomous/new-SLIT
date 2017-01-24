/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndResponses;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author adm-tor
 */
public class Commands {
    
        //Creates the HashMap for commands
    private final HashMap<String, CommandWords> commandRegister;
   
    public Commands() 
    {
        commandRegister = new HashMap<>();
        fillCommands();
    
    }
    
    private void fillCommands()
    {
        commandRegister.put("!EXIT",CommandWords.EXIT); 
        commandRegister.put("!GAMERS", CommandWords.GAMERS);
        commandRegister.put("!COMMANDS", CommandWords.COMMANDS);
        commandRegister.put("!RESOLVEDGAMERS", CommandWords.RESOLVEDGAMERS);
        commandRegister.put("!RESOLVEDREPLIES", CommandWords.RESOLVEDREPLIES);
        commandRegister.put("!HELP", CommandWords.HELP);
    }
    
    /**
     *
     * @param input
     * @return
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
     * Prints out the available commands and a corresponding description
     */
    
    public void displayCommands()
    {   System.out.println("The available commands are:");
        commandRegister.keySet().forEach((String display) -> {
            System.out.println(display);
        });
        System.out.println("These are not case sensitive");
    }
    
}
