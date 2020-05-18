package com.ua.foxminded.helpers;

/**
 * 
 * @version 1.0 16 May 2020
 * @author Konstantyn Verdysh
 */
public final class LDBuilderHelper {
    private LDBuilderHelper() {}

    public static long divide(long a, long b) {
        return a / b;
    }
    /**
     * Method getMaxWholeDividend return the max whole divident of first parametr
     * Example: (20, 6) -> 18
     *          (33, 7) -> 28
     *          (150, 12) -> 144
     * 
     * @param long, long
     * @return max whole dividend
     */
    public static long getMaxWholeDividend(long a, long b) {
        return (a / b) * b;
    }
    public static boolean checkSmaller(long a, long b) {
        return a < b;
    }
    /**
     * Method numberMerge merge two input numbers
     * Example: (12, 3) -> 123
     *          (35, 6) -> 356
     * 
     * @param long, long
     * @return merged number
     */
    public static long numberMerge(long a, long b) {
        return Long.parseLong(String.valueOf(a) + String.valueOf(b));
    }
    /**
     * Method removeFirstIndex remove first index of input string.
     * 
     * @return string with removed first index or "" if input length is 0
     */
    public static String removeFirstDigit(String dividendUnit) {
        if (dividendUnit.length() > 0) {
            dividendUnit = dividendUnit.substring(1);
            return dividendUnit;
        }
        return "";
    }
}
