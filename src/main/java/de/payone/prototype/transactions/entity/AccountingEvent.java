package de.payone.prototype.transactions.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class AccountingEvent extends AbstractEntity {
	@OneToOne
	private Subject subject;

	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime whenOccured;

	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime whenNoticed;

}
