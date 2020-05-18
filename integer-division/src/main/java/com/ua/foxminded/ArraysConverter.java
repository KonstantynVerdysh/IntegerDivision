package com.ua.foxminded;

/**
 * 
 * @version 1.0 16 May 2020
 * @author Konstantyn Verdysh
 */
public final class ArraysConverter {
    private ArraysConverter() {}

    /**
     * Method convertToStringArray convert input array to string array
     * 
     * @param input array
     * @return converted string array
     */
    public static <T> String[] convertToStringArray(T[] array) {
        String[] result = new String[array.length];
        for (int count = 0; count < array.length; count++) {
            result[count] = String.valueOf(array[count]);
        }
        return result;
    }
}
