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

import java.util.Scanner;
import java.util.HashSet;

/**
 * InputReader reads typed text input from the terminal. 
 * The text typed by a user is returned.
 */
public class InputReader{
    private final Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader(){
        reader = new Scanner(System.in);
    }
    
    /**
     *  Input method for searching strings for trigger words
     * @return words which is a HashSet of the phrase entered
     */
    public HashSet<String> getInput(){
        System.out.print("> "); // print prompt
        String inputLine;
        inputLine = reader.nextLine().trim().toUpperCase();
        String[] wordArray = inputLine.split(" ");
        // add words from array into hashset
        HashSet<String> words = new HashSet<>();
        for(String word : wordArray) {
        words.add(word);
        }
        return words;
    }
    
    /**
     * Basic String input
     * @return inputLine string with value
     */
    public String getStringInput(){
        System.out.print("> "); // print prompt
        String inputLine;
        inputLine = reader.nextLine().trim();
        return inputLine;
    }
    
    /**
     * Basic integer input
     * @return inputLine with integer value
     */
    public int getIntInput(){
        System.out.print("> "); // print prompt
        int inputLine;
        inputLine = reader.nextInt();
        return inputLine;
    }
}
