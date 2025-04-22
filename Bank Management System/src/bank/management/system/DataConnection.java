
package bank.management.system;
import java.sql.*;  
/**
 *
 * @author ECHO TECH
 */
public class DataConnection {// for connceting database
    Connection c;//making obj of conn class for connceting database 2nd step
    Statement s;//making obj of statement class for passing stat 3rd step
    DataConnection()/*The try-catch construct is primarily used to handle runtime errors and exceptions that may occur during program 
execution. When a program encounters an error in the try block, it throws an exception, which can then be caught and handled 
in the catch block.This prevents the program from crashing and allows it to gracefully recover from the error.*/
     {//as MYSQL is external entity so it is likely to throw runtime error
        /*EXCEPTIONAL HANDLING*/ try{
      Class.forName("com.mysql.jdbc.Driver");  //registring driver 1st step
/*2nd step*/c =DriverManager.getConnection("jdbc:mysql:///bank_management_system2","root","goatcr77");//onnceting with database 
/*3rd step*/s =c.createStatement(); //3rd step

             
         }
         catch(Exception e)//using exception class
         {
             System.out.println(e);// the error will be printed
         }
     }
    
}
