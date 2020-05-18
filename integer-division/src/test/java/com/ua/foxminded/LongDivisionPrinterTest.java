package com.ua.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ua.foxminded.exceptions.MissingPrintValueException;

/**
 * @author Konstantyn Verdysh
 *
 */
class LongDivisionPrinterTest {
    private LongDivisionPrinter printer = new LongDivisionPrinter();
    private ByteArrayOutputStream actual = new ByteArrayOutputStream();
    private ByteArrayOutputStream expected = new ByteArrayOutputStream();
    
    @BeforeEach
    public void resetOutput() {
        System.setOut(new PrintStream(expected));
        actual.reset();
        expected.reset();
    }
    /**
     * Test method for {@link LongDivisionPrinter#printIntegerDivisionStrings()}.
     */
    @Test
    public void printer_printDivisionWhenReceivedArrayIsTrueIntegerDivisonNumbers() {
        String[] output = new String[]{"_78945|4", 
                                       " 4    |-----", 
                                       " -    |19736", 
                                       "_38", 
                                       " 36", 
                                       " --", 
                                       " _29", 
                                       "  28", 
                                       "  --", 
                                       "  _14", 
                                       "   12", 
                                       "   --", 
                                       "   _25", 
                                       "    24", 
                                       "    --", 
                                       "     1"};
        for (String s : output)
            System.out.println(s);
        System.setOut(new PrintStream(actual));
        printer.print(ArraysConverter.convertToStringArray(new Integer[] {78945, 4, 38, 36, 29, 28, 14, 12, 25, 24, 1, 4, 19736}));
        assertEquals(expected.toString(), actual.toString());
    }
    /**
     * Test method for {@link LongDivisionPrinter#printIntegerDivisionStrings()}.
     */
    @Test
    public void printer_printDivisionWhenQuotientOfDivisionIsZero() {
        String[] output = new String[]{"_15|5", 
                                       " 15|-", 
                                       " --|3", 
                                       "  0"};
        for (String s : output)
            System.out.println(s);
        System.setOut(new PrintStream(actual));
        printer.print(ArraysConverter.convertToStringArray(new Integer[] {15, 15, 0, 5, 3}));
        assertEquals(expected.toString(), actual.toString());
    }
    /**
     * Test method for {@link LongDivisionPrinter#printIntegerDivisionStrings()}.
     */
    @Test
    public void printer_printDivisionWhenDividendAndDivisorAreSame() {
        String[] output = new String[]{"_15|15", 
                                       " 15|-", 
                                       " --|1", 
                                       "  0"};
        for (String s : output)
            System.out.println(s);
        System.setOut(new PrintStream(actual));
        printer.print(ArraysConverter.convertToStringArray(new Integer[] {15, 15, 0, 15, 1}));
        assertEquals(expected.toString(), actual.toString());
    }
    /**
     * Test method for {@link LongDivisionPrinter#printIntegerDivisionStrings()}.
     */
    @Test
    public void printer_printSimpleDivisionWhenDividendSmallerThanDivisor() {
        String[] output = new String[]{"13 ÷ 14 = 0"};
        for (String s : output)
            System.out.println(s);
        System.setOut(new PrintStream(actual));
        printer.print(ArraysConverter.convertToStringArray(new Integer[] {13, 14, 0}));
        assertEquals(expected.toString(), actual.toString());
    }
    /**
     * Test method for {@link LongDivisionPrinter#printIntegerDivisionStrings()}.
     */
    @Test
    public void printer_printSimpleDivisionWhenDividendIsNegative() {
        String[] output = new String[]{"-15 ÷ 5 = -3"};
        for (String s : output)
            System.out.println(s);
        System.setOut(new PrintStream(actual));
        printer.print(ArraysConverter.convertToStringArray(new Integer[] {-15, 5, -3}));
        assertEquals(expected.toString(), actual.toString());
    }
    /**
     * Test method for {@link LongDivisionPrinter#printIntegerDivisionStrings()}.
     */
    @Test
    public void printer_throwExceptionWhenInputLengthSmallerThanThreeValues() {
        MissingPrintValueException myException = assertThrows(MissingPrintValueException.class, 
                () -> printer.print(ArraysConverter.convertToStringArray(new Integer[] {1, 2})));
        assertTrue(myException.getMessage().contains("Not enough values for print division!"));
    }
    
    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
