/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;
import java.util.*;
import source.Calculator;
import java.lang.*;
import java.io.*;
import java.lang.Math;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import source.DBConnect;



/**
 *
 * @author bhatiadivij
 */
public class EmiCalc 
{
    
     public Date dt = new Date();
     public int month;
     public int year;
     public int i=0;
     public static int time;
     public static long pAmnt;
     public static double rate;
     public String monthName;
     public Math m;

    public EmiCalc() 
    {
         month=dt.getMonth();
         year=dt.getYear()+1900;
         time=Calculator.tenure*12;
         pAmnt=Calculator.Principal;
         rate=Calculator.rate;
         System.out.println("time "+Calculator.tenure+"pamnt"+Calculator.Principal+"rate"+Calculator.rate);
    }
    
     public String generateTable()
     {
         
         
         double r=rate/(12*100),percLoanPaid=0,emi, p=pAmnt,interest=0,balance=pAmnt;
         String status=new String();
        
         double temp = m.pow(1+r,time)/(m.pow(1+r,time)-1);
         emi =p*r*temp;
        
           try
            {  
                Connection con=DriverManager.getConnection(DBConnect.conString,DBConnect.User,DBConnect.Pass);
                Statement st=con.createStatement();
                String Query= "delete from loanData;";
                st.executeUpdate(Query);
                
                con.close();
            }
           catch(Exception ex)
            {
                status= ex.toString(); 
            }
         while(i<time)
         {
            monthName=getMonthName(month)+year;
            if(month==11)
              { 
                  month=0; 
                  year++;
              }
            else
              {  
                  month++;
              }
            interest=m.round(balance*r*1*100.0)/100.0;
            p=m.round((emi-interest)*100.0)/100.0;
            balance=balance-p;
            percLoanPaid=m.round((((pAmnt-balance)*100)/pAmnt)*100.0)/100.0;
            
            try
            {  
                Connection con=DriverManager.getConnection(DBConnect.conString,DBConnect.User,DBConnect.Pass);
                Statement st=con.createStatement();
                String Query= "Insert into loanData values ('"+monthName+"',"+p+","+interest+","+emi+","+balance+","+percLoanPaid+");";
                st.executeUpdate(Query); 
                con.close();          
            }
            catch(Exception ex)
            {
                status= ex.toString(); break;
                
            }
            //status="time "+ time+"pamnt"+pAmnt+"rate"+rate+"emi"+emi;
            i++;
         }
     return status;
     }
     
     public String getMonthName(int Month)
     {
         String month=new String();
        switch(Month)
        {
            case 0: month= "January "; break;
            case 1: month= "February "; break;
            case 2: month= "March "; break;
            case 3: month= "April "; break;
            case 4: month= "May "; break;
            case 5: month= "June "; break;
            case 6: month= "July "; break;
            case 7: month= "August "; break;
            case 8: month= "September "; break;
            case 9: month= "October "; break;
            case 10: month= "November "; break;
            case 11: month= "December "; break;
                            
        }
     return month;
     
     }
     
     
}
