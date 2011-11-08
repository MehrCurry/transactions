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
public class DebitBooking extends Booking {

    /**
     * Create a new DebitBooking.
     * 
     * @param account
     * @param amount
     */
    public DebitBooking(Account account, Money amount) {
        super(account, amount);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void post() {
        account.debit(amount);
    }
}
