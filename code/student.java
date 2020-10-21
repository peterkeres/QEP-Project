package code;
/**
 * This is the student class for the QEP project
 * it will do the following/
 * it will take the first name and last, ID and check them in the "data base"
 * it will take in current location, check it vs known locationos and store it 
 * will take in and store if they are carrying 
 * will take in  and store any speical commett
 *
 *
 * @author (Peter Keres )
 * @version (4 28 2018)
 * F@ck Cancer
 * 
 */

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;   

public class student
{
    //vars i need
    private String cStudentNameF, cStudentNameL, cStudentID, specialCommett, cLine, hasCarry;
    
    private int lineNum;
    private FileReader reader;
    
    //any objects
    Scanner scan = new Scanner(System.in);
    
    //constructor
    public student(String fName, String lName, String ID)
    {
        cStudentNameF = fName;
        cStudentNameL = lName;
        cStudentID = ID;     
    }
    
    //setters for all the values
    public void setNameF(String name)
    {
        cStudentNameF = name;
    }
    
    public void setNameL(String name)
    {
        cStudentNameL = name;
    }
    
    public void setID(String ID)
    {
        cStudentID = ID;
    }
    
    public void setSpecial(String commett)
    {
        specialCommett = commett;
    }
    
    public void setCarry (String carry)
    {
        hasCarry = carry;
    }
    
    //getters for all values
    public String getNameF()
    {
        return cStudentNameF;
    }
    
    public String getNameL()
    {
        return cStudentNameL;
    }
    
    public String getID()
    {
        return cStudentID;
    }
    
    public String getSpeical()
    {
        return specialCommett;
    }
    
    public String getCarry()
    {
        return hasCarry;
    } 
       
    
    //check the values of name , ID vs the file to make sure its ok 
    //check for name first
    public boolean checkNameF() throws FileNotFoundException        //to handle the exception
    {
        try{
        reader = new FileReader("code/studentlist.txt");                   //goes and open files
        }  
         catch (FileNotFoundException A)
        {
            System.out.println("Could not find file");
        }
        Scanner scanFile = new Scanner(reader);                     //lets me look at the file
    
        
        while(scanFile.hasNextLine())
        {
            lineNum = lineNum + 1;                              // to keep track of what line im on in reading the file
            cLine = scanFile.nextLine();
            if (cLine.equalsIgnoreCase(cStudentNameF))            //if the names match up
            {
                return true;
            }    
         }
        scanFile.close();
        return false;
    }
    
    //chekcing last name
    public boolean checkNameL() throws FileNotFoundException        //to handle the exception
    {
        try{
        reader = new FileReader("code/studentlist.txt");                   //goes and open files
        }  
         catch (FileNotFoundException A)
        {
            System.out.println("Could not find file");
        }
        Scanner scanFile = new Scanner(reader);                     //lets me look at the file
    
        
       for (int i=0; i< lineNum; i++)                              //goes to the line 1 after the first name to check mathcing last name
        {
            scanFile.nextLine();
        }
        
        cLine = scanFile.nextLine();
        if (cLine.equalsIgnoreCase(cStudentNameL))            //if the names match up
            {
                return true;
            }    
            
        scanFile.close();
        return false;
    }
    
    //cheking for the ID
    public boolean checkID() throws FileNotFoundException        //to handle the exception
    {
        try{
        reader = new FileReader("code/studentlist.txt");                   //goes and open files
        }  
         catch (FileNotFoundException A)
        {
            System.out.println("Could not find file");
        }
        Scanner scanFile = new Scanner(reader);                     //lets me look at the file
    
        
        for (int i=0; i< (lineNum + 1); i++)                        //goes to the line 1 after the Pass  to check ID
        {
            scanFile.nextLine();
        }
        
        cLine = scanFile.nextLine();
        if (cLine.compareTo(cStudentID) == 0)            //if the ID match up
            {
                return true;
            }    
         
        scanFile.close();
        return false;
    }
    
    // check input on carry.
    public void checkCarry()
    {
        while (!hasCarry.equalsIgnoreCase("yes") && !hasCarry.equalsIgnoreCase("no"))
        {
           System.out.println("Please enter only a yes or a no.");
           hasCarry = scan.next();
        }
        
    }
}