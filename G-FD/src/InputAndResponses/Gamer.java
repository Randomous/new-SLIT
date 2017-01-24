/*

 */
package InputAndResponses;


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
    
    public String printInfo()
    {
        String gamerInfo = ("GamerTag " + gamerTag + 
                " is registered in the system \n" + "With the following rank: " 
                + rank + " With: " + rankPoints + " rankPoints\n" 
                + "And the following description: " + description);
        return gamerInfo;
    }
}
