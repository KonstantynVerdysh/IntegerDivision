package com.ua.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ua.foxminded.exceptions.DivisionByZeroException;

/**
 * @author Konstantyn Verdysh
 *
 */
class LongDivisionBuilderTest {
    /**
     * Test method for {@link IntegerDivision#build()}.
     */
    @Test
    public void builder_returnArrayOfDivisionNumberWhenInputIsIntegers() {
        LongDivisionBuilder builder = new LongDivisionBuilder(78945, 4);
        Long[] expected = {78945L, 4L, 38L, 36L, 29L, 28L, 14L, 12L, 25L, 24L, 1L, 4L, 19736L};
        Long[] actual = builder.build();
        assertArrayEquals(expected, actual);
    }
    /**
     * Test method for {@link IntegerDivision#build()}.
     */
    @ParameterizedTest
    @CsvSource(value = {"0,0", "3,0", "155,0"})
    public void builder_throwExceptionWhenSecondInputIsZero(long input1, long input2) {
        LongDivisionBuilder builder = new LongDivisionBuilder(input1, input2);
        DivisionByZeroException myException = assertThrows(DivisionByZeroException.class, 
                () -> builder.build());
        assertTrue(myException.getMessage().contains("Exception! Divisor must be positive."));
    }
    /**
     * Test method for {@link IntegerDivision#build()}.
     */
    @Test
    public void builder_returnArrayOfDivisionNumberWhenFirstInputIsZero() {
        LongDivisionBuilder builder = new LongDivisionBuilder(0L, 4L);
        Long[] expected = {0L, 4L, 0L};
        Long[] actual = builder.build();
        assertArrayEquals(expected, actual);
    }
    /**
     * Test method for {@link IntegerDivision#build()}.
     */
    @Test
    public void builder_returnArrayOfDivisionNumberWhen() {
        LongDivisionBuilder builder = new LongDivisionBuilder(-12, 4);
        Long[] expected = {-12L, 4L, -3L};
        Long[] actual = builder.build();
        assertArrayEquals(expected, actual);
    }
    /**
     * Test method for {@link IntegerDivision#build()}.
     */
    @Test
    public void builder_returnArrayOfDivisionWhenInputsAreLongsMaxValues() {
        LongDivisionBuilder builder = new LongDivisionBuilder(Long.MAX_VALUE, Long.MAX_VALUE);
        Long[] expected = {9223372036854775807L, 9223372036854775807L, 0L, 9223372036854775807L, 1L};
        Long[] actual = builder.build();
        assertArrayEquals(expected, actual);
    }
}
