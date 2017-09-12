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

import Content.StudentRegister;
import Content.student;
import Content.ModuleRegister;
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
    //private final InputReader reader;
    
    // Responder with maps, arrays and randomiser
    private final Responder responder;
    // studentRegister with studentmap
    private final StudentRegister studentRegister;
    // moduleregister with module content
    private final ModuleRegister module;
    // ContentHandler with full content list
    private final ContentHandler content;
    // enum commands
    private final Commands command;
    public String returnedStudent;
    

    /**
     * Constructor for objects of class Start
     */
    public Start()
    {
       // Initialize objects needed and start application method
       //reader = new InputReader();
       responder = new Responder();
       studentRegister = new StudentRegister();
       module = new ModuleRegister();
       command = new Commands();
       content = new ContentHandler();
       
    }
    

    /**
     * start initiates the inputReader for terminal input
     * "!EXIT" ends the application
     * Recognized input matching either enum command words returns string
     * Valid student in system from input returns string of map object
     * Anything else returns generic random string from responder
     * HashMap containing firstname values.
     */
    public String start(HashSet<String> input)
    {
        boolean finished = false;
        
        GetWebWelcome();
       
        
        while(!finished) 
        {
            
            CommandWords commands = command.getCommand(input);
            // Switch over enums from input parameter
            switch (commands)
            {
                //Default switch if no hit on commands, either find student or
                // generic general response
                case UNKNOWN :
                    student studentReg;
                    studentReg = studentRegister.findStudent(input);
                    if (studentReg != null) {
                        returnedStudent = studentReg.getInfo();
                        return studentReg.getInfo();
                    }
                    else {
                    return responder.generateResponse();
                    }
                    
                case COMMANDS :
                     return command.displayCommands();
                   // break;
                case STUDENTS :
                    return studentRegister.getRegister();
                    //break;
                case RESOLVEDREPLIES :
                    String replies = ("There has been "
                            + "generated: " + responder.amountOfResponses() 
                            + " generic responses by the system");
                    return replies;
                    //break;
                case RESOLVEDSTUDENTS :
                    String resolvedStudents = ("There has been sucessful searches for: "
                            + studentRegister.firstnamesResolved() 
                            + " students found by the system");
                    return resolvedStudents;
                    //break;
                case ADDSTUDENT :
                    studentRegister.createNewStudent();
                    break;
                case MODULE :
                    return module.getRegister();
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
        
        return GetGoodbye();
    }
    
       /**
     * Print the welcome message and instructions
     */
    public String GetWebWelcome()
    {   //String help = command.displayHelp();
        StringBuilder ret = new StringBuilder();
        ret.append("<center>################################################<br>" +
        "#######Welcome to CastleDev's G-FD System##########<br>" +
        "################################################<br>" +
        "Please enter what you wish to do.<br>" +
        "Enter a friends firstname to get the stored info<br></center>");
        return ret.toString();
    }
     public String GetWelcome()
    {   //String help = command.displayHelp();
        //StringBuilder ret = new StringBuilder();
        String ret = ("Welcome to CastleDev's G-FD System." +
        " Please enter what you wish to do." +
        " Enter a friends firstname to get the stored info");
        return ret;
    }
    
        /**
     * Print a good-bye message to the screen.
     */
    private String GetGoodbye()
    {
        return "Have a nice day, bye!";
    }
}

   
