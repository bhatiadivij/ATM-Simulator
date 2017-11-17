/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author bhatiadivij
 */
public class Customer implements Serializable
{
    private static final long serialVersionUID= -5310147595937096754L;
   private String name;
   private long panNum;
   private long aadharNum;
   private long phone;
 
   private Vector<Account> account;

  

    public String getName() {
        return name;
    }

    public long getPanNum() {
        return panNum;
    }

    public long getAadharNum() {
        return aadharNum;
    }

    public long getPhone() {
        return phone;
    }

    public Vector<Account> getAccount() {
        return account;
    }

    public Customer(String name, long panNum, long aadharNum, long phone) {
        this.name = name;
        this.panNum = panNum;
        this.aadharNum = aadharNum;
        this.phone = phone;
        account=new Vector<Account>();
        addAccount();
    }
    public void display()
    {
       System.out.println(name+" "+ panNum+" "+ aadharNum+" "+ phone );
       for(int i=0;i<account.size();i++)
         {
             account.elementAt(i).display();
         }
    }
    
    public  long search(long cnum, int pin)
    {long  a=-2;
        for(int i=0;i<account.size();i++)
        {
             if(account.elementAt(i).getCard().getCardNumber()==cnum )
             {
                    a=   account.elementAt(i).getCard().authenticate(pin);
             
                   
             }
            
        
        }
        return a;
    }
    
    public void setAcc()
    {
       for(int i=0;i<account.size();i++)
       {
              if(GlobalAtm.acnum==account.elementAt(i).getAccountId())
              {
                  GlobalAtm.acc=account.elementAt(i);
              }
       }
    
    }
   public void addAccount()
   {
      String bankName;
      long branchId,  cardNumber;
      String holderName;
      int pin; 
      Date expiry;
      long accountNum;
      double sameBankLimit,otherBankLimit,  balance;
      long accountId;
      
      int num=0;
         Scanner in = new Scanner(System.in);
         System.out.println("Enter How many Accounts  ? ");
         num=Integer.parseInt(in.nextLine());
         
         for(int i=0;i<num;i++)
            {

                 System.out.println("Enter Bank Name : ");
                 bankName=in.nextLine();
                 System.out.println("Enter Branch Id : ");
                 branchId=Long.parseLong(in.nextLine());
                 System.out.println("Enter Card Number : ");
                 cardNumber=Long.parseLong(in.nextLine());
                 holderName=name;
                 System.out.println("Enter pin : ");
                 pin =Integer.parseInt(in.nextLine());
                 System.out.println("Enter account number : ");
                 accountNum =Integer.parseInt(in.nextLine());
                 System.out.println("Enter same bank limit : ");
                 sameBankLimit =Double.parseDouble(in.nextLine());                 
                 System.out.println("Enter other bank limit : ");
                 otherBankLimit =Double.parseDouble(in.nextLine());
                 System.out.println("Enter balance : ");
                 balance =Double.parseDouble(in.nextLine());
                 System.out.println("Enter account Id : ");
                 accountId =Long.parseLong(in.nextLine());
                 System.out.println("in cust0");
                 expiry=new Date();
                 System.out.println("in cust1");
                 expiry.setYear(expiry.getYear()+15); 
                 System.out.println("in cust2");
                 Account a=new Account(bankName, branchId, cardNumber, holderName, pin, expiry, accountNum, sameBankLimit, otherBankLimit, balance, accountId);
                 System.out.println("in cust4");
                 account.addElement(a);
                 System.out.println("in cust5");
            }
      
              
   }
    
}
