/*
        Overdraftable
        Author: Kyle Brugmans
        Date: 2020-1-28

        Description
        Adds overdraft interface.
    */

package brugmank;

/**
 * Creates overdraft for chequing account.
 * 
 * @author Kyle Brugmans
 */
public interface Overdraftable {

    public boolean Overdraft(double ammount);
    
}
