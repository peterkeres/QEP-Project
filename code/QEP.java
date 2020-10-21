package code;
/**
 * This is the tester for the QEP project, it will use the student calss and guard class to do the following
 * take input from the user of guard name, id, and password and check vs data base
 * take input from the user for a student name, id, and if they are carrying. and check that vs data base
 * then take the student info gathered and out put it to a file to be sent to a "dispatcher"
 * do a print out of the current information 
 * 
 * THIS IS ONLY A PROF OF CONCEPT, ONLY HANDLES ONE STUDENT CURRENTLY
 * 
 * ALSO NOTE
 * to use this program, you have to look at "guardlist" .txt and "studentlist".txt to see the items that can pass the checks
 * for guards it goes, there first name, there last name, there ID, then there password
 * for students it goes, there first name, there last name, there ID
 * 
 * as for the print txt, its goes, first name, last name, ID, if they are carrying a firearm, and any speical commetts
 * this would be the file sent to a "dispatcher"
 *
 * @author (Peter Keres)
 * @version (4 28 2018)
 * f@ck cancer
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;



public class QEP
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        //vars needed
        String guardNameF = "", guardNameL="", guardID="", guardPass="", studentNameF="", studentNameL="", studentID="";
        boolean guardFinal = false,studentFinal = false, quit = false;
       
        
        //objects needed
        Scanner scanInput = new Scanner(System.in);
        guard guard1;
        student student1 = new student("  "," "," ");
        
        
        //greet the user
        System.out.println("Welcome to the QEP not one more program.");
        System.out.println("In order to use the program, please enter the following data.");
        
        while (!guardFinal)
        {
            
            //getting the guard name , ID, and password
            System.out.println("Please enter your first name.");
            guardNameF = scanInput.nextLine();
            
            System.out.println("Please enter your last name.");
            guardNameL = scanInput.nextLine();
            
            System.out.println("Please enter your ID.");
            guardID = scanInput.nextLine();
            
            System.out.println("Please enter your password.");
            guardPass = scanInput.nextLine();
            
           
            //making the guard object
            guard1 = new guard(guardNameF,guardNameL,guardID,guardPass);
            
            
            
            //to check that the name, Id, and pass are in data base
            if (guard1.checkNameF() && guard1.checkNameL() && guard1.checkPass() && guard1.checkID())
                guardFinal = true;
                
                
            if (!guardFinal)
            {
                blankScreen();
                System.out.println("The information you have entered does not match our records, please try again");
                        
            }
        }   
        
        
        //call a method that will clear screen
        blankScreen();
        System.out.println("Thank you " + guardNameF + ". Welcome to the QEP program.");
        
        //get input about the students
        while (!quit)
        {
            System.out.println("Please enter the students first name.");
            studentNameF = scanInput.nextLine();
            
            System.out.println("Please enter the students last name.");
            studentNameL = scanInput.nextLine();
            
            System.out.println("Please enter the students ID.");
            studentID = scanInput.nextLine();
            
            
            student1 = new student(studentNameF, studentNameL, studentID);
            
            //checking to see if the student info is in the data base
            if (student1.checkNameF() && student1.checkNameL() && student1.checkID() )
            {
                studentFinal = true;
                quit = true;
            }
            
            if (!studentFinal && !quit)     //that info does not match any in data base, make sure they know
            {
                blankScreen();
                System.out.println("Sorry The information you have entered does not match our records.");
                System.out.println("Please make sure you have enterd it in correctly, if so then the person does not match any student in our records");
                System.out.println("student name: " + studentNameF + " " + studentNameL + "\t" + "studentID: " + studentID);
                
            }
            else
            {
                // to show that they entered the studet info right and its in data base
                blankScreen();
                System.out.println("Student " + studentNameF + " is in our system.");
                
                System.out.println("is " + studentNameF + " currently carring?");
                student1.setCarry(scanInput.nextLine());
                student1.checkCarry();
                
                
                System.out.println("Any specail notse for " + studentNameF);
                student1.setSpecial(scanInput.nextLine());
                    
            }
         }
         
         
         //write the student info to a file
         //this file is what would be sent to the dispatcher's program
         PrintWriter output = new PrintWriter("output.txt");          //this creates the file
         output.println(studentNameF);
         output.println(studentNameL);
         output.println(studentID);
         output.println(student1.getCarry());
         output.println(student1.getSpeical());
         output.close();
         
         
         
         
         //doing a print out to the screen to show what the "dispatcher" would see
            blankScreen();
            System.out.println("Here is the data on the following students that would be displayed to a disbatcher.");
            System.out.println();
            System.out.println("NAME:" + "\t" + "\t" + "ID:" + "\t" + "CARRYING:" + "\t" + "COMMETTS:");
            if (student1.getCarry().equalsIgnoreCase("yes"))
                System.out.println(studentNameF + " " + studentNameL + "\t"  + studentID + "\t" + "YES" + "\t" + "\t" + student1.getSpeical());
            else
                System.out.println(studentNameF + " " + studentNameL + "\t"  + studentID + "\t" + "NO" + "\t" +  "\t" + student1.getSpeical());
    }
        
    //doing a method to blank out the screen
    public static void blankScreen (){
    
        for (int i = 0; i < 16; i++)                        //not really what i want it to do cuz you end up at bottom of screen
            System.out.println();                           // but it gets the idea across   
        }
    
}
