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
//@WebService
public class GamerRegister extends Register{
    
    // HashMap for gamers
    public static final HashMap<String, Gamer> GAMERREGISTER = new HashMap<>();
    // Reader for input
    private final InputReader reader;
    //Stores the amount of successful matches of gamertags
    private static int gamerMatch;
    
    public GamerRegister() {
              // Initialize the needed elements and fill gamer map
              //GAMERREGISTER = new HashMap<>();
              reader = new InputReader();
              fillRegister();
    
            }

    /**
     * fills gamer array with arbitrary gamers for testing
     */
    @Override
    public final void fillRegister()
    {
        Gamer Scoopex;
        Scoopex = new Gamer("SCOOPEX", "Scoopex is the owner",
                "Platinum", 2500);
        Gamer Derpina;
                Derpina = new Gamer("DERPINA", "Derp derp",
              "Gold 2", 888);
        Gamer SirDerpALot;
        SirDerpALot = new Gamer("SIRDERPALOT", "Derp 4 teh lulz",
              "SR", 2900);
        GAMERREGISTER.put("SCOOPEX", Scoopex);
        GAMERREGISTER.put("DERPINA", Derpina);
        GAMERREGISTER.put("SIRDERPALOT", SirDerpALot);
    }
    
    /**
     *
     * @param words the expected parameter from Start method
     * Will result in success and gamer returned
     * Or If unsuccessful, return generic respond method
     * @return
     */
    //@WebMethod
    public Gamer findGamer(HashSet<String> words)
    {
        
        for(String word : words)
        {
          Gamer foundGamer = GAMERREGISTER.get(word);
          
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
     * @return gamer string with info
     */
    @Override
    public String getRegister() 
    {
        String gamers = ("The registered gamers in this system is:" + "<br>"
                + GAMERREGISTER.keySet()
                + "<br>" + "These are not case sensitive");
        return gamers;
    }
    
    /**
     * Prints the full gamerInfo of all gamers in register
     */
    public void fullGamerInfo() {
        System.out.println("The gamers in the system is: ");
        Map<String, Gamer> map = GAMERREGISTER;
        map.values().forEach((value) -> {
            System.out.println(value.getInfo());
        });
    }
    
    /**
     * Adds a gamer to the register
     * 
     * @param name is the name of the gamer object to be added
     * @param newGamer Is the object corresponding to the name to be added
     */
    public void addGamer(String name, Gamer newGamer)
    {
        GAMERREGISTER.put(name, newGamer);
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
     public void webCreateGamer(String name, String description, String newRank, int newRankPoints)
    {

                    String newname = name.toUpperCase();
                    Gamer newGamer = new Gamer(newname, description, 
                            newRank, newRankPoints);
                    addGamer(newname, newGamer); 
                    System.out.println("Gamer: > " + newname + " < was successfully"
                            + " added to the system");
    }
}
