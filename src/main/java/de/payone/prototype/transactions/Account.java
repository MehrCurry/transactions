/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import static org.joda.money.CurrencyUnit.EUR;

import java.util.ArrayList;
import java.util.List;

import org.joda.money.Money;

/**
 * @author Guido Zockoll
 * 
 */
@SuppressWarnings("javadoc")
public class Account {
    private final List<AccountEntry> credits = new ArrayList<AccountEntry>();
    private final List<AccountEntry> debits = new ArrayList<AccountEntry>();

    /**
     * @param fromEntry
     */
    public void credit(AccountEntry anEntry) {
        credits.add(anEntry);

    }

    public void credit(Money amount) {
        credits.add(new AccountEntry(amount));
    }

    /**
     * @param toEntry
     */
    public void debit(AccountEntry anEntry) {
        debits.add(anEntry);

    }

    /**
     * @param amount
     */
    public void debit(Money amount) {
        debit(new AccountEntry(amount));

    }

    public Money getBalance() {
        Money balance = Money.zero(EUR);
        for (AccountEntry e : debits) {
            balance = balance.plus(e.getAmount());
        }
        for (AccountEntry e : credits) {
            balance = balance.minus(e.getAmount());
        }
        return balance;
    }
}
