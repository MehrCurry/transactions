package de.payone.prototype.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	private static Logger logger = LoggerFactory.getLogger(Launcher.class);;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
            new ClassPathXmlApplicationContext(new String[] { "/data-beans.xml", "/control-beans.xml", "/gui-beans.xml" });
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			logger.error("Init:", e);
		}

	}

}
