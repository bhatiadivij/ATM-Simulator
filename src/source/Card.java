/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.IOException;
import java.io.Serializable;
import java.nio.CharBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;




/**
 *
 * @author bhatiadivij
 */
public class Card implements Serializable
{
       private static final long serialVersionUID = -944746845422214217L;
       private long cardNumber;
       private long accountNum;
       private String holderName;
       private int pin;
       private Date expiry;
       private boolean blockStatus;
       private Date blockDate;
       private double sameBankLimit;
       private double otherBankLimit;
       

    public Card() 
    {
   
    }

    public Card(long cardNumber, String holderName, int pin, Date expiry,long accountNum,double sameBankLimit,double otherBankLimit) 
    {   System.out.println("in card");
        this.accountNum=accountNum;
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.pin = pin;
        this.expiry = expiry;
        blockStatus=false;
        this.sameBankLimit=sameBankLimit;
        this.otherBankLimit=otherBankLimit;
    }
public void display()
{

       System.out.println(cardNumber+" "+accountNum+" "+holderName+" "+pin+" "+expiry+" "+sameBankLimit+" "+otherBankLimit);
}
    public long getCardNumber() {
        return cardNumber;
    }
    
       
    public void changePin( int oldPin,int newPin,int confirmPin)
    {
                       if(oldPin==pin)
                       {
                           if(newPin==confirmPin)
                           {
                               pin=newPin;
                               JOptionPane.showMessageDialog(null,"PIN changed Successfully !! ");

                           }
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,"Invalid PIN.! Try Again!!");
                           
                       }
              
            
    }
    
    public long authenticate(int pin)
    {
//         if(unblockCard())
//         {
                 

                    if(pin==this.pin)
                    {
                       return accountNum;
                    }
                    else
                    { 
                        return 0;
                    }
//         }
//         else
//         {
//           return -1;
//         }
    }

    public int getPin() {
        return pin;
    }
    
    public void blockCard()
            {
               blockStatus=true;
               blockDate=new Date();           
            }
    
    private boolean unblockCard()
    {
        Date currentDate=new Date();
        int curYear,curDay,curDate,bYear,bDay,bDate;      

        

         curYear=currentDate.getYear();
         curDate=currentDate.getDate();
         curDay=currentDate.getDay();
         
         bYear= blockDate.getYear();
         bDate= blockDate.getDate();
         bDay=blockDate.getDay();
         
         Calendar b=Calendar.getInstance();
         Calendar c=Calendar.getInstance();
         b.set(bYear, bDate, bDate);
         c.set(curYear, curDate, curDate);
         long bmili=b.getTimeInMillis();
         long cmili=c.getTimeInMillis();
         long diffInMilis = cmili - bmili;
         long diffInDays = diffInMilis / (24 * 60 * 60 * 1000);
         if(diffInDays>3)
           {
               blockStatus=false;
               return true;
           }
         else
         {
           return false;
         }
    }

    public double getSameBankLimit() 
    {
        return sameBankLimit;
    }

    public double getOtherBankLimit() 
    {
        return otherBankLimit;
    }
    
   
    
}
