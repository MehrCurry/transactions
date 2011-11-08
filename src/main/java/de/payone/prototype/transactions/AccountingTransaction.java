/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import java.util.Collection;
import java.util.HashSet;

import org.joda.money.Money;
import org.joda.time.DateTime;

/**
 * @author Guido Zockoll
 * 
 */
public class AccountingTransaction {
    private final Collection<AccountEntry> entries = new HashSet<AccountEntry>();

    @SuppressWarnings("javadoc")
    public AccountingTransaction(Money amount, Account from, Account to, DateTime date) {
        AccountEntry fromEntry = new AccountEntry(amount, date);
        from.credit(fromEntry);
        entries.add(fromEntry);
        AccountEntry toEntry = new AccountEntry(amount, date);
        to.debit(toEntry);
        entries.add(toEntry.negate());
    }
}