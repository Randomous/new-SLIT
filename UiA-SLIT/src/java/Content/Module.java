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

// Interface implementation not really needed, but showcased for specification
public class Module extends student implements InformationInterface{
    
    //Students placement in module
    private int placement;
    //Students previous placement for displaying climbs
    private final int previousPlacement;
    
    public Module(String firstname, String description, String mail, int studentID,
            int placement, int previousPlacement) {
        super(firstname, description, mail, studentID);
        this.placement = placement;
        this.previousPlacement = previousPlacement;
    }
    /*
    Gets the current placement of the student
    @return placement
    */
    public int getPlacement(){
        
        return placement;
    }
    
    /*
    Gets the previous placement of the student in order to visualise climb
    @return Previousplacement
    */
    public int getPreviousPlacement(){
        
        return previousPlacement;
    }
    
    /*
    Move the student up the module
    */
    public void placementUp() {
        placement ++;
    }
    
    /*
    Move the student down the module
    */
    public void placementDown() {
        if (placement > 0)  {
                placement --;
        }
    }
    
    /**
     *  Collects the information of super and subclass and merge them into string
     * @return moduleInfo in form of string
     */
    @Override
    public String getInfo() {
        String moduleInfo = ("Student " + super.getstudentfirstname() + 
                "\nHas the following mail: " + super.getMail() + " With: " + 
                super.getStudentID() + " studentID\n" 
                + "Which puts him on number " + placement+ " in the module\n"
                + "His previous placement was at spot number: " + previousPlacement);
        return moduleInfo;
    }
    
    /**
     * Simple call to check that the super method of 
     * overridden getInfo can be called
     */
    public void checkSubSuper() {
        System.out.println(super.getInfo());
    }
}
