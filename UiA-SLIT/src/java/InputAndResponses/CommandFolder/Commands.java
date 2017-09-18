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
 */
public class Commands {
    
        //Creates the HashMap for commands
    private final HashMap<String, CommandWords> commandRegister;
   
    public Commands() {
        commandRegister = new HashMap<>();
        fillCommands();
    
    }
    
    /**
     * This fills the commandRegister with all commands 
    */
    private void fillCommands(){
        commandRegister.put("!EXIT",CommandWords.EXIT); 
        commandRegister.put("!STUDENTS", CommandWords.STUDENTS);
        commandRegister.put("!COMMANDS", CommandWords.COMMANDS);
        commandRegister.put("!RESOLVEDSTUDENTS", CommandWords.RESOLVEDSTUDENTS);
        commandRegister.put("!RESOLVEDREPLIES", CommandWords.RESOLVEDREPLIES);
        commandRegister.put("!HELP", CommandWords.HELP);
        commandRegister.put("!ADDSTUDENT", CommandWords.ADDSTUDENT);
        commandRegister.put("!MODULE", CommandWords.MODULE);
        commandRegister.put("!CONTENT", CommandWords.CONTENT);
        commandRegister.put("!SUPER", CommandWords.SUPER);
    }
    
    /**
     *
     * @param input expected input from user, searches for command and
     * @return Either found command or default unknown command
     */
    public CommandWords getCommand(HashSet<String> input){
        CommandWords command;
        
        for (String commands : input){
            command = commandRegister.get(commands);
        if (command != null){
            return command;
            }
        }
        return CommandWords.UNKNOWN;
    }
      /**
     * Shows the available commands and a corresponding description
     */
    
    public String displayCommands(){
        StringBuilder command = new StringBuilder();
        command.append("The available commands are:" + "<br>");
        commandRegister.keySet().forEach((String display) -> {
            command.append(display + "<br>");
        });
        command.append("These are not case sensitive");
        return command.toString();
    }
    
    /**
     * Displays the help commands if they are registered in the system
     */
    public String displayHelp(){
        StringBuilder help = new StringBuilder();
        if (commandRegister.containsKey("!STUDENTS")){
        help.append("Type !students to see registered students in the system" + "<br>");
        }
        if (commandRegister.containsKey("!COMMANDS")){
        help.append("Type !commands to list all available commands" + "<br>");
        }
        if (commandRegister.containsKey("!EXIT")){
        help.append("Type !exit to exit the system." + "<br>");
        }
        if (commandRegister.containsKey("!HELP")){
        help.append("Type !help at any time to get help" + "<br>");
        }
        String helpString = help.toString();
        return helpString;
    }
    
}
