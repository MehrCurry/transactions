/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions.entity;

import static org.joda.money.CurrencyUnit.EUR;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Guido Zockoll
 * 
 */
@Entity
public class AccountingTransaction extends AbstractEntity {
	private static Logger logger = LoggerFactory
			.getLogger(AccountingTransaction.class);

	@OneToMany
	private final Collection<Booking> bookings = new ArrayList<Booking>();
	private boolean posted = false;

	@SuppressWarnings("javadoc")
	public AccountingTransaction(Collection<Booking> bookings, DateTime date) {
		assertBalanceIsZero(bookings);
		this.bookings.addAll(bookings);
	}

	/**
	 * Create a new AccountingTransaction.
	 * 
	 * @param d
	 */
	public AccountingTransaction(DateTime d) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	public Money balance() {
		return balance(bookings);
	}

	public boolean canPost() {
		return balance().isZero();
	}

	// public AccountingTransaction inverse(DateTime d) {
	// AccountingTransaction trans = new AccountingTransaction(d);
	// for (Booking b : bookings) {
	// trans.add(b.amount.negated(), b.getAccount(), "Storno: " + b.getText());
	// }
	// return trans;
	// }

	public void post() {
		logger.debug("Posting: " + this);
		Validate.isTrue(!posted, "Transaction already posted!");
		Validate.isTrue(canPost(), "Transaction balance != 0");
		for (Booking b : bookings) {
			b.post();
		}
		posted = true;

	}

	/**
	 * @param bookings2
	 */
	private void assertBalanceIsZero(Collection<Booking> bookings) {
		Validate.isTrue(balance(bookings).isZero(),
				"Transaction must sum up to ZERO!");
	}

	/**
	 * @param someBookings
	 * @param bookings
	 * @return
	 */
	private Money balance(Collection<Booking> someBookings) {
		Money sum = Money.zero(EUR);
		for (Booking b : someBookings) {
			sum = sum.plus(b.getAmount());
		}
		return sum;
	}

	/**
	 * @param creditBooking
	 */
	public void add(Booking b) {
		Validate.isTrue(!posted, "Transaction already posted!");
		bookings.add(b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}
}