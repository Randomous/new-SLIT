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
    // Creates the HashMap for gamertags
    private final HashMap<String, String> gamerRegister;
    //Creates the HashMap for commands
    private final HashMap<String, String> commandRegister;
    //Creates the random number generator
    private final Random randomGenerator;
    //Stores the amount of responses generated
    private static int totalResponses;
    //Stores the amount of successful matches of gamertags
    private static int gamerMatch;
    //Creates the ArrayList for answers
    private final ArrayList<String> gamerArray;
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
        gamerRegister = new HashMap<>();
        commandRegister = new HashMap<>();
        gamerArray = new ArrayList<>();
        questionArray = new ArrayList<>();
        randomGenerator = new Random();
        fillGamers();
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
        int respond = randomGenerator.nextInt(gamerArray.size());
        String result = gamerArray.get(respond);
        //System.out.println(result);
        totalResponses++;
        return result;
    }
        
    /**
     * Fills the gamerRegister HashMap
     * 
     */
    private void fillGamers()
    {
        // put your code here
        gamerRegister.put("SCOOPEX", "ScoopeX is the owner. \n" +
            "ScoopeX has a cool PC and is from Norway \n" +
            "ScoopeX is MLG");
        gamerRegister.put("KAFFERAST", "Kafferast is from sweden \n" +
            "He also understands norwegian");
        gamerRegister.put("DERPINA", "This is a girl from Derpland" +
            "She can derp and her, and then derp some more all day");
        gamerRegister.put("SIRDERPALOT", "This derper is the derpiest \n" +
            "He derps like no one else can do");
                
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
    public String findGamerDesc2(HashSet<String> words)
    {
        
        for(String word : words)
        {
          String foundGamer = gamerRegister.get(word);
          if (foundGamer != null) 
          {
            gamerMatch++;
            return foundGamer;
          }
     
        }
        return generateResponse();
    }
    /**
     * Fills the gamerArray with responses
     * 
     */
    private void fillGamerArray()
    {
        // put your code here
        gamerArray.add("Could not find that in the system");
        gamerArray.add("Sorry, does not compute");
        gamerArray.add("That sounds like a really cool, but i cannot find in the system");
        gamerArray.add("Hmm, can you specify");
        gamerArray.add("I do not think i can do that");
        gamerArray.add("Please me more specific");
        gamerArray.add("That could be done if you gave me more information");
        
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
                int randResp = randomGenerator.nextInt(gamerArray.size());
                String response = gamerArray.get(randResp);
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
     * Calls the printout of the amount of matches found
     * Shows how many successful matches of gamertags have been returned
     */
    
    public void gamertagsResolved()
    {
        System.out.println("There has been sucessful searches for: " + gamerMatch + " gamers found by the system");
    }
    
    /**
     * Prints the available gamertags
     */
    
    public void displayGamers()
    {
        System.out.println("The registered gamers in this system is:\n" + gamerRegister.keySet());
        System.out.println("These are not case sensitive");
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
    
