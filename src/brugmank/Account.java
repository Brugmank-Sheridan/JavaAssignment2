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
public abstract class Account {
    
    protected String AccountNo;
    protected String CustomerName;
    protected double Balance;
    protected double Withdraw;
    protected double Deposit;
    protected double Interest;
    protected double AnnualRate;

    public Account(String AccountNo, String CustomerName, double Balance,
            double Withdraw, double Deposit, double Interest, double AnnualRate)
    {
        this.AccountNo = "000";
        this.CustomerName = "Unknown";
        this.Balance = 1000;
        this.Withdraw = Withdraw;
        this.Deposit = Deposit;
        this.Interest = Interest;
        this.AnnualRate = this.Interest * this.Balance + this.Balance;
    }

    public String getAccountNo()
    {
        return AccountNo;
    }

    public boolean setAccountNo(String AccountNo)
    {
        if (AccountNo.matches("[0-9]{2}"))
        {
            this.AccountNo = AccountNo;
        }
        else
        {
            throw new IllegalArgumentException("Must input 2 digits");
        }
        return true;
    }

    public String getCustomerName()
    {
        return this.CustomerName;
    }

    public boolean setCustomerName(String CustomerName)
    {
        if (CustomerName.matches("^[a-zA-Z ]*$"))
        { 
            this.CustomerName = CustomerName;
        }
        else
        {
            throw new IllegalArgumentException("Name must not contain number or"
                    + " symbols\n");
        }
        return true;
    }

    public double getBalance()
    {
        return Balance;
    }

    public void setBalance(double Balance)
    {
        this.Balance = Balance;
    }

    public double getWithdraw()
    {
        return Withdraw;
    }

    public void setWithdraw(double Withdraw)
    {
        this.Withdraw = Withdraw;
    }

    public double getDeposit()
    {
        return Deposit;
    }

    public void setDeposit(double Deposit)
    {
        this.Deposit = Deposit;
    }

    public double getInterest()
    {
        return Interest;
    }

    public boolean setInterest(double Interest)
    {
        this.Interest = Interest;
        return true;
    }

    public double getAnnualRate()
    {
        return AnnualRate;
    }

    public void setAnnualRate(double AnnualRate)
    {
        this.AnnualRate = AnnualRate;
    }
    
    public boolean withdraw(double withdraw)
    {
        if (withdraw >= this.Balance - 500)
        {
            this.Balance -= withdraw;
        }
        else
        {
            throw new IllegalArgumentException("Overdraft limit: $500");
        }
            
        return true;
    }
    
    

}
