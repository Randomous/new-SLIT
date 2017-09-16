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


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tor Borgen <Tor Borgen at CastleDev>
 */
public class ModuleRegister extends Register {
    
    // HashMap for Module
    public final HashMap<String, Module> moduleRegister;
    // STUDENTREGISTER for access to students
    public StudentRegister studentReg;
    
    public ModuleRegister() {
        moduleRegister = new HashMap<>();
        studentReg = new StudentRegister();
        fillRegister();
    }
    /**
     * Fills the module with students from the STUDENTREGISTER
    */
    @Override
    public void fillRegister(){
         int mailPlacer = 1;
        int previMail = 0;
        /**Map map = studentRegister;
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
        **/
        for (student student : studentReg.STUDENTREGISTER.values()){
           Module module = new Module(student.getstudentfirstname(),
                   student.getsurname(), student.getMail(), student.getStudentID(),
                   mailPlacer, previMail);
           moduleRegister.put(student.getstudentfirstname(), module);
           //System.out.println(module.getInfo());
           mailPlacer ++;
           previMail ++;
        }
    }
    /**
     * Prints the module
     * @return complete module as string
     */
    @Override
     public String getRegister() {
        StringBuilder module = new StringBuilder();
        module.append("Siste godkjente moduler er:");
        Map<String, Module> map = moduleRegister;
        map.values().forEach((value) -> {
            module.append("<br>" + value.getInfo());
        });
        return module.toString();
    }
}
