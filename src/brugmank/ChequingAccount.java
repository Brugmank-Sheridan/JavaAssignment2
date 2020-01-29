/*
        [Class name]
        Author: [the name of the person who created the class. It might be different from yours]
        Date: [date]

        Description
        [Description about the class]
    */

package brugmank;

/**
 *
 * @author katarn
 */
public class ChequingAccount extends Account implements Overdraftable {

    /**
     * 
     * @param AccountNo
     * @param CustomerName
     * @param Balance
     * @param Withdraw
     * @param Deposit
     * @param Interest 
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
        super(null, null, 0, 0, 0, 0.01);
    }

    /**
     *
     * @param AccountNo
     * @return
     */
    @Override
    public boolean setAccountNo(String AccountNo)
    {
       this.AccountNo = "1" + AccountNo;
       return true;
    }
    
    /**
     *
     * @param withdraw
     * @return
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
     *
     * @param ammount
     * @return 
     */
    @Override
    public boolean Overdraft(double ammount)
    {
         if (this.Balance - ammount >= -500)
         {
             this.Balance -= ammount;
         }
         else
         {
             throw new IllegalArgumentException("Overdraft limit: $500");
         }
         return true;
    }    

    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        return AccountNo + "          " + Interest + "        " + Deposit
                + "         " + Withdraw
                + "        " + Balance;
    }
    
    
    
}
