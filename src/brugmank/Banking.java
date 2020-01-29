/*
        Name:  Kyle Brugmans
        Assignment:  Assignment 02
        Program: Banking
        Date:  2020-01-29
    
        Description:
        The Banking program prompts the user to create a bank acccount giving
        them a chequing (with overdraft), savings, and investing account which
        the user can deposit and withdraw from.
        
        The program gives an annual interest rate per account and 50 cents
        for each dollar deposited into investment.
        
        Finally displaying account information for the account holder.

        
    */

package brugmank;

import java.util.Scanner;

/**
 * Create a bank account with three types: chequing, savings, investment.
 * @author Kyle Brugmans
 */
public class Banking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Banking newAccount = new Banking();
        Scanner input = new Scanner (System.in);
        
        newAccount.bankAccount = newAccount.createAccount(input);
        
        System.out.println(newAccount.bankAccount.toString());
        System.out.println(newAccount.chequing.toString());
        System.out.println(newAccount.savings.toString());
        System.out.println(newAccount.investing.toString());
        
        
    }
    
    // Default values for new Accoount object.
    private Account bankAccount = new Account(null, null, 0, 0, 0, 0){};
   
    
    // Initializing the three main accounts for the user.
    private final Account chequing = new ChequingAccount();
    private final Account savings = new SavingsAccount();
    private final Account investing = new InvestmentAccount();
    
    
    /**
     * Allows the user to input and access their account information.
     * @param input users input to account.
     * @return bankAccount data get put into object.
     */
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
       
       System.out.println(chequing.accountCreationConfirmation());
       System.out.println(savings.accountCreationConfirmation());
       System.out.println(investing.accountCreationConfirmation());
       
       chequing.addIntrest();
       savings.addIntrest();
       investing.addIntrest();
       
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
       
       do
       {
           System.out.print("Enter deposit ammount: ");
           var Deposit = input.nextLine();
           
           try
           {
               var deposit = Double.parseDouble(Deposit);
               valid = bankAccount.deposit(deposit);
               
               chequing.deposit(deposit);
               savings.deposit(deposit);
               investing.deposit(deposit);
               
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
