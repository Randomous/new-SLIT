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
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
public class Leaderboard extends Gamer{
    
    //Gamers placement in leaderboard
    private int placement;
    //Gamers previous placement for displaying climbs
    private final int previousPlacement;
    
    public Leaderboard(String gamerTag, String description, String rank, int rankPoints,
            int placement, int previousPlacement) {
        super(gamerTag, description, rank, rankPoints);
        this.placement = placement;
        this.previousPlacement = previousPlacement;
    }
    /*
    Gets the current placement of the gamer
    @return placement
    */
    public int getPlacement(){
        
        return placement;
    }
    
    /*
    Gets the previous placement of the gamer in order to visualise climb
    @return Previousplacement
    */
    public int getPreviousPlacement(){
        
        return previousPlacement;
    }
    
    /*
    Move the gamer up the leaderboard
    */
    public void placementUp() {
        placement ++;
    }
    
    /*
    Move the gamer down the leaderboard
    */
    public void placementDown() {
        if (placement > 0)  {
                placement --;
        }
    }
    
    /**
     *  Collects the information of super and subclass and merge them into string
     * @return leaderboardInfo in form of string
     */
    public String getInfo() {
        String leaderboardInfo = ("Gamer " + super.getGamertag() + 
                "\nHas the following rank: " + super.getRank() + " With: " + 
                super.getRankPoints() + " rankPoints\n" 
                + "Which puts him on number " + placement+ " in the leaderboard\n"
                + "His previous placement was at spot number: " + previousPlacement);
        return leaderboardInfo;
    }
    /**
     * Simple call to check that the super method of 
     * overridden getInfo can be called
     */
    public void checkSubSuper() {
        System.out.println(super.getInfo());
    }
}
