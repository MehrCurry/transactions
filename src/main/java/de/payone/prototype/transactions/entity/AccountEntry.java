/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.Money;
import org.joda.time.DateTime;

import de.payone.prototype.transactions.TimeFactory;

/**
 * @author Guido Zockoll
 * 
 */
@Entity
public class AccountEntry extends AbstractEntity {
	@Type(type = "de.payone.prototype.transactions.types.MoneyType")
	@Columns(columns = { @Column(name = "amount"), @Column(name = "currency") })
	private final Money amount;
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
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
