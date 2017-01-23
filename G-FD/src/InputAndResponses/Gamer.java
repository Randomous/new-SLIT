/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndResponses;


/**
 *
 * @author adm-tor
 */
public class Gamer {
  
    
    private final String gamerTag;
    @SuppressWarnings("FieldMayBeFinal")
    private String description;
    @SuppressWarnings("FieldMayBeFinal")
    private String rank;
    private final int rankPoints;
    
    public Gamer(String gamerTag, String description, String rank, int rankPoints) {
    
    this.gamerTag = gamerTag;
    this.description = description;
    this.rank = rank;
    this.rankPoints = rankPoints;
    }
    
    public String printInfo()
    {
        String gamerInfo = ("GamerTag " + gamerTag + 
                " is registered in the system \n" + "With the following rank: " 
                + rank + " With: " + rankPoints + " rankPoints\n" 
                + "And the following description: " + description);
        return gamerInfo;
    }
}
