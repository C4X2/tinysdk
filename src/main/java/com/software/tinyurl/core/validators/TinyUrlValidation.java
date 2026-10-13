package com.software.tinyurl.core.validators;

import java.util.function.Predicate;

public interface TinyUrlValidation<V, E extends Exception> extends Predicate<V> {

    /**
     * Tests the given value v against a predicate condition throwing the Exception of type E if not found
     * @return true if the condition matches, else thrown an exception
     * @throws E
     */
    public boolean testThrow(V v, E exception) throws E;
}
