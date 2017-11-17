/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;
import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import java.util.Scanner;

/**
 *
 * @author bhatiadivij
 */

public class inout 
{
    public static void main(String[] args) throws IOException
    { 
          try{
           //file writing..
//              long atmId , bCode;
//              double balAmount;
//              String name, address, bankCode;
//              long balance;
//              int oneHundredNotes,  fiveHundredNotes, oneThousandNotes;
//                 Scanner in = new Scanner(System.in);
//                 System.out.println("Enter atm id : ");
//                 atmId=Long.parseLong(in.nextLine());
//                 System.out.println("Enter branch Code : ");
//                 bCode=Long.parseLong(in.nextLine());
//                 System.out.println("Enter Balance Amount : ");
//                 balAmount=Double.parseDouble(in.nextLine());
//                 System.out.println("Enter bank name : ");
//                 name =in.nextLine();
//                 System.out.println("Enter bank address : ");
//                 address=in.nextLine();
//                 System.out.println("Enter bank Code : ");
//                 bankCode=in.nextLine();
//                 System.out.println("Enter Balance Amount : ");
//                 balance=Long.parseLong(in.nextLine());
//                 System.out.println("Enter 100 notes : "); 
//                 oneHundredNotes =Integer.parseInt(in.nextLine());
//                 System.out.println("Enter 500 notes : "); 
//                 fiveHundredNotes =Integer.parseInt(in.nextLine());
//                 System.out.println("Enter 1000 notes : "); 
//                 oneThousandNotes =Integer.parseInt(in.nextLine());
//                 Atm a=new Atm(atmId, bCode, balAmount, name, address, bankCode, balance, oneHundredNotes, fiveHundredNotes, oneThousandNotes);
//                 FileOutputStream fos= new FileOutputStream("data.txt", false);
//                 
//                 ObjectOutputStream oos=new ObjectOutputStream(fos);                  
//                                       
//                     oos.writeObject(a);               
//                     oos.close();
//                    fos.close();

                       //file reading...

                              FileInputStream fis=new FileInputStream("data.txt");

                              ObjectInputStream ois =new  ObjectInputStream(fis);
                              boolean check=true;
                              
                               try
                                   {
                    

                                         Atm b = (Atm)ois.readObject();
                                       
                                          b.display();                                   

                                   }
                                 catch(Exception ex)
                                   {
                                                   fis.close();
                                                   ois.close();
                                 
                                       System.out.println(ex.toString());
                                   }
                              
             }
          catch(Exception ex){
              printStackTrace();
              System.out.println(ex.toString());
          }
         
    }
    
}
