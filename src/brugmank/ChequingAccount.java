/*
        ChequingAccount
        Author: Kyle Brugmans
        Date: 2020-1-28

        Description
        Holds the information for the users chequing account.
    */

package brugmank;

/**
 * Allows user to manage chequing account.
 * 
 * @author Kyle Brugmans
 */
public class ChequingAccount extends Account implements Overdraftable {

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
    public ChequingAccount(String AccountNo, String CustomerName,
            double Balance, double Withdraw, double Deposit, double Interest)
    {
        super(AccountNo,
                CustomerName,
                Balance,
                Withdraw,
                Deposit,
                Interest);
    }
    
    public ChequingAccount()
    {
        super(null, null, 0, 0, 0, 0.01); // Sets values to default configuration.
    }

    /**
     * Adds account number profile.
     * 
     * @param AccountNo users account number input.
     * @return true.
     */
    @Override
    public boolean setAccountNo(String AccountNo)
    {
       this.AccountNo = "1" + AccountNo;
       return true;
    }
    
    /**
     * Allows user to take money out of their chequing account.
     * 
     * @param withdraw users input withdraw amount.
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
        else
        {
            Overdraft(withdraw);
        }
        return true;
    }
    
    /**
     * Allows withdraw to force balance as low as $500.
     * 
     * @param withdraw users input withdraw amount.
     * @return true.
     */
    @Override
    public boolean Overdraft(double withdraw)
    {
         if (this.Balance - withdraw >= -500)
         {
             this.Balance -= withdraw;
             this.Withdraw = withdraw;
         }
         else
         {
             throw new IllegalArgumentException("Overdraft limit: $500");
         }
         return true;
    }    

    /**
     * Chequing account information.
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
