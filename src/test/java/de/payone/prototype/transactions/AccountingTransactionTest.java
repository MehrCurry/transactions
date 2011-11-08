/**
 * Created 08.11.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author Guido Zockoll
 * 
 */
public class AccountingTransactionTest {

    @Test(expected = IllegalArgumentException.class)
    public void bookings_should_sum_up_to_zero() {
        Account from = new Account();
        Account to = new Account();

        Money ten = Money.ofMajor(CurrencyUnit.EUR, 10);
        Money eleven = Money.ofMajor(CurrencyUnit.EUR, 11);

        Booking[] bookings = { new CreditBooking(from, ten), new DebitBooking(to, eleven) };

        AccountingTransaction tx = new AccountingTransaction(Arrays.asList(bookings), DateTime.now());
    }

    /**
     * Test method for
     * {@link de.payone.prototype.transactions.AccountingTransaction#AccountingTransaction(java.util.Collection, org.joda.time.DateTime)}
     * .
     */
    @Test
    public void testAccountingTransaction() {
        Account from = new Account();
        Account to = new Account();

        Money ten = Money.ofMajor(CurrencyUnit.EUR, 10);

        Booking[] bookings = { new CreditBooking(from, ten), new DebitBooking(to, ten) };

        AccountingTransaction tx = new AccountingTransaction(Arrays.asList(bookings), DateTime.now());
        tx.post();
        assertThat(ten, is(to.getBalance()));
        assertThat(ten.negated(), is(from.getBalance()));
    }

}
