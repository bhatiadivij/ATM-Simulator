/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author bhatiadivij
 */
public class Account implements Serializable
{
    private static final long serialVersionUID = -1244554676499684314L;
    private String bankName;
    private long branchId;
    private Vector<Transaction> details;
    private Card card;
    private double balance;
    private long accountId;

    public Account(String bankName, long branchId,  long cardNumber, String holderName, int pin, Date expiry,long accountNum,double sameBankLimit,double otherBankLimit, double balance, long accountId) {
        System.out.println("in acc1");
        this.bankName = bankName;
        this.branchId = branchId;
        System.out.println("in acc2");
        this.balance = balance;
        this.accountId = accountId;
        System.out.println("in acc3");
        details=new Vector<Transaction>();
        card=new Card( cardNumber,  holderName, pin, expiry, accountNum, sameBankLimit, otherBankLimit);
        System.out.println("in acc4");
    }
  void display()
  {
     System.out.println(bankName+" "+branchId+" "+balance+" "+accountId);
     card.display();
  }
  
    public Account() {
    }

    public Vector<Transaction> getDetails() {
        return details;
    }
    
    
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    
   

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

   public void withdrawl(double amnt)
    {
        
             
        if(balance>amnt  )
        {  
            if((amnt%100==0))
            {  balance-=amnt;
             JOptionPane.showMessageDialog(null,"Collect Your Cash !! Transaction Successful..!");
             details.add(new Transaction("Withdrawl", amnt));
            }
          else
           {
              JOptionPane.showMessageDialog(null,"Invalid Input. Try again!!");
          
           } 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Not enough money in account. Try again!!");
          
        }
        
    }
    
    public void deposit(double amnt)
    {
             balance+=amnt;
             
             JOptionPane.showMessageDialog(null,"Transaction Successful..!");
             details.add(new Transaction("Deposit", amnt));
        
    }

    public String[] balanceEnquiry()
    {
        String msg[]=new String[3];
        msg[0]="Bank Name : " + bankName;
        msg[1]="  Account Number : " + accountId;
        msg[2]=" Balance : " + balance;          

        return msg;
    }
     public void showTransactionDetails()
   {
       int length=details.capacity();
      
       System.out.println("Date and Time \t Transaction Type \t Amount");
       for(int i=0;i<length;i++)
       {
           SimpleDateFormat format=new SimpleDateFormat("MMMM dd,yyyy HH:mm:ss");
           
           System.out.println(format.format(details.elementAt(i).getTransactionDate())+ "\t"+details.elementAt(i).getTransactionType()+"\t"+details.elementAt(i).getAmount());
       }
       
   }

}
