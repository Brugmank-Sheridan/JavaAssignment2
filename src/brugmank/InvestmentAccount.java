/*
        InvestmentAccount
        Author: Kyle Brugmans
        Date: 2020-1-28

        Description
         Holds the information for the users investment account.
    */

package brugmank;

/**
 * Allows user to manage their investments account.
 * 
 * @author Kyle Brugmans
 */
public class InvestmentAccount extends SavingsAccount {

    /**
     * Default values.
     * 
     * @param AccountNo The bank account ID number.
     * @param CustomerName The bank holders name.
     * @param Balance Current balance in the account.
     * @param Withdraw Last withdraw amount made.
     * @param Deposit Last deposit amount made.
     * @param Interest Annual percentage for the current balance.
     */
    public InvestmentAccount(String AccountNo, String CustomerName,
        double Balance, double Withdraw, double Deposit, double Interest)
    {
        super(AccountNo,
                CustomerName,
                Balance,
                Withdraw,
                Deposit,
                Interest);
    }
    
    public  InvestmentAccount()
    {
        super(null, null, 0, 0, 0, 0.03);
    }
    
    /**
     * Sets the bank account ID number.
     * 
     * @param AccountNo users account number input.
     * @return true.
     */
    @Override
    public boolean setAccountNo(String AccountNo)
    {
       this.AccountNo = "3" + AccountNo;
       return true;
    }
    
    /**
     * Withdraw money out of the investing.
     * 
     * @param withdraw amount being taken out.
     * @return true.
     */
    @Override
    public boolean withdraw(double withdraw)
    {
        if (withdraw <= this.Balance)
        {
            this.Balance -= withdraw;
            this.Withdraw = withdraw;
        }
        return true;
    }
    
    /**
     * Deposits money into investing times 50%.
     * 
     * @param deposit amount being deposited
     * @return true.
     */
    @Override
    public boolean deposit(double deposit)
    {
        this.Balance += deposit * 0.5 + deposit;
        this.Deposit = deposit;
        return true;
    }
    
    /**
     * Investing account information.
     * @return the values to string.
     */
    @Override
    public String toString() 
    {
        return AccountNo + "          $" + Interest + "        $" + Deposit
                + "         $" + Withdraw
                + "        $" + Balance;
    }
}
