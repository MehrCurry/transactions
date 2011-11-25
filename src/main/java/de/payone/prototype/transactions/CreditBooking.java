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
public class CreditBooking extends Booking {
    /**
     * Create a new CreditBooking.
     * 
     * @param account
     * @param amount
     */
    public CreditBooking(Account account, Money amount) {
        super(account, amount);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.payone.prototype.transactions.Booking#getAmount()
     */
    @Override
    public Money getAmount() {
        return super.getAmount().negated();
    }

    @Override
    public void post() {
        account.credit(amount);
    }
}
