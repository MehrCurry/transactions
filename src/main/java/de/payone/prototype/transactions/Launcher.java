package de.payone.prototype.transactions;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.payone.prototype.transactions.service.BookingService;

public class Launcher {

	private static Logger logger = LoggerFactory.getLogger(Launcher.class);;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "/data-beans.xml", "/control-beans.xml",
							"/gui-beans.xml" });
			BookingService service = (BookingService) context
					.getBean("bookingService");
			Validate.notNull(service);
			service.doSomething();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			logger.error("Init:", e);
		}

	}

}
