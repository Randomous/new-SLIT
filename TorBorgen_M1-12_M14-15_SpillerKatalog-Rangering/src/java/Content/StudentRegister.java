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


import InputAndResponses.InputReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * StudentRegister contains the HashMap that stores all student objects
 Contains methods for searching a student and returning it if successful
 Also contains method for displaying all students registered
 * 
 * @author CastleDev / Tor Borgen
 * @version 1.09
 */
public class StudentRegister extends Register{
    
    // HashMap for students
    public static final HashMap<String, student> STUDENTREGISTER = new HashMap<>();
    // Reader for input
    private final InputReader reader;
    //Stores the amount of successful matches of firstnames
    private static int studentMatch;
    
    public StudentRegister() {
              // Initialize the needed elements and fill student map
              //STUDENTREGISTER = new HashMap<>();
              reader = new InputReader();
              fillRegister();
    
            }

    /**
     * fills student array with arbitrary students for testing
     */
    @Override
    public final void fillRegister(){
        student Eirik;
        Eirik = new student("EIRIK", " Stålesen",
                "eirik@uia.no", 2002);
        student Helle;
        Helle = new student("HELLE", "Trygesla",
              "helle@uia.no", 2008);
        student Daniel;
        Daniel = new student("DANIEL", "Pettersen",
              "daniel@uia.no", 2004);
        STUDENTREGISTER.put("EIRIK", Eirik);
        STUDENTREGISTER.put("HELLE", Helle);
        STUDENTREGISTER.put("DANIEL", Daniel);
    }
    
    /**
     *
     * @param words the expected parameter from Start method
     * Will result in success and student returned
     * Or If unsuccessful, return generic respond method
     * @return
     */
    public student findStudent(HashSet<String> words){
        
        for(String word : words){
          student foundStudent = STUDENTREGISTER.get(word);
          
          if (foundStudent != null) {
            studentMatch++;
            return foundStudent;
          }
     
        }
        return null;
    }
     
    /**
     * Just returns the number of searches that resulted in student returned
     * @return studentMatch integer that counts the successful student lookups
     */
    public int firstnamesResolved(){
        return studentMatch;
    }
    
    /**
     * Resets studentMatch counter
     */
    public void studentMatchReset() {
        studentMatch = 0;
    }
    
    /**
     * Just prints out the students in the system.
     * @return student string with info
     */
    @Override
    public String getRegister() {
        String students = ("The registered students in this system is:" + "<br>"
                + STUDENTREGISTER.keySet()
                + "<br>" + "These are not case sensitive");
        return students;
    }
    
    /**
     * Prints the full studentInfo of all students in register
     */
    public void fullStudentInfo() {
        System.out.println("The students in the system is: ");
        Map<String, student> map = STUDENTREGISTER;
        map.values().forEach((value) -> {
            System.out.println(value.getInfo());
        });
    }
    
    /**
     * Adds a student to the register
     * 
     * @param name is the name of the student object to be added
     * @param newStudent Is the object corresponding to the name to be added
     */
    public void addStudent(String name, student newStudent){
        STUDENTREGISTER.put(name, newStudent);
    }
    
    /**
     * Creates a new student object and adds it to the HashMap of students
     * Takes input from InputReader both string and integer readers
     */
    public void createNewStudent(){
        String newName;
                    String newSurname;
                    String newMail;
                    int newStudentID;
                    
                    System.out.println("Please enter the student information\n" + 
                            "Enter the firstname assosiated with the student");
                    newName = reader.getStringInput().toUpperCase();
                    System.out.println("Please enter the description you wish");
                    newSurname = reader.getStringInput();
                    System.out.println("Please enter the mail type");
                    newMail = reader.getStringInput();
                    System.out.println("Please enter the studentID");
                    newStudentID = reader.getIntInput();
                    
                    student newStudent = new student(newName, newSurname, 
                            newMail, newStudentID);
                    
                    addStudent(newName, newStudent);
                    
                    System.out.println("Student: > " + newName + " < was successfully"
                            + " added to the system");
    }
     public void webCreateStudent(String name, String description, String newMail, int newStudentID){

                    String newname = name.toUpperCase();
                    student newStudent = new student(newname, description, 
                            newMail, newStudentID);
                    addStudent(newname, newStudent); 
                    System.out.println("Student: > " + newname + " < was successfully"
                            + " added to the system");
    }
}
