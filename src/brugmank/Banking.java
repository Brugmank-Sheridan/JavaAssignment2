/*
        Name:  [your name here]
        Assignment:  [assignment name]
        Program: [your program name here]
        Date:  [assignment due date here]
    
        Description:
        [program description in your own words]
    */

package brugmank;

import java.util.Scanner;

/**
 *
 * @author katarn
 */
public class Banking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Banking newAccount = new Banking();
        Scanner input = new Scanner (System.in);
        
        newAccount.bankAccount = newAccount.createAccount(input);
        
        System.out.println(newAccount.chequing.AccountNo);
        System.out.println(newAccount.savings.AccountNo);
        System.out.println(newAccount.investing.AccountNo);
        
        System.out.println(newAccount.chequing.Balance);
        System.out.println(newAccount.savings.Balance);
        System.out.println(newAccount.investing.Balance);
        
        
    }
    
    private Account bankAccount = new Account(null, null, 0, 0, 0, 0, 0){};
   
    private Account chequing = new ChequingAccount();
    private Account savings = new SavingsAccount();
    private Account investing = new InvestmentAccount();
    
    
    public Account createAccount (Scanner input)
    {
       boolean valid;
       
       do
       {
           System.out.print("Enter customer name: ");
           
           try
           {
               var name = input.nextLine();
               valid = bankAccount.setCustomerName(name);
               
               chequing.setCustomerName(name);
               savings.setCustomerName(name);
               investing.setCustomerName(name);
           }
           catch (IllegalArgumentException e)
           {
               System.out.println(e.getMessage());
               valid = false;
           }
       }
       while(!valid);
       
       do
       {
           System.out.print("Enter account number: ");
           
           try
           {
               var accountNo = input.nextLine();
               valid = bankAccount.setAccountNo(accountNo);
               
               chequing.setAccountNo(accountNo);
               savings.setAccountNo(accountNo);
               investing.setAccountNo(accountNo);
           }
           catch (IllegalArgumentException e)
           {
               System.out.println(e.getMessage());
               valid = false;
           }
       }
       while (!valid);
       
       do
       {
           System.out.print("Enter withdrawal ammount: ");
           var Withdraw = input.nextLine();
           
           try
           {
               var withdraw = Double.parseDouble(Withdraw);
               valid = bankAccount.withdraw(withdraw);
               
               chequing.withdraw(withdraw);
               savings.withdraw(withdraw);
               investing.withdraw(withdraw);
               
           }
           catch (NumberFormatException e)
           {
               System.out.println("Must be a valid number");
               valid = false;
           }
           catch (IllegalArgumentException e)
           {
               System.out.println(e.getMessage());
               valid = false;
           }
       }
       while (!valid);
        
        
        return bankAccount;
    }
    
}