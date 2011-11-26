package de.payone.prototype.transactions.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@MappedSuperclass
public class AbstractEntity {
	@Id
	@GeneratedValue
	protected Long id;

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}
}
