package com.ua.foxminded.exceptions;

/**
 * 
 * @version 1.0 16 May 2020
 * @author Konstantyn Verdysh
 */
public class MissingPrintValueException extends ArrayIndexOutOfBoundsException {
    public MissingPrintValueException(String s) {
        super(s);
    }
}
