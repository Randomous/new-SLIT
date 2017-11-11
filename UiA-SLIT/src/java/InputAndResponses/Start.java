/*
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

import java.util.HashSet;

/**
 * The Interface initiates the application with the constructor
 * It initiates the InputReader and responder
 * Thereafter it can be started with the start method
 * It takes input from the terminal in form of text.
 * All commands and instructions appear when start method is called
 * 
 */
public class Start
{
    // InputReader for terminal input
    //private final InputReader reader;
    
    // Responder with maps, arrays and randomiser
    //private final ContentHandler content;
    // enum commands
    

    /**
     * Constructor for objects of class Start
     */
    public Start()
    {
       // Initialize objects needed and start application method
       //reader = new InputReader();
       //content = new ContentHandler();
       
    }
    

    /**
     * start initiates the inputReader for terminal input
     * "!EXIT" ends the application
     * Recognized input matching either enum command words returns string
     * Valid student in system from input returns string of map object
     * Anything else returns generic random string from responder
     * HashMap containing firstname values.
     * @param input
     * @return 
     */
    public String start(HashSet<String> input)
    {
        boolean finished = false;
        
        GetWebWelcome();    
        return null;
    }
    
       /**
     * Print the welcome message and instructions
     * @return 
     */
    public String GetWebWelcome()
    {   //String help = command.displayHelp();
        StringBuilder ret = new StringBuilder();
        ret.append("<center> UiA-SLIT <br>" +
        "Skriv inn navn på student du ønsker å søke på.<br>" +
        "Eller velg funksjon<br></center>");
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
}

   
