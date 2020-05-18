package com.ua.foxminded.helpers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Konstantyn Verdysh
 *
 */
class LDPrinterHelperTest {
    /**
     * Test method for {@link LDPrinterHelper#deleteUnderLine(java.lang.String)}.
     */
    @Test
    public void deleteUnderLine_deleteUnderlineWhenInputIsStringWithUnderline() {
        String expected = "123";
        String actual = LDPrinterHelper.deleteUnderLine("_123");
        assertEquals(expected, actual);
    }
    /**
     * Test method for {@link LDPrinterHelper#checkBiggerString(java.lang.String, java.lang.String)}.
     */
    @ParameterizedTest
    @CsvSource(value = {"_1133,22", "_223,3", "---88, 9"})
    public void checkBiggerString_returnTrueIfValueOfSecondStringBiggerThanValueOfFirstWhenInputAreStringsWithNumbers(String input1, String input2) {
        assertTrue(LDPrinterHelper.checkBiggerString(input1, input2));
    }
    /**
     * Test method for {@link LDPrinterHelper#checkEqualString(java.lang.String, java.lang.String)}.
     */
    @Test
    public void checkEqualString_returnTrueIfValuesAreSameWhenInputAreStringsWithNumbers() {
        assertTrue(LDPrinterHelper.checkEqualString("_22330", "2233"));
        assertFalse(LDPrinterHelper.checkEqualString("_22330", "2223"));
    }
    /**
     * Test method for {@link LDPrinterHelper#getSubArray(java.lang.String[], int, int)}.
     */
    @Test
    public void getSubArray_returnPartOfArrayWhenInputIsStringArray() {
        String[] input = {"a", "b", "c", "d", "e"};
        String[] expected = {"d", "e"};
        String[] actual = LDPrinterHelper.getSubArray(input, 3, 4);
        assertArrayEquals(expected, actual);
    }
    /**
     * Test method for {@link LDPrinterHelper#createLineOfSymbol(int, java.lang.String)}.
     */
    @ParameterizedTest
    @CsvSource(value = {"4,-,----", "6,' ','      '", "2,!,!!"})
    public void createLineOfSymbol_returnGeneratedStringOfSymbolWhenInputIsNumberAndSymbol(int input1, String input2, String expected) {
        String actual = LDPrinterHelper.createLineOfSymbol(input1, input2);
        assertEquals(expected, actual);
    }
}
