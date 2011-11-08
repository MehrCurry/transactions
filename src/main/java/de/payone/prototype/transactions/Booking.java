/**
 * Created 08.11.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import org.joda.money.Money;

/**
 * @author Guido Zockoll
 * 
 */
@SuppressWarnings("javadoc")
public abstract class Booking {

    protected Account account;
    protected Money amount;

    /**
     * Create a new Booking.
     * 
     * @param account
     * @param amount
     */
    public Booking(Account account, Money amount) {
        super();
        this.account = account;
        this.amount = amount;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @return the amount
     */
    public Money getAmount() {
        return amount;
    }

    public abstract void post();

}