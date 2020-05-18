package com.ua.foxminded.helpers;
import java.util.Arrays;

/**
 * 
 * @version 1.0 16 May 2020
 * @author Konstantyn Verdysh
 */
public final class LDPrinterHelper {
    private LDPrinterHelper() {}

    public static String deleteUnderLine(String num) {
        return num.replace("_", "");
    }

    /**
     * Method checkBiggerString remove all non-number symbols, cut first input
     * by second input length and return true if value of number in second input 
     * bigger than value of first input.
     *            ...   ...
     * Example: (_1345, 135) -> true
     *            .   .
     *          (_11, 7) -> true
     *            ..    ..
     *          (_9150, 12) -> false
     * 
     * @param string, string
     * @return true if value of second bigger than value of first
     */
    public static boolean checkBiggerString(String s1, String s2) {
        String ss2 = s2.replaceAll("\\D", "");
        String ss1 = s1.replaceAll("\\D", "").substring(0, ss2.length());
        return Long.parseLong(ss1) < Long.parseLong(ss2);
    }

    /**
     * Method checkBiggerString remove all non-number symbols, cut first input
     * by second input length and return true if values are same.
     *            ...   ...
     * Example: (_1359, 135) -> true
     *            .   .
     *          (_11, 7) -> false
     *            ..    ..
     *          (_1250, 12) -> true
     * 
     * @param string, string
     * @return true if values are same
     */
    public static boolean checkEqualString(String s1, String s2) {
        String ss2 = s2.replaceAll("\\D", "");
        String ss1 = s1.replaceAll("\\D", "").substring(0, ss2.length());
        return ss1.equals(ss2);
    }

    public static String[] getSubArray(String[] array, int begin, int end) {
        return Arrays.copyOfRange(array, begin, end + 1);
    }

    /**
     * Method createLineOfSymbol generate string of symbols where length is 
     * first input and value is the second.
     * 
     * @param int, string
     * @return created string of symbol
     */
    public static String createLineOfSymbol(int amount, String symbol) {
        StringBuilder result = new StringBuilder(amount);
        for (int count = 0; count < amount; count++) {
            result.append(symbol);
        }
        return result.toString(); 
    }
}
