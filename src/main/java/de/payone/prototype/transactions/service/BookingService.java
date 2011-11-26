package de.payone.prototype.transactions.service;

import static org.joda.money.CurrencyUnit.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.payone.prototype.transactions.entity.Account;
import de.payone.prototype.transactions.entity.AccountEntry;

@Service
@Transactional
public class BookingService {
	private static Logger logger = LoggerFactory
			.getLogger(BookingService.class);
	@PersistenceContext
	private EntityManager em;

	public void doSomething() {

		Account account = new Account();
		em.persist(account);
		AccountEntry entry = new AccountEntry(Money.of(EUR, 10));
		account.credit(entry);
		em.persist(account);
	}
}
