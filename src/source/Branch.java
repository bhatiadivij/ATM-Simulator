/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author bhatiadivij
 */
public class Branch extends Bank implements Serializable
{
    private static final long serialVersionUID = 6224128714522558785L;
     protected long branchCode;
     protected double balanceAmount;
     protected Vector<Customer> customer;
     
     
     public Vector<Customer> getCustomer() 
        {
            return customer;
        }
     public Branch( long bCode, double balAmount,String name,String address,String bankCode)
     {
       
         super(name,address,bankCode);
         branchCode=bCode;
         balAmount=balanceAmount;
         customer=new Vector<Customer>();
         addCustomer();
     }
     public void display()
     {
         System.out.println(address+" "+bankCode+" "+name+" " + balanceAmount+ " " +" "+branchCode);
         
         for(int i=0;i<customer.size();i++)
         {
             customer.elementAt(i).display();
         }
     
     }
     public void getCust()
     {
        for(int i=0;i<customer.size();i++)
        {
              customer.elementAt(i).setAcc();
              GlobalAtm.customer=customer.elementAt(i);
        }
     }
     public long search(long cnum,int pin)
     {long a=-2;
         for(int i=0;i<customer.size();i++)
         {
             a=customer.elementAt(i).search(cnum,pin);
             if(a>-2)
                 return a;
         }
     return a;
     }
     public void addCustomer()
     {
        String name;
        long panNum,  aadharNum,  phone,  accountId;
        int num=0;
         Scanner in = new Scanner(System.in);
                 System.out.println("Enter How many Customers  ? ");
                 num=Integer.parseInt(in.nextLine());
         
         for(int i=0;i<num;i++)
            {

                 System.out.println("Enter name : ");
                 name=in.nextLine();
                 System.out.println("Enter PAN number : ");
                 panNum=Long.parseLong(in.nextLine());
                 System.out.println("Enter Aadhar Number : ");
                 aadharNum=Long.parseLong(in.nextLine());
                 System.out.println("Enter phone : ");
                 phone =Long.parseLong(in.nextLine());
                 Customer temp=new Customer(name, panNum, aadharNum, phone);
                 customer.addElement(temp);
                 
            }
     }
    
    
}
