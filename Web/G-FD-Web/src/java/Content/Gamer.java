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


/**
 * This class is the gamer object class. Contains all information for a gamer
 * As well as methods for returning information about the gamer
 * @author CastleDev / Tor Borgen
 * @version 1.09
 */
public class Gamer {
  
    // the "name" or gamertag 
    private final String gamerTag;
    @SuppressWarnings("FieldMayBeFinal")
    // the description of the gamer
    private String description;
    @SuppressWarnings("FieldMayBeFinal")
    // the rank of the gamer
    private String rank;
    @SuppressWarnings("FieldMayBeFinal")
    // the rankpoints of the gamer
    private int rankPoints;
    
    /**
     * Creates a gamer object, information stored in this object is:
     * @param gamerTag Is the name which the system will search.
     * @param description Is the description you wish to store for this gamer
     * @param rank Is the stored type of rank
     * @param rankPoints If applicable, is the rank points
     */
    public Gamer(String gamerTag, String description, String rank, int rankPoints) {
    
    this.gamerTag = gamerTag.toUpperCase();
    this.description = description;
    this.rank = rank;
    this.rankPoints = rankPoints;
    }
    
    /**
     * Get the full information about the gamer object
     * @return gamerInfo in form of string
     * 
     */
    public String getInfo()
    {
        String gamerInfo = ("GamerTag " + gamerTag + 
                " is registered in the system \n" + "With the following rank: " 
                + rank + " With: " + rankPoints + " rankPoints\n" 
                + "And the following description: " + description);
        return gamerInfo;
    }
    
    /**
     * Get the gamerTag from field of object
     * @return gamerTag
     */
    public String getGamertag() {
        return gamerTag;
    }
    
    /**
     * get the description from field of object
     * @return description
     */
    public String getDiscription() {
        return description;
    }
    
    /**
     * get the rank from field of object
     * @return rank
     */
    public String getRank() {
        return rank;
    }
    
    /**
     * get the rankPoints from field of object
     * @return rankPoints
     */
    public int getRankPoints() {
        return rankPoints;
    }
}
