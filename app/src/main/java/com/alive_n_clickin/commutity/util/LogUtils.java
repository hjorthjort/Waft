package com.alive_n_clickin.commutity.util;

/**
 * @author hjorthjort
 *         Created 22/09/15
 * Instead of generating Android log tags in every class that does logging, this class can be used.
 * Simply pass yourself (the current object) to the method of this class, and a suitable string will
 * be returned.
 *
 * @since 0.1
 */
public class LogUtils {

    /**
     * Generates a log tag based on the class name
     *
     * @param caller the object that requests the tag
     * @return the simple name of the class, e.g. "Integer" if the caller parameter is an Integer object.
     */
    public static String getLogTag(Object caller) {
        return caller.getClass().getSimpleName();
    }
}