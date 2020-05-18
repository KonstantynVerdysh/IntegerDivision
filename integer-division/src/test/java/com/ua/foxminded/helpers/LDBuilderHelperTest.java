package com.ua.foxminded.helpers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Konstantyn Verdysh
 *
 */
class LDBuilderHelperTest {
    /**
     * Test method for {@link Division#division(long, long)}.
     */
    @ParameterizedTest
    @CsvSource(value = {"27, 7, 3", "158, 13, 12", "1425, 5, 285"})
    public void divide_returnResultOfDevisionWhenInputAreNumbers(long input1, long input2, long expected) {
        long actual = LDBuilderHelper.divide(input1, input2);
        assertEquals(expected, actual);
    }
    /**
     * Test method for {@link Division#number(long, long)}.
     */
    @ParameterizedTest
    @CsvSource(value = {"27, 7, 21", "158, 13, 156", "1425, 5, 1425", "1326, 426, 1278", "1, 7, 0"})
    public void getMaxWholeDividend_returnMaxWholeDividendWhenInputAreNumbers(long input1, long input2, long expected) {
        long actual = LDBuilderHelper.getMaxWholeDividend(input1, input2);
        assertEquals(expected, actual);
    }
    /**
     * Test method for {@link Division#checkSmaller(long, long)}.
     */
    @ParameterizedTest
    @CsvSource(value = {"27, 7, false", "158, 13, false", "1, 5, true", "1, 1, false"})
    public void checkSmaller_returnTrueIfFirstInputIsSmallerThanSecondWhenInputAreNumbers(long input1, long input2, boolean expected) {
        boolean actual = LDBuilderHelper.checkSmaller(input1, input2);
        assertEquals(expected, actual);
    }
    /**
     * Test method for {@link Division#numberMerge(long, long)}.
     */
    @ParameterizedTest
    @CsvSource(value = {"27, 7, 277", "158, 13, 15813", "1425, 5, 14255"})
    public void numberMerge_returnMergedNumbersWhenInputAreNumbers(long input1, long input2, long expected) {
        long actual = LDBuilderHelper.numberMerge(input1, input2);
        assertEquals(expected, actual);
    }
}
