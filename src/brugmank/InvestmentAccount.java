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
public class InvestmentAccount extends SavingsAccount {

    public InvestmentAccount(String AccountNo, String CustomerName,
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
    
    public  InvestmentAccount()
    {
        super(null, null, 0, 0, 0, 0.03, 0);
    }
    
    @Override
    public boolean setAccountNo(String AccountNo)
    {
       this.AccountNo = "3" + AccountNo;
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
        return true;
    }
}
