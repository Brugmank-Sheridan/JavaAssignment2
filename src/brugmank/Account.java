/*
        Account
        Author: Kyle Brugmans
        Date: 2020-1-28

        Description
        Set's the base parameters for all accounts.
 */
package brugmank;

/**
 * Creates the parameters for all accounts defaults.
 *
 * @author Kyle Brugmans
 */
public abstract class Account
{

    protected String AccountNo;
    protected String CustomerName;
    protected double Balance;
    protected double Withdraw;
    protected double Deposit;
    protected double Interest;

    /**
     * Default Values
     *
     * @param AccountNo The bank account ID number.
     * @param CustomerName The bank holders name.
     * @param Balance Current balance in the account.
     * @param Withdraw Last withdraw amount made.
     * @param Deposit Last deposit amount made.
     * @param Interest Annual percentage for the current balance.
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

    public String getAccountNo()
    {
        return AccountNo;
    }

    /**
     * Sets the bank account ID number.
     *
     * @param AccountNo the users input.
     * @return true if the account number meets prerequisites.
     */
    public boolean setAccountNo(String AccountNo)
    {
        if (AccountNo.matches("[0-9]{2}")) // Format should be "00".
        {
            this.AccountNo = AccountNo;
        } else
        {
            throw new IllegalArgumentException("Must input 2 digits");
        }
        return true;
    }

    public String getCustomerName()
    {
        return this.CustomerName; // Gets the customers name.
    }

    /**
     * Sets the bank holders name to their account.
     *
     * @param CustomerName the users name of choice.
     * @return true if the account name meets prerequisites.
     */
    public boolean setCustomerName(String CustomerName)
    {
        if (CustomerName.matches("^[a-zA-Z ]*$")) // Format example "John Apple"
        {
            this.CustomerName = CustomerName;
        } else
        {
            throw new IllegalArgumentException("Name must not contain number or"
                    + " symbols\n");
        }
        return true;
    }

    public double getBalance()
    {
        return Balance; // Get's the current balance.
    }

    public double getInterest()
    {
        return Interest * 100; // Get's the current interest rate as percentage.
    }

    /**
     * Allows the bank holder to withdraw money from each account.
     * @param withdraw the amount the user chooses to take.
     * @return true if the number is valid.
     */
    public boolean withdraw(double withdraw)
    {
        if (this.Balance - withdraw >= -500 && withdraw >= 0)
        {
            this.Balance -= withdraw;
            this.Withdraw = withdraw;
        } else if (withdraw < 0)
        {
            throw new IllegalArgumentException("Cannot withdraw negative ammount");
        } else
        {
            throw new IllegalArgumentException("Overdraft limit: $500");
        }

        return true;
    }

    /**
     * Allows the bank holder to deposit money from each account.
     * @param deposit the amount the user chooses to take.
     * @return true if the number is valid.
     */
    public boolean deposit(double deposit)
    {
        if (deposit >= 0)
        {
            this.Balance += deposit;
            this.Deposit = deposit;
        } else
        {
            throw new IllegalArgumentException("Cannont deposit a negative "
                    + "number");
        }
        return true;
    }

    /**
     * Set's the annual interest rate to the current balance.
     */
    public void addIntrest()
    {
        this.Balance += Interest * Balance;
        Interest = Balance - 1000;
    }

    /**
     * Prints out the account info border.
     * 
     * @return the values to the string.
     */
    @Override
    public String toString()
    {
        String border
                = "=================================";
        return "\nCustomer: " + CustomerName + "\n"
                + border
                + "\nAccNo.     Interest     Deposit     Withdraw     NewBal.\n"
                + border;
    }

    /**
     * Prints out brief account info.
     * 
     * @return the values to the string.
     */
    public String accountCreationConfirmation()
    {
        return "AccNo. " + getAccountNo() + ": $" + Balance;
    }
}
