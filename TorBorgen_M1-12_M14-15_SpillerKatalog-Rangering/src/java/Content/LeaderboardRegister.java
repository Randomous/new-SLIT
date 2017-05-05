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


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
public class LeaderboardRegister extends Register {
    
    // HashMap for Leaderboard
    public final HashMap<String, Leaderboard> leaderboardRegister;
    // GAMERREGISTER for access to gamers
    public GamerRegister gamerReg;
    
    public LeaderboardRegister() {
        leaderboardRegister = new HashMap<>();
        gamerReg = new GamerRegister();
        fillRegister();
    }
    /**
     * Fills the leaderboard with gamers from the GAMERREGISTER
    */
    @Override
    public void fillRegister(){
         int rankPlacer = 1;
        int previRank = 0;
        /**Map map = gamerRegister;
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
        **/
        for (Gamer gamer : gamerReg.GAMERREGISTER.values()){
           Leaderboard leaderboard = new Leaderboard(gamer.getGamertag(),
                   gamer.getDiscription(), gamer.getRank(), gamer.getRankPoints(),
                   rankPlacer, previRank);
           leaderboardRegister.put(gamer.getGamertag(), leaderboard);
           //System.out.println(leaderboard.getInfo());
           rankPlacer ++;
           previRank ++;
        }
    }
    /**
     * Prints the leaderboard
     * @return complete leaderboard as string
     */
    @Override
     public String getRegister() {
        StringBuilder leaderboard = new StringBuilder();
        leaderboard.append("The Leaderboard is as standing:");
        Map<String, Leaderboard> map = leaderboardRegister;
        map.values().forEach((value) -> {
            leaderboard.append("<br>" + value.getInfo());
        });
        return leaderboard.toString();
    }
}
