package de.payone.prototype.transactions.service;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.payone.prototype.transactions.entity.Account;
import de.payone.prototype.transactions.entity.AccountingTransaction;
import de.payone.prototype.transactions.entity.Booking;
import de.payone.prototype.transactions.entity.CreditBooking;
import de.payone.prototype.transactions.entity.DebitBooking;

@Service
@Transactional
public class BookingService {
	private static Logger logger = LoggerFactory
			.getLogger(BookingService.class);
	@PersistenceContext
	private EntityManager em;

	public void doSomething() {

		Account from = new Account();
		em.persist(from);
		Account to = new Account();
		em.persist(to);

		Money ten = Money.ofMajor(CurrencyUnit.EUR, 10);

		Booking[] bookings = { new CreditBooking(from, ten),
				new DebitBooking(to, ten) };

		AccountingTransaction tx = new AccountingTransaction(
				Arrays.asList(bookings), DateTime.now());
		em.persist(tx);
		tx.post();
	}
}
