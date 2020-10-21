package code;
/**
 * This is the guard class for the QEP project
 * this class will, load names from a file, take current names and id from main,
 * check ids name ect to see if they are valid,
 * 
 *
 * @author (Peter Keres)
 * @version (4 28 2018)
 * f@ck cancer
 */

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;


public class guard
{
    //vars needed
    private String cGuardNameF,cGuardNameL, cGuardPass, cGuardID, cLine;
    private int lineNum;                                          //base number is based off the first name loop
    private FileReader reader;
    
    //objects
    
         
    //constructor
    public guard(String fName, String lName, String pass, String ID)
    {
        cGuardNameF = fName;
        cGuardNameL = lName;
        cGuardPass = pass;
        cGuardID = ID;
    }
    
    //writing setteres for all current values
    public void setNameF(String name)
    {
        cGuardNameF = name;
    }
    
    public void setNameL(String name)
    {
        cGuardNameL = name;
    }
    
    public void setPass (String pass)
    {
        cGuardPass = pass;
    }
    
    public void setID(String ID)
    {
        cGuardID = ID;
    }
    
    
    //all the getters for the current guard information
    public String getNameF()
    {
        return cGuardNameF;
    }
    
    public String getNameL()
    {
        return cGuardNameL;
    }
    
    public String getPass()
    {
        return cGuardPass;
    }
    
    public String getID()
    {
        return cGuardID;
    }
    
    //checks to see if the frist name is in the file and returns true
    public boolean checkNameF() throws FileNotFoundException        //to handle the exception
    {
        try{
        reader = new FileReader("code/guardlist.txt");                   //goes and open files
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
            if (cLine.equalsIgnoreCase(cGuardNameF))            //if the names match up
            {
                return true;
            }    
         }
        scanFile.close();
        return false;
    }
    
    //check last name
    public boolean checkNameL() throws FileNotFoundException        //to handle the exception
    {
        try{
        reader = new FileReader("code/guardlist.txt");                   //goes and open files
        }  
         catch (FileNotFoundException A)
        {
            System.out.println("Could not find file");
        }
        Scanner scanFile = new Scanner(reader);                     //lets me look at the file
    
        
        try
        {
        for (int i=0; i< lineNum; i++)                              //goes to the line 1 after the first name to check mathcing last name
        {
            scanFile.nextLine();
        }
        
        
        cLine = scanFile.nextLine();
        if (cLine.equalsIgnoreCase(cGuardNameL))            //if the names match up
            {
                return true;
            }    
        }
        catch(NoSuchElementException A)                     //because it went past the end of the file
        {
            scanFile.close();
            return false;
        }
        
        scanFile.close();
        return false;
    }
    
    //checking the guards password
    public boolean checkPass() throws FileNotFoundException        //to handle the exception
    {
        try{
        reader = new FileReader("code/guardlist.txt");                   //goes and open files
        }  
         catch (FileNotFoundException A)
        {
            System.out.println("Could not find file");
        }
        Scanner scanFile = new Scanner(reader);                     //lets me look at the file
    
        try
        {
        for (int i=0; i< (lineNum + 1); i++)                        //goes to the line 1 after the last name to check pass
        {
            scanFile.nextLine();
        }
        
        
        
        cLine = scanFile.nextLine();
        if (cLine.compareTo(cGuardPass) == 0)                     //if the pass match up
            {
                return true;
            }    
        }
        catch (NoSuchElementException A)                            //becuse it went past end of the file, return a flase
        {
            scanFile.close();
            return false;
        }
        scanFile.close();
        return false;
    }
    
    //checking the ID
    public boolean checkID() throws FileNotFoundException        //to handle the exception
    {
        try{
        reader = new FileReader("code/guardlist.txt");                   //goes and open files
        }  
         catch (FileNotFoundException A)
        {
            System.out.println("Could not find file");
        }
        Scanner scanFile = new Scanner(reader);                     //lets me look at the file
    
        try
        {
        for (int i=0; i< (lineNum + 2); i++)                        //goes to the line 1 after the Pass  to check ID
        {
            scanFile.nextLine();
        }
        
        
        cLine = scanFile.nextLine();
        if (cLine.compareTo(cGuardID) == 0)            //if the ID match up
            {
                return true;
            }    
        }
        catch (NoSuchElementException A)                    // if it goes past the end of the file
        {
            scanFile.close();
            return false;
        }
        scanFile.close();
        return false;
    }
}
