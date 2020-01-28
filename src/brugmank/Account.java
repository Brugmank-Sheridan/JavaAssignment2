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

    public Account(String AccountNo, String CustomerName, double Balance,
            double Withdraw, double Deposit, double Interest)
    {
        this.AccountNo = "000";
        this.CustomerName = "Unknown";
        this.Balance = 1000;
        this.Withdraw = Withdraw;
        this.Deposit = Deposit;
        this.Interest = Interest;
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
    
    public boolean withdraw(double withdraw)
    {
        if (this.Balance - withdraw >= -500 && withdraw >= 0)
        {
            this.Balance -= withdraw;
            this.Withdraw = withdraw;
        }
        else if (withdraw < 0)
        {
            throw new IllegalArgumentException
            ("Cannot withdraw negative ammount");
        }
        else
        {
            throw new IllegalArgumentException("Overdraft limit: $500");
        }
            
        return true;
    }
    
    public boolean deposit(double deposit)
    {
        if (deposit >= 0)
        {
            this.Balance += deposit;
            this.Deposit = deposit;
        }
        else
        {
            throw new IllegalArgumentException("Cannont deposit a negative "
                    + "number");
        }
        return true;
    }
    
    public boolean addIntrest()
    {
        this.Balance += Interest * Balance;
        Interest = Balance - 1000;
        return true;
    }

    @Override
    public String toString()
    {
        String border = 
                "========================================================";
        return "\nCustomer: " + CustomerName + "\n" +
                border 
                + "\nAccNo.     Interest     Deposit     Withdraw     NewBal.\n"
                + border;
    }
}
