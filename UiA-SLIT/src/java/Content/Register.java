/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Content;


/*
Full abstracted class Register serves methods for implementation to all 
registers in content package with common methods needed for testing and display.
*/
public abstract class Register {
    
    /*
    All methods are abstract despite not needed. This due to existing subclasses
    have different needs for both fill and get.
    Static methods are viable, but not needed as application is now since
    both will be overridden.
    Argument:> Interface is just as viable option here
   */
    abstract public void fillRegister();
    abstract public String getRegister();
    
    
    
}
