/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Vector;

/**
 *
 * @author bhatiadivij
 */
public class Transaction implements Serializable
{
   private Date transactionDate; 
   private String transactionType;
   private Double amount;

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
   
  
   public Transaction()
   {
   
   }
   
  public Transaction(String type , Double amount)
  {
      transactionDate=new Date();
      transactionType=type;
      this.amount=amount;
            
  }

}
