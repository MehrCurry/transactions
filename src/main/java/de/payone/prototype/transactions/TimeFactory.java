/**
 * Created 26.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.transactions;

import org.joda.time.DateTime;

/**
 * @author Guido Zockoll
 * 
 */
public class TimeFactory {

    /**
     * @return
     */
    public static DateTime now() {
        return DateTime.now();
    }

}
