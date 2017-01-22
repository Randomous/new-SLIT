
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndResponses;
import java.util.Scanner;
import java.util.HashSet;

/**
 * InputReader reads typed text input from the terminal. 
 * The text typed by a user is returned.
 * 
 * @author     CastleDev / Tor Borgen
 * @version    0.1
 */
public class InputReader
{
    private final Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }
    
    public HashSet<String> getInput()
    {
        System.out.print("> "); // print prompt
        String inputLine = reader.nextLine().trim().toUpperCase();
        String[] wordArray = inputLine.split(" ");
        // add words from array into hashset
        HashSet<String> words = new HashSet<>();
        for(String word : wordArray) {
        words.add(word);
        }
        return words;
    }
   
    
}
