/*
 * Copyright 2017 Tor Borgen <Tor Borgen at CastleDev>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package InputAndResponses;

import Content.GamerRegister;
import Content.Gamer;
import Content.LeaderboardRegister;
import Content.ContentHandler;
import InputAndResponses.CommandFolder.Commands;
import InputAndResponses.CommandFolder.CommandWords;
import java.util.HashSet;
import java.util.ListIterator;

/**
 * The Interface initiates the application with the constructor
 * It initiates the InputReader and responder
 * Thereafter it can be started with the start method
 * It takes input from the terminal in form of text.
 * All commands and instructions appear when start method is called
 * 
 * @author CastleDev / Tor Borgen
 * @version 1.09
 */
public class Start
{
    // InputReader for terminal input
    private final InputReader reader;
    // Responder with maps, arrays and randomiser
    private final Responder responder;
    // gamerRegister with gamermap
    private final GamerRegister gamerRegister;
    // leaderboardregister with leaderboard content
    private final LeaderboardRegister leaderboard;
    // ContentHandler with full content list
    private final ContentHandler content;
    // enum commands
    private final Commands command;
    public String returnedGamer;
    

    /**
     * Constructor for objects of class Start
     */
    public Start()
    {
       // Initialize objects needed and start application method
       reader = new InputReader();
       responder = new Responder();
       gamerRegister = new GamerRegister();
       leaderboard = new LeaderboardRegister();
       command = new Commands();
       content = new ContentHandler();
       
    }
    

    /**
     * start initiates the inputReader for terminal input
     * "!EXIT" ends the application
     * Anything else generates either a random response or a match in responder
     * HashMap containing gamertag values.
     */
    public String start(HashSet<String> input)
    {
        boolean finished = false;
        
        printWelcomeHTML();
       
        
        while(!finished) 
        {
            
            CommandWords commands = command.getCommand(input);
            switch (commands)
            {
                case UNKNOWN :
                    Gamer gamerReg;
                    gamerReg = gamerRegister.findGamer(input);
                    if (gamerReg != null) {
                        returnedGamer = gamerReg.getInfo();
                        return gamerReg.getInfo();
                    }
                    else {
                    return responder.generateResponse();
                    }
                    
                case COMMANDS :
                     return command.displayCommands();
                   // break;
                case GAMERS :
                    return gamerRegister.getRegister();
                    //break;
                case RESOLVEDREPLIES :
                    String replies = ("There has been "
                            + "generated: " + responder.amountOfResponses() 
                            + " generic responses by the system");
                    return replies;
                    //break;
                case RESOLVEDGAMERS :
                    String resolvedGamers = ("There has been sucessful searches for: "
                            + gamerRegister.gamertagsResolved() 
                            + " gamers found by the system");
                    return resolvedGamers;
                    //break;
                case ADDGAMER :
                    gamerRegister.createNewGamer();
                    break;
                case LEADERBOARD :
                    return leaderboard.getRegister();
                    //break;
                case CONTENT :
                    //content.printAllContent();
                    return content.fullContentPrint();
                    //break;
                case SUPER :
                    content.superPrint();
                case HELP :
                    return command.displayHelp();
                    //break;

                case EXIT :
                    finished = true; 
                    break;
            }
        }
        
        return printGoodbye();
    }
    
       /**
     * Print the welcome message and instructions
     */
    public String printWelcomeHTML()
    {   //String help = command.displayHelp();
        StringBuilder ret = new StringBuilder();
        ret.append("<center>################################################<br>" +
        "#######Welcome to CastleDev's G-FD System##########<br>" +
        "################################################<br>" +
        "Please enter what you wish to do.<br>" +
        "Enter a friends gamertag to get the stored info<br></center>");
        return ret.toString();
    }
     public String printWelcome()
    {   //String help = command.displayHelp();
        //StringBuilder ret = new StringBuilder();
        String ret = ("Welcome to CastleDev's G-FD System." +
        " Please enter what you wish to do." +
        " Enter a friends gamertag to get the stored info");
        return ret;
    }
    
        /**
     * Print a good-bye message to the screen.
     */
    private String printGoodbye()
    {
        return "Have a nice day, bye!";
    }
}

   
