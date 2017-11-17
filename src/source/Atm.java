/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;


import java.io.Serializable;
import java.util.Scanner;


/**
 *
 * @author bhatiadivij
 */
public class Atm implements Serializable
{
    private static final long serialVersionUID = 7849682197712955943L;
       private long atmId;
       private Branch branch;
       private long balance;
       private int oneHundredNotes;
       private int fiveHundredNotes;
       private int oneThousandNotes;

    public Atm(long atmId, long bCode, double balAmount,String name,String address,String bankCode, long balance, int oneHundredNotes, int fiveHundredNotes, int oneThousandNotes) {
        this.atmId = atmId;
        branch=new Branch(bCode, balAmount, name, address, bankCode);
        this.balance = balance;
        this.oneHundredNotes = oneHundredNotes;
        this.fiveHundredNotes = fiveHundredNotes;
        this.oneThousandNotes = oneThousandNotes;
        
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
       
//       private Account findAccount()
//       {
//           long cno,acno;
//           int pin;
//           boolean flag=false;
//           Scanner in=new Scanner(System.in);
//           System.out.println("Enter Card Number : ");
//           cno=Integer.parseInt(in.nextLine());
//           System.out.println("Enter Pin : ");
//           pin=Integer.parseInt(in.nextLine());
//           for( Customer c : branch.getCustomer()  )
//           {
//                  for(Account a : c.getAccount())
//                      { 
//                              Card temp=a.getCard();
//
//                              if(temp.getCardNumber()==cno)
//                              {  
//                                     acno=temp.authenticate(pin);
//                                     if(acno==-1)
//                                     {
//                                            System.out.println("Your Card is blocked !!");
//                                            flag=true;
//                                            break;
//                                     }
//                                     else if(acno==0)
//                                     {
//                                            System.out.println("Invalid pin !!");
//                                            flag=true;
//                                            break;
//                                     }
//                                     else
//                                     {
//                                           return a;
//                                        
//                                     }
//                              }
//                      }
//           
//              if(flag)
//                break;
//           }
//         return null;
//       }
       
       public void display()
       {
           System.out.println(atmId+" "+balance+" "+fiveHundredNotes+" "+oneHundredNotes+" "+oneThousandNotes);
           branch.display();
       }    
       public void withdrawl(double amnt)
       {
             GlobalAtm.acc.withdrawl(amnt);
             balance-=amnt;
       }
       
       public void deposit(double amnt)
       {
         
             GlobalAtm.acc.deposit(amnt);
             balance+=amnt;
       }
       
       public String[] balanceEnquiry()
       {
        
        
            return GlobalAtm.acc.balanceEnquiry();
          
       }
       
       public void changePin(int oldPin,int newPin,int confirmPin)
       {
            
              GlobalAtm.acc.getCard().changePin(oldPin,newPin,confirmPin);
       }

    public Branch getBranch() {
        return branch;
    }
 
     
}
