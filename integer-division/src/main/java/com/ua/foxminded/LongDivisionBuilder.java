package com.ua.foxminded;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ua.foxminded.exceptions.DivisionByZeroException;
import com.ua.foxminded.helpers.LDBuilderHelper;

/**
 * 
 * @version 1.0 16 May 2020
 * @author Konstantyn Verdysh
 */
class LongDivisionBuilder {
    private long dividend;
    private long divisor;
    public LongDivisionBuilder(long dividend, long divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }
    /**
     * Method generateIntegerDivisonNumbers generate array of numbers for Integer division
     * Example: _12|2
     *           12|-
     *           --|6
     *            0
     * On this structure dividend is 12 and divisor is 2.
     * Method may return array {12, 12, 0, 2, 6}
     * Last two indecies of array is divisor and result of division.
     * 
     * @return generated array of numbers for Integer division
     */
    public Long[] build() {
        if (divisor < 1) {
            throw new DivisionByZeroException("Exception! Divisor must be positive.");
        }
        if (dividend < 1 || dividend < divisor) {
            return new Long[] {dividend, divisor, LDBuilderHelper.divide(dividend, divisor)};
        }
        List<Long> result = new ArrayList<>(Arrays.asList(dividend));
        String dividendStr = String.valueOf(dividend);
        long numberOfDividend = Character.getNumericValue(dividendStr.charAt(0));
        while (true) {
            if (LDBuilderHelper.checkSmaller(numberOfDividend, divisor)) {
                dividendStr = LDBuilderHelper.removeFirstDigit(dividendStr);
                if (dividendStr.equals("")) {
                    break;
                }
                int nextNumberOfDividend = Character.getNumericValue(dividendStr.charAt(0));
                numberOfDividend = LDBuilderHelper.numberMerge(numberOfDividend, nextNumberOfDividend);
            } else {
                if (result.size() > 1) {
                    result.add(numberOfDividend);
                }
                long maxWholeDividend = LDBuilderHelper.getMaxWholeDividend(numberOfDividend, divisor);
                result.add(maxWholeDividend);
                long remainder = numberOfDividend - maxWholeDividend;
                numberOfDividend = remainder;
            }
        }
        long remainder = numberOfDividend;
        result.add(remainder);
        result.add(divisor);
        long resultOfDivision = LDBuilderHelper.divide(dividend, divisor);
        result.add(resultOfDivision);
        return result.toArray(new Long[result.size()]);
    }
}
