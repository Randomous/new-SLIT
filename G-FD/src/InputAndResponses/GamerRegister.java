/*
 */
package InputAndResponses;

import java.util.HashMap;
import java.util.HashSet;

/**
 * GamerRegister contains the HashMap that stores all Gamer objects
 * Contains methods for searching a gamer and returning it if successfull
 * Also contains method for displaying all gamers regisrered
 * 
 * @author CastleDev / Tor Borgen
 * @version 1.09
 */
public class GamerRegister {
    // Creates the HashMap for gamers
    private final HashMap<String, Gamer> gamerRegister;
    // Initialize the responder for access
    private final Responder responder;
    //Stores the amount of successful matches of gamertags
    private static int gamerMatch;
    
    public GamerRegister()
            {
              gamerRegister = new HashMap<>();
              responder = new Responder();
              fillGamers();
    
            }

    /**
     * fills gamer array with arbitrary gamers for testing
     */
    public final void fillGamers()
    {
        Gamer Scoopex;
        Scoopex = new Gamer("SCOOPEX", "Scoopex is the ownder",
                "Platinum", 2500);
        Gamer Derpina;
                Derpina = new Gamer("DERPINA", "Derp derp",
              "Gold 2", 888);
        Gamer SirDerpALot;
        SirDerpALot = new Gamer("SIRDERPALOT", "Derp 4 teh lulz",
              "SR", 2900);
        gamerRegister.put("SCOOPEX", Scoopex);
        gamerRegister.put("DERPINA", Derpina);
        gamerRegister.put("SIRDERPALOT", SirDerpALot);
    }
    
    /**
     *
     * @param words the expected parameter from Start method
     * Will result in success and gamer returned
     * Or If unsuccessful, return generic respond method
     * @return
     */
    public String findGamer(HashSet<String> words)
    {
        
        for(String word : words)
        {
          Gamer foundGamer = gamerRegister.get(word);
          
          if (foundGamer != null) 
          {
            gamerMatch++;
            return foundGamer.printInfo();
          }
     
        }
        return responder.generateResponse();
    }
     
    /**
     * Just returns the number of searches that resulted in gamer returned
     * @return gamerMatch integer that counts the successful gamer lookups
     */
    public int gamertagsResolved()
    {
        return gamerMatch;
    }
    
    /**
     * Just prints out the gamers in the system.
     */
    public void displayGamers()
    {
        System.out.println("The registered gamers in this system is:\n" + gamerRegister.keySet());
        System.out.println("These are not case sensitive");
    }
    
    public void addGamer(String name, Gamer newGamer)
    {
        gamerRegister.put(name, newGamer);
    }
    
}
