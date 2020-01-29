/*
        SavingsAccount
        Author: Kyle Brugmans
        Date: 2020-1-27

        Description:
        Holds a balance for savings, while applying a yearly rate.
    */

package brugmank;

/**
 *
 * @author katarn
 */
public class SavingsAccount extends Account {

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
     *
     * @param AccountNo
     * @return
     */
    @Override
    public boolean setAccountNo(String AccountNo)
    {
       this.AccountNo = "2" + AccountNo;
       return true;
    }

    /**
     *
     * @param Interest
     * @return
     */
    @Override
    public boolean setInterest(double Interest)
    {
        return super.setInterest(Interest); //To change body of generated methods, choose Tools | Templates.
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
