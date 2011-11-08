/**
 * Created 08.11.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

/**
 * @author Guido Zockoll
 * 
 */
public class DebitBooking extends Booking {

    @Override
    public void post() {
        account.debit(amount);
    }
}
