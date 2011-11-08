/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import static org.joda.money.CurrencyUnit.EUR;

import java.util.Collection;

import org.apache.commons.lang.Validate;
import org.joda.money.Money;
import org.joda.time.DateTime;

/**
 * @author Guido Zockoll
 * 
 */
public class AccountingTransaction {
    private final Collection<Booking> bookings;

    @SuppressWarnings("javadoc")
    public AccountingTransaction(Collection<Booking> bookings, DateTime date) {
        assertBookingsSumUpToZero(bookings);
        this.bookings = bookings;
    }

    public void post() {
        assertBookingsSumUpToZero(bookings);
        for (Booking b : bookings) {
            b.post();
        }

    }

    /**
     * @param bookings
     */
    private void assertBookingsSumUpToZero(Collection<Booking> bookings) {
        Money sum = Money.zero(EUR);
        for (Booking b : bookings) {
            sum = sum.plus(b.getAmount());
        }
        Validate.isTrue(Money.zero(EUR).equals(sum), "Transaction must sum up to ZERO!");
    }
}