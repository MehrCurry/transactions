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