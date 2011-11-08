/**
 * Created 28.10.2011
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.payone.prototype.exeptionhandling;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Guido Zockoll
 * 
 */
@SuppressWarnings("javadoc")
public abstract class AbstractExceptionHandler implements ExceptionHandler {
    @SuppressWarnings("unchecked")
    private Collection<Class<Exception>> expected = Collections.EMPTY_LIST;

    /**
     * Create a new AbstractExceptionHandler.
     */
    public AbstractExceptionHandler() {
        // TODO Auto-generated constructor stub
    }

    public AbstractExceptionHandler(Class<Exception>[] expected) {
        this.expected = Arrays.asList(expected);
    }

    /**
     * 
     * @see de.payone.prototype.exeptionhandling.ExceptionHandler#processException(java.lang.Exception)
     */
    public boolean isExpected(Exception ex) {
        return expected.contains(ex.getClass());
    }

    public boolean isUnExpected(Exception ex) {
        return !isExpected(ex);
    }
}
