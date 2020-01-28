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

    public ChequingAccount(String AccountNo, String CustomerName,
            double Balance, double Withdraw, double Deposit, double Interest,
            double AnnualRate)
    {
        super(AccountNo,
                CustomerName,
                Balance,
                Withdraw,
                Deposit,
                Interest,
                AnnualRate);
    }
    
    public ChequingAccount()
    {
        super(null, null, 0, 0, 0, 0.01, 0);
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
         if (ammount <= this.Balance + 500)
         {
             this.Balance -= ammount;
         }
         else
         {
             throw new IllegalArgumentException("Overdraft limit: $500");
         }
         return true;
    }    
}
