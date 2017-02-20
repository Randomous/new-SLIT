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

import java.util.ArrayList;

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
public class ContentHandler {
    
    private GamerRegister gamerReg;
    private LeaderboardRegister leaderboard;
    private ArrayList<Gamer> contentList;
    
    public ContentHandler() {
        gamerReg = new GamerRegister();
        leaderboard = new LeaderboardRegister();
        contentList = new ArrayList();
        fillContent();
    }
    
    public void fillContent() {
        leaderboard.leaderboardRegister.values().forEach((gamer) -> {
            contentList.add(gamer);
            //System.out.println("");
        });
        gamerReg.gamerRegister.values().forEach((gamer) -> {
            contentList.add(gamer);
        });
    }
    
    public void printAllContentPrimitive() {
        gamerReg.fullGamerInfo();
        leaderboard.displayLeaderboard();
    }
    
    public void fullContentPrint() {
        int size = 0;
        //System.out.println(size);
        while (size < contentList.size()) {
            Gamer gamer = contentList.get(size);
        System.out.println(gamer.getInfo());
        size ++;
        System.out.println("");
        //System.out.println(size);
        }
    }
    
}
