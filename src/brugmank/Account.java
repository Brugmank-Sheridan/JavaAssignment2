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

    
    /**
     * 
     * @param AccountNo
     * @param CustomerName
     * @param Balance
     * @param Withdraw
     * @param Deposit
     * @param Interest 
     */
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

    /**
     * 
     * @return 
     */
    public String getAccountNo()
    {
        return AccountNo;
    }

    /**
     * 
     * @param AccountNo
     * @return 
     */
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

    /**
     * 
     * @return 
     */
    public String getCustomerName()
    {
        return this.CustomerName;
    }

    /**
     * 
     * @param CustomerName
     * @return 
     */
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

    /**
     * 
     * @return 
     */
    public double getBalance()
    {
        return Balance;
    }

    /**
     * 
     * @param Balance 
     */
    public void setBalance(double Balance)
    {
        this.Balance = Balance;
    }

    /**
     * 
     * @return 
     */
    public double getWithdraw()
    {
        return Withdraw;
    }

    /**
     * 
     * @param Withdraw 
     */
    public void setWithdraw(double Withdraw)
    {
        this.Withdraw = Withdraw;
    }

    /**
     * 
     * @return 
     */
    public double getDeposit()
    {
        return Deposit;
    }

    /**
     * 
     * @param Deposit 
     */
    public void setDeposit(double Deposit)
    {
        this.Deposit = Deposit;
    }

    /**
     * 
     * @return 
     */
    public double getInterest()
    {
        return Interest;
    }

    /**
     * 
     * @param Interest
     * @return 
     */
    public boolean setInterest(double Interest)
    {
        this.Interest = Interest;
        return true;
    }
    
    /**
     * 
     * @param withdraw
     * @return 
     */
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
    
    /**
     * 
     * @param deposit
     * @return 
     */
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
    
    /**
     * 
     * @return 
     */
    public boolean addIntrest()
    {
        this.Balance += Interest * Balance;
        Interest = Balance - 1000;
        return true;
    }

    /**
     * 
     * @return 
     */
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
    
    /**
     * 
     * @return 
     */
    public String accountCreationConfirmation()
    {
        return "AccNo. " + getAccountNo() +  ": $" + Balance;
    }
}