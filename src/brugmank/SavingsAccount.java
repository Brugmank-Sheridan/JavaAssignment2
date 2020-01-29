/*
        SavingsAccount
        Author: Kyle Brugmans
        Date: 2020-1-28

        Description:
        Holds a balance for savings, while applying a yearly rate.
    */

package brugmank;

/**
 * Allows user to manage savings account.
 * 
 * @author Kyle Brugmans
 */
public class SavingsAccount extends Account {

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
    public SavingsAccount(String AccountNo, String CustomerName, double Balance,
            double Withdraw, double Deposit, double Interest)
    {
        super(AccountNo,
                CustomerName,
                Balance,
                Withdraw,
                Deposit,
                Interest);
    }
    
    public SavingsAccount()
    {
        super(null, null, 0, 0, 0, 0.02);
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
       this.AccountNo = "2" + AccountNo;
       return true;
    }
    
    /**
     * Withdraws money from savings.
     * 
     * @param withdraw amount being taken.
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
     * Savings account information.
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
