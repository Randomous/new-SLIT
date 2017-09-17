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

package InputAndResponses;


import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Studentegister contains all maps and lists of the application.
 * It also holds the random generator.
 * There are methods for generating random response, searching for a firstname
 * and to initiate a random automatic "conversation"
 * StaticAutoConversation is iterator for fast iteration over question array.
 * Other methods can fill HashMap and ArrayLiasts manually.
 * Various methods are to be called from within interface text input
 * 
 * @author CastleDev / Tor Borgen
 * @version 1.09
 */
public class Responder{
    //Creates the random number generator
    private final Random randomGenerator;
    //Stores the amount of responses generated
    private static int totalResponses;
    //Creates the ArrayList for answers
    public ArrayList<String> answerArray;
    //Creates the ArrayList for questions
    private final ArrayList<String> questionArray;
    //Sets the maximum value for any instance of 100
    //This only applies to the autoconversations feature.
    private static final int ABSOLUTEMAX = 100;
    
    /**
     * Constructor for objects of class StudentRegister
     * Creates HashMap and ArrayList
     * Creates a random generator
     * And fills all Hash Maps and Arrays
     */
    public Responder(){
        // initialise needed elements
        answerArray = new ArrayList<>();
        questionArray = new ArrayList<>();
        randomGenerator = new Random();
        fillQuestionArray();
        fillStudentArray();
    }
    
    /**
     * Generate a random response.
     * @return   A string that could be displayed as the response
     */
    public String generateResponse(){
        int respond = randomGenerator.nextInt(answerArray.size());
        String result = answerArray.get(respond);
        //System.out.println(result);
        totalResponses++;
        return result;
    }
  
    /**
     * Fills the answerArray with responses
     * 
     */
    private void fillStudentArray(){
        // put your code here
        answerArray.add("Could not find that in the system");
        answerArray.add("Sorry, does not compute");
        answerArray.add("That sounds like a really cool, but i cannot find in the system");
        answerArray.add("Hmm, can you specify");
        answerArray.add("I do not think i can do that");
        answerArray.add("Please me more specific");
        answerArray.add("That could be done if you gave me more information");
        
    }
    
    /**
     * Fills the questionArray with questions
     * 
     */
    private void fillQuestionArray(){
        // put your code here
       questionArray.add("Can you find someone for me?");
       questionArray.add("I like to order a pizza");
       questionArray.add("Get me another application, you suck");
       questionArray.add("Why is this really happening?");
       questionArray.add("What is the meaning of life?");
       questionArray.add("Could you not?!");
        
    }
    
    
    /**
     * This method makes the application have an automatic random conversation
     * using the two arraylists available with responses and questions
     * There i a timer for 1 second delay between each interaction between the arrays
     * This is for an ilusion of a conversation
     * 
     * @param max Is the number of interactions of question and reply.
     * //@throws InterruptedException, sleep throws when another thread interrupts the current thread while sleep is active
     */
    public void autoConversation(int max){
       int interactions = 0;
        
       Iterator<String> autoiterator = questionArray.iterator();
        while (autoiterator.hasNext()&& interactions < max && max < ABSOLUTEMAX){
            try {
                int quest = randomGenerator.nextInt(questionArray.size());
                String ask = questionArray.get(quest);
                System.out.println(ask);
                Thread.sleep(1000);
                int randResp = randomGenerator.nextInt(answerArray.size());
                String response = answerArray.get(randResp);
                System.out.println(response);     
                Thread.sleep(1000);
                interactions++;
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /**
     * This method makes the application have an automatic random conversation
     * using the two arraylists available with responses and questions
     * This iterator is just for fast ilustration of iterating through 
     * the whole questionarray with coresponding random answers
     * 
     * 
     */
    public void staticAutoConversation() {
       int interactions = 0;
       //int max = 10;
       //String question;
        
       Iterator<String> autoiterator = questionArray.iterator();
        while (autoiterator.hasNext()){
           String question = autoiterator.next();
           System.out.println(question);
           generateResponse();
           interactions++;
        }
    }
    
    /**
     * Calls the printout of the amount of responses generated
     * In turn, this also tracks how many entries have been entered to the system
     * @return totalResponses generated by the system
     */
    
    public int amountOfResponses(){
        return totalResponses;
    }
    
    /**
     * Resets the totalResponses int
     */
    public void resetTotalResponses() {
        totalResponses = 0;
    }
}
    
