/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndResponses;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author adm-tor
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
     * fills gamer array with abrtitrary gamers for testing
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
     * @param words
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
     
    public void gamertagsResolved()
    {
        System.out.println("There has been sucessful searches for: " + gamerMatch + " gamers found by the system");
    }
    public void displayGamers()
    {
        System.out.println("The registered gamers in this system is:\n" + gamerRegister.keySet());
        System.out.println("These are not case sensitive");
    }
    
}
