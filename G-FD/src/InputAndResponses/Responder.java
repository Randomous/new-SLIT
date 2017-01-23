package InputAndResponses;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;

/**
 * GameRegister contains all maps and lists of the application.
 * It also holds the random generator.
 * There are methods for generating random response, searching for a gamertag
 * and to initiate a random automatic "conversation"
 * StaticAutoConversation is iterator for fast iteration over question array.
 * Other methods can fill HashMap and ArrayLiasts manually.
 * Various methods are to be called from within interface text input
 * 
 * @author CastleDev / Tor Borgen
 * @version 1.6
 */
public class Responder
{
    //Creates the HashMap for commands
    private final HashMap<String, String> commandRegister;
    //Creates the random number generator
    private final Random randomGenerator;
    //Stores the amount of responses generated
    private static int totalResponses;
    //Creates the ArrayList for answers
    private final ArrayList<String> answerArray;
    //Creates the ArrayList for questions
    private final ArrayList<String> questionArray;
    //Sets the maximum value for any instance of 100
    //This only applies to the autoconversations feature.
    private static final int ABSOLUTEMAX = 100;
    
    /**
     * Constructor for objects of class GamerRegister
     * Creates HashMap and ArrayList
     * Creates a random generator
     * And fills all Hash Maps and Arrays
     */
    public Responder()
    {
        // initialise instance variables
        commandRegister = new HashMap<>();
        answerArray = new ArrayList<>();
        questionArray = new ArrayList<>();
        randomGenerator = new Random();
        fillCommands();
        fillQuestionArray();
        fillGamerArray();
    }
    
    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        int respond = randomGenerator.nextInt(answerArray.size());
        String result = answerArray.get(respond);
        //System.out.println(result);
        totalResponses++;
        return result;
    }
        
    
       /**
     * Fills the commandRegister HashMap
     * 
     */
    private void fillCommands()
    {
        // put your code here
        commandRegister.put("!EXIT", "Terminates the system");
        commandRegister.put("!GAMERS", "Displays the gamertags available");
        commandRegister.put("!COMMANDS", "Shows all available commands");
        commandRegister.put("!RESOLVEDGAMERS", "Displays the amount of gamers "
        + "successfully returned by the system");
        commandRegister.put("!RESOLVEDREPLIES", "Displays the amount of replies "
        + "returned by the system");
    }

       /**
     * Checks if text input contains a gamertag that is successfully returned
     * If not, it calls the generic response method
     * @param words are of words form input HashSet
     * @return foundGamer or generateResponse depending on input
     * 
     */
  
    /**
     * Fills the answerArray with responses
     * 
     */
    private void fillGamerArray()
    {
        // put your code here
        answerArray.add("Could not find that in the system");
        answerArray.add("Sorry, does not compute");
        answerArray.add("That sounds like a really cool, but i cannot find in the system");
        answerArray.add("Hmm, can you specify");
        answerArray.add("I do not think i can do that");
        answerArray.add("Please me more specific");
        answerArray.add("That could be done if you gave me more information");
        
    }
    
    /**
     * Fills the questionArray with questions
     * 
     */
    private void fillQuestionArray()
    {
        // put your code here
       questionArray.add("Can you find someone for me?");
       questionArray.add("I like to order a pizza");
       questionArray.add("Get me another application, you suck");
       questionArray.add("Why is this really happening?");
       questionArray.add("What is the meaning of life?");
       questionArray.add("Could you not?!");
        
    }
    
    
    /**
     * This method makes the application have an automatic random conversation
     * using the two arraylists available with responses and questions
     * There i a timer for 1 second delay between each interaction between the arrays
     * This is for an ilusion of a conversation
     * 
     * @param max Is the number of interactions of question and reply.
     * //@throws InterruptedException, sleep throws when another thread interrupts the current thread while sleep is active
     */
    public void autoConversation(int max)
    {
       int interactions = 0;
        
       Iterator<String> autoiterator = questionArray.iterator();
        while (autoiterator.hasNext()&& interactions < max && max < ABSOLUTEMAX)
        {
            try
            {
                int quest = randomGenerator.nextInt(questionArray.size());
                String ask = questionArray.get(quest);
                System.out.println(ask);
                Thread.sleep(1000);
                int randResp = randomGenerator.nextInt(answerArray.size());
                String response = answerArray.get(randResp);
                System.out.println(response);     
                Thread.sleep(1000);
                interactions++;
            }
            catch (InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
        }
    
    }
    
    /**
     * This method makes the application have an automatic random conversation
     * using the two arraylists available with responses and questions
     * This iterator is just for fast ilustration of iterating through 
     * the whole questionarray with coresponding random answers
     * 
     * 
     */
    public void staticAutoConversation()
    {
       int interactions = 0;
       //int max = 10;
       //String question;
        
       Iterator<String> autoiterator = questionArray.iterator();
        while (autoiterator.hasNext())
        {
           String question = autoiterator.next();
           System.out.println(question);
           generateResponse();
           interactions++;
        }
    
    }
    
    /**
     * Calls the printout of the amount of responses generated
     * In turn, this also tracks how many entries have been entered to the system
     */
    
    public void amountOfResponses()
    {
        System.out.println("There has been generated: " + totalResponses + " generic responses by the system");
    }
    
    /**
     * Prints out the available commands and a corresponding description
     */
    
    public void displayCommands()
    {      
        commandRegister.keySet().forEach((display) -> {
            System.out.println(display + " does: " + commandRegister.get(display));
        });
        System.out.println("These are not case sensitive");
    }
}
    
