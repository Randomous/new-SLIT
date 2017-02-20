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
package Content;


import InputAndResponses.InputReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * GamerRegister contains the HashMap that stores all Gamer objects
 * Contains methods for searching a gamer and returning it if successful
 * Also contains method for displaying all gamers registered
 * 
 * @author CastleDev / Tor Borgen
 * @version 1.09
 */
public class GamerRegister {
    // HashMap for gamers
    public final HashMap<String, Gamer> gamerRegister;
    // Reader for input
    private final InputReader reader;
    //Stores the amount of successful matches of gamertags
    private static int gamerMatch;
    
    public GamerRegister() {
              // Initialize the needed elements and fill gamer map
              gamerRegister = new HashMap<>();
              reader = new InputReader();
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
    public Gamer findGamer(HashSet<String> words)
    {
        
        for(String word : words)
        {
          Gamer foundGamer = gamerRegister.get(word);
          
          if (foundGamer != null) 
          {
            gamerMatch++;
            return foundGamer;
          }
     
        }
        return null;
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
     * Resets gamerMatch counter
     */
    public void gamerMatchReset() {
        gamerMatch = 0;
    }
    
    /**
     * Just prints out the gamers in the system.
     */
    public void displayGamers() 
    {
        System.out.println("The registered gamers in this system is:\n" + gamerRegister.keySet());
        System.out.println("These are not case sensitive");
    }
    
    public void fullGamerInfo() {
        System.out.println("The gamers in the system is: ");
        Map<String, Gamer> map = gamerRegister;
        map.values().forEach((value) -> {
            System.out.println(value.getInfo());
        });
    }
    
    public void addGamer(String name, Gamer newGamer)
    {
        gamerRegister.put(name, newGamer);
    }
    
    /**
     * Creates a new gamer object and adds it to the HashMap of gamers
     * Takes input from InputReader both string and integer readers
     */
    public void createNewGamer()
    {
        String newName;
                    String newDescription;
                    String newRank;
                    int newRankPoints;
                    
                    System.out.println("Please enter the gamer information\n" + 
                            "Enter the gamertag assosiated with the gamer");
                    newName = reader.getStringInput().toUpperCase();
                    System.out.println("Please enter the description you wish");
                    newDescription = reader.getStringInput();
                    System.out.println("Please enter the rank type");
                    newRank = reader.getStringInput();
                    System.out.println("Please enter the rankPoints");
                    newRankPoints = reader.getIntInput();
                    
                    Gamer newGamer = new Gamer(newName, newDescription, 
                            newRank, newRankPoints);
                    
                    addGamer(newName, newGamer);
                    
                    System.out.println("Gamer: > " + newName + " < was successfully"
                            + " added to the system");
    }
}
