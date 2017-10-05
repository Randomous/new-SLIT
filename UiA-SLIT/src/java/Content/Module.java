/*
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


// Interface implementation not really needed, but showcased for specification
public class Module extends student implements InformationInterface{
    
    //M oduleNumber in module
    private int moduleNumber;
    // Points on a module
    private final int modulePoints;
    
    public Module(String firstname, String description, String mail, int studentID,
            int moduleNumber, int modulePoints) {
        super(firstname, description, mail, studentID);
        this.moduleNumber = moduleNumber;
        this.modulePoints = modulePoints;
    }
    /*
    Gets the current moduleNumber of the student
    @return moduleNumber
    */
    public int getPlacement(){
        
        return moduleNumber;
    }
    
    /*
    Gets the previous moduleNumber of the student in order to visualise climb
    @return Previousplacement
    */
    public int getPreviousPlacement(){
        
        return modulePoints;
    }
    
    /*
    Move the student up the module
    */
    public void placementUp() {
        moduleNumber ++;
    }
    
    /*
    Move the student down the module
    */
    public void placementDown() {
        if (moduleNumber > 0)  {
                moduleNumber --;
        }
    }
    
    /**
     *  Collects the information of super and subclass and merge them into string
     * @return moduleInfo in form of string
     */
    @Override
    public String getInfo() {
        String moduleInfo = ("Student " + super.getstudentfirstname() + " " + super.getsurname() + 
                "\ner registrert med: " + super.getMail() + " og har: " + 
                super.getStudentID() + " som studentid\n" 
                + "Sist godkjent modoul " + moduleNumber
                + " Med : " + modulePoints + " poeng");
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
