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
 * This class is the student object class. Contains all information for a student
 * As well as methods for returning information about the student
 * @author CastleDev / Tor Borgen
 * @version 1.09
 */
public class student implements InformationInterface{
  
    // the "name" or firstname 
    private final String firstname;
    @SuppressWarnings("FieldMayBeFinal")
    // the surename of the student
    private String surename;
    @SuppressWarnings("FieldMayBeFinal")
    // the mail of the student
    private String Mail;
    @SuppressWarnings("FieldMayBeFinal")
    // the studentid of the student
    private int studentID;
    
    /**
     * Creates a student object, information stored in this object is:
     * @param firstname Is the name which the system will search.
     * @param surename Is the surename you wish to store for this student
     * @param mail Is the stored type of mail.
     * @param studentID If applicable, is the mail points.
     */
    public student(String firstname, String surename, String mail, int studentID) {
    
    this.firstname = firstname.toUpperCase();
    this.surename = surename;
    this.Mail = mail;
    this.studentID = studentID;
    }
    
    /**
     * Get the full information about the student object
     * @return studentInfo in form of string
     * 
     */
    @Override
    public String getInfo()
    {
        String studentInfo = ("studentens navn " + firstname + surename +
                " er registrert i systemet \n" + "med følgende studentID: " 
                + studentID + "\n studentensmail " + Mail);  
                
        return studentInfo;
    }
    
    /**
     * Get the firstname from field of object
     * @return firstname
     */
    public String getstudentfirstname() {
        return firstname;
    }
    
    /**
     * get the surename from field of object
     * @return surename
     */
    @Override
    public String getsurname() {
        return surename;
    }
    
    /**
     * get the mail from field of object
     * @return mail
     */
    public String getMail() {
        return Mail;
    }
    
    /**
     * get the studentID from field of object
     * @return studentID
     */
    public int getStudentID() {
        return studentID;
    }
}
