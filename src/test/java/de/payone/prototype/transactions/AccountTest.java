/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import static org.hamcrest.core.Is.is;
import static org.joda.money.CurrencyUnit.EUR;
import static org.junit.Assert.assertThat;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Guido Zockoll
 * 
 */
@SuppressWarnings("javadoc")
public class AccountTest {
    private static final Money ZERO = org.joda.money.Money.zero(CurrencyUnit.EUR);
    private Account cut;

    @Test
    public void new_account_should_have_a_zero_balacne() {
        assertThat(cut.getBalance().equals(ZERO), is(true));
    }

    @Before
    public void setUp() {
        cut = new Account();
    }

    /**
     * Test method for {@link de.payone.prototype.transactions.Account#getBalance()}.
     */
    @Test
    public void testGetBalance() {
        Money ten = Money.ofMajor(EUR, 10);
        cut.debit(ten);
        assertThat(cut.getBalance().equals(ten), is(true));
        cut.debit(ten);
        cut.credit(ten);
        assertThat(cut.getBalance().equals(ten), is(true));
        cut.credit(ten);
        assertThat(cut.getBalance().equals(ZERO), is(true));
    }
}
