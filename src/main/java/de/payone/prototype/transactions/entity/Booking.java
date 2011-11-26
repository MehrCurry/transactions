/**
 * Created 08.11.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

/**
 * @author Guido Zockoll
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuppressWarnings("javadoc")
public abstract class Booking extends AbstractEntity {

	@OneToOne
	protected Account account;
	@Type(type = "de.payone.prototype.transactions.types.MoneyType")
	@Columns(columns = { @Column(name = "amount"), @Column(name = "currency") })
	protected Money amount;
	protected String text = "";

	/**
	 * Create a new Booking.
	 * 
	 * @param account
	 * @param amount
	 */
	public Booking(Account account, Money amount) {
		super();
		this.account = account;
		this.amount = amount;
	}

	/**
	 * Create a new Booking.
	 * 
	 * @param account
	 * @param amount
	 * @param text
	 */
	public Booking(Account account, Money amount, String text) {
		super();
		this.account = account;
		this.amount = amount;
		this.text = text;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @return the amount
	 */
	public Money getAmount() {
		return amount;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	public abstract void post();

}