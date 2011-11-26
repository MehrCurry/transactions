/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions.entity;

import static org.joda.money.CurrencyUnit.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Guido Zockoll
 * 
 */
@SuppressWarnings("javadoc")
@Entity
public class Account extends AbstractEntity {
	private static final Logger logger = LoggerFactory.getLogger(Account.class);
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ACCOUNTS_CREDITS")
	private final List<AccountEntry> credits = new ArrayList<AccountEntry>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ACCOUNTS_DEBITS")
	private final List<AccountEntry> debits = new ArrayList<AccountEntry>();

	/**
	 * @param fromEntry
	 */
	public void credit(AccountEntry anEntry) {
		credits.add(anEntry);

	}

	public void credit(Money amount) {
		credits.add(new AccountEntry(amount));
		logger.debug("Credit: " + toString());
	}

	/**
	 * @param toEntry
	 */
	public void debit(AccountEntry anEntry) {
		debits.add(anEntry);
		logger.debug("Debit: " + toString());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this) + "Balance: " + getBalance();
	}
}
