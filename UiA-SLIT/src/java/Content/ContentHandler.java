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

import java.util.ArrayList;

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
public class ContentHandler {
    
    // access to the StudentRegister
    private StudentRegister studentReg;
    // access to the moduleRegister
    private ModuleRegister module;
    // Arraylist to contain all objects of both registers
    private ArrayList<student> contentList;
    
    public ContentHandler() {
        studentReg = new StudentRegister();
        module = new ModuleRegister();
        contentList = new ArrayList();
        fillContent();
    }
    
    /**
     * Fills the array with content from all registers
     */
    public void fillContent() {
        module.moduleRegister.values().forEach((student) -> {
            contentList.add(student);
            //System.out.println("");
        });
        studentReg.STUDENTREGISTER.values().forEach((student) -> {
            contentList.add(student);
        });
    }
    
    /**
     * Manually print the hashMaps of both maps
     */
    public void printAllContentPrimitive() {
        studentReg.fullStudentInfo();
        module.getRegister();
    }
    
    /**
     * Full printout of both lists using the information method of objects
     */
    public String fullContentPrint() {
        int size = 0;
        StringBuilder content = new StringBuilder();
        //System.out.println(size);
        while (size < contentList.size()) {
            student student = contentList.get(size);
            
            content.append(student.getInfo() + "<br> + <br>");
        size ++;
        //System.out.println("");
        //System.out.println(size);
        }
        return content.toString();
    }
    
    /**
     * Just a simple test to ensure that the super method of subclass can be called
     */
    public void superPrint() {

        Module leader = module.moduleRegister.get("EIRIK");
        leader.checkSubSuper();
    }
}
