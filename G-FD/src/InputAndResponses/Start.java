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
        
        printWelcome();
       
        
        
        while(!finished) 
        {
            HashSet<String> input = reader.getInput();
            CommandWords commands = command.getCommand(input);
            switch (commands)
            {
                case UNKNOWN :
                    Gamer gamerReg;
                    gamerReg = gamerRegister.findGamer(input);
                    if (gamerReg != null) {
                        System.out.println(gamerReg.getInfo());
                    }
                    else {
                    System.out.println(responder.generateResponse());
                    }
                    break;
                case COMMANDS :
                     command.displayCommands();
                    break;
                case GAMERS :
                    gamerRegister.displayGamers();
                    break;
                case RESOLVEDREPLIES :
                    System.out.println("There has been "
                            + "generated: " + responder.amountOfResponses() 
                            + " generic responses by the system");
                    break;
                case RESOLVEDGAMERS :
                    System.out.println("There has been sucessful searches for: "
                            + gamerRegister.gamertagsResolved() 
                            + " gamers found by the system");
                    break;
                case ADDGAMER :
                    gamerRegister.createNewGamer();
                    break;
                case LEADERBOARD :
                    leaderboard.displayLeaderboard();
                    break;
                case CONTENT :
                    //content.printAllContent();
                    content.fullContentPrint();
                    break;
                case SUPER :
                    content.superPrint();
                case HELP :
                    command.displayHelp();
                    break;

                case EXIT :
                    finished = true; 
                    break;
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
        System.out.println("#######Welcome to CastleDev's G-FD System#######");
        System.out.println("################################################");
        System.out.println("Please enter what you wish to do.");
        System.out.println("Enter a friends gamertag to get the stored info");
        command.displayHelp();
    }
    
        /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("Have a nice day, bye!");
    }
}

   
