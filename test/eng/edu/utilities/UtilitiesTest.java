/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.utilities;

<<<<<<< HEAD
import java.io.BufferedReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
=======
import org.junit.Test;
import static org.junit.Assert.*;
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514

/**
 *
 * @author poojithadharmavaram
 */
public class UtilitiesTest {
<<<<<<< HEAD
  
=======
   
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
    /**
     * Test of getNumberOfQuestions method, of class Utilities.
     */
    @Test
    public void testGetNumberOfQuestions() {
<<<<<<< HEAD
        System.out.println("getNumberOfQuestions");
=======
         System.out.println("getNumberOfQuestions");
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        //The number of questions currently is 2.
        int expResult = 2;
        int result = Utilities.getNumberOfQuestions();
        assertEquals(expResult, result);
<<<<<<< HEAD
=======

>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
    }

    /**
     * Test of getRandomQuestion method, of class Utilities.
     */
    @Test
    public void testGetRandomQuestion() {
        System.out.println("getRandomQuestion");
<<<<<<< HEAD
=======
        
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
        int n = 2; // n is the total number of questions.
        int result = Utilities.getRandomQuestion(n);
        
        boolean withinRange = false;
        
        //Checking if the random question number genereated is within the given range.
        
        if(result >= 1 && result <= n)
            withinRange = true;
        
        assertEquals(true,withinRange);
<<<<<<< HEAD
       
=======
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
    }

    /**
     * Test of fileExists method, of class Utilities.
     */
    @Test
    public void testFileExists() {
        System.out.println("fileExists");
<<<<<<< HEAD
        String filename = "/Users/deeptichavan/questions/q1/IdealizedModel1.png";
        Utilities instance = new Utilities();
        boolean expResult = true;
        boolean result = instance.fileExists(filename);
        assertEquals(expResult, result);

    }
    
    
    /**
     * Test of fileExists method, of class Utilities.
     * When the file isn't present
     */
    @Test
    public void testFileExistsFalse() {
        System.out.println("fileExists");
        String filename = "/Users/deeptichavan/questions/q1/IdealizedModel2.png";
        Utilities instance = new Utilities();
        boolean expResult = false;
        boolean result = instance.fileExists(filename);
        assertEquals(expResult, result);

    }
=======
        
        String filename = "/Users/poojithadharmavaram/questions/q1/IdealizedModel1.png";
        Utilities instance = new Utilities();
        boolean expResult = true;
        boolean result = instance.fileExists(filename);
        
        assertEquals(expResult, result);
    }
    
>>>>>>> 1da8881684ff6b1d156a99136a3661cca4d2d514
}
