package com.ua.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Konstantyn Verdysh
 *
 */
class ArraysConverterTest {
    /**
     * Test method for {@link ArraysConverter#convertToStringArray(T[])}.
     */
    @Test
    public void convertToStringArray_returnArrayOfStringWhenInputIsArrayOfNumbers() {
        Long[] input = {1L, 2L, 3L};
        String[] expected = {"1", "2", "3"};
        String[] actual = ArraysConverter.convertToStringArray(input);
        assertArrayEquals(expected, actual);
    }
}
