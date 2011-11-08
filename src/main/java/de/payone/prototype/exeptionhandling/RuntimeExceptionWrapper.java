/**
 * Created 28.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.exeptionhandling;

/**
 * @author Guido Zockoll
 * 
 */
public class RuntimeExceptionWrapper extends AbstractExceptionHandler {

    /*
     * (non-Javadoc)
     * 
     * @see de.payone.prototype.exeptionhandling.ExceptionHandler#processException(java.lang.Exception)
     */
    public Object processException(Exception ex) {
        if (isUnExpected(ex))
            throw new RuntimeException(ex);
        else
            return null;
    }

}
