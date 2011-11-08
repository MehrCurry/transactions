/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import org.joda.money.Money;
import org.joda.time.DateTime;

/**
 * @author Guido Zockoll
 * 
 */
public class AccountEntry {
    private final Money amount;
    private DateTime bookingDate = TimeFactory.now();

    /**
     * Create a new AccountEntry.
     * 
     * @param value
     */
    public AccountEntry(Money amount) {
        super();
        this.amount = amount;
    }

    /**
     * Create a new AccountEntry.
     * 
     * @param amount2
     * @param date
     */
    public AccountEntry(Money amount, DateTime date) {
        super();
        this.amount = amount;
        this.bookingDate = date;
    }

    /**
     * @return
     */
    public Money getAmount() {
        return amount;
    }

    /**
     * @return
     */
    public AccountEntry negate() {
        return new AccountEntry(amount.negated());
    }

}
