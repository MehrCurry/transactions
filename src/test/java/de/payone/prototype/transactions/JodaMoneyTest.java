/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

/**
 * @author Guido Zockoll
 * 
 */
@SuppressWarnings("javadoc")
public class JodaMoneyTest {
    private static final CurrencyUnit euros = CurrencyUnit.EUR;

    @Test
    public void test() {
        Money moneyCents = Money.ofMinor(euros, 100);
        Money moneyEuros = Money.ofMajor(euros, 1);
        System.out.println(moneyCents);
        System.out.println(moneyEuros);
        assertThat(moneyCents, is(moneyEuros));
    }
}
