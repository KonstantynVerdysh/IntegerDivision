package com.ua.foxminded;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ua.foxminded.exceptions.MissingPrintValueException;
import com.ua.foxminded.helpers.LDPrinterHelper;

/**
 * Class IntegerDivisionStrings get an array of numbers to constructor
 * than convert it to string array and print like Integer Division.
 * Example: {12, 12, 0, 2, 6}  to  _12|2
 *                                  12|-
 *                                  --|6
 *                                   0
 * 			  
 * @version 1.0 16 May 2020
 * @author Konstantyn Verdysh
 */
class LongDivisionPrinter {
    private static final String UNDERSCORE = "_";
    private static final String VERTICAL_LINE = "|";
    private static final String DASH = "-";
    private static final String SPACE = " ";
    private static final int DIVIDEND_INDEX = 0;
    private static final int NUMBER_UNDER_DIVIDEND_INDEX = 1;
    private static final int DASH_UNDER_SECOND_NUMBER_INDEX = 2;
    private static final int DIVISOR_INDEX = 0;
    private static final int RESULT_INDEX = 1;
    private static final int MINIMUM_VALUES_FOR_PRINT = 5;
    private static final int MINIMUM_VALUES_FOR_SIMPLE_PRINT = 3;

    public <T> void print(T[] divisionNumbers) {
        String[] divisionStrings = ArraysConverter.convertToStringArray(divisionNumbers);
        final int leftSideDivisionIndex = divisionStrings.length - 2;
        final int rightSideDivisionIndex = divisionStrings.length - 3;
        if (divisionNumbers.length >= MINIMUM_VALUES_FOR_SIMPLE_PRINT) {
            String[] leftSideDivision = LDPrinterHelper.getSubArray(divisionStrings, 0, rightSideDivisionIndex);
            String[] rightSideDivision = LDPrinterHelper.getSubArray(divisionStrings, leftSideDivisionIndex, divisionStrings.length - 1);
            if (divisionNumbers.length >= MINIMUM_VALUES_FOR_PRINT) {
                addUnderLinesBeforeLeftSideDivision(leftSideDivision, rightSideDivision);
            }
            else if (divisionNumbers.length >= MINIMUM_VALUES_FOR_SIMPLE_PRINT) {
                addSimpleDivision(leftSideDivision, rightSideDivision);
            }
        } else {
            throw new MissingPrintValueException("Not enough values for print division!");
        }
    }

    private void addSimpleDivision(String[] leftSideDivision, String[] rightSideDivision) {
        printArray(new String[] {String.format("%s ÷ %s = %s", leftSideDivision[DIVIDEND_INDEX], rightSideDivision[DIVISOR_INDEX], rightSideDivision[RESULT_INDEX])});
    }

    private void addUnderLinesBeforeLeftSideDivision(String[] leftSideDivision, String[] rightSideDivision) {
        for (int count = 0; count < leftSideDivision.length - 1; count++) {
            if (count % 2 == 0) {
                leftSideDivision[count] = String.format("%s%s", UNDERSCORE, leftSideDivision[count]);
            }
        }
        addDashesBetweenNumbersOfLeftSideDivision(leftSideDivision, rightSideDivision);
    }

    private void addDashesBetweenNumbersOfLeftSideDivision(String[] leftSideDivision, String[] rightSideDivision) {
        List<String> leftSideDivisionList = new ArrayList<>(Arrays.asList(leftSideDivision));
        for (int count = 1; count < leftSideDivisionList.size(); count++) {
            if (count % 3 == 2) {
                int lengthOfPreviousNumber = leftSideDivisionList.get(count - 1).length();
                leftSideDivisionList.add(count, LDPrinterHelper.createLineOfSymbol(lengthOfPreviousNumber, DASH));
            }
        }
        leftSideDivision = leftSideDivisionList.toArray(new String[leftSideDivisionList.size()]);
        addSpacesBeforeLeftSideDivision(leftSideDivision, rightSideDivision);
    }

    private void addSpacesBeforeLeftSideDivision(String[] leftSideDivision, String[] rightSideDivision) {
        for (int count = NUMBER_UNDER_DIVIDEND_INDEX; count <= DASH_UNDER_SECOND_NUMBER_INDEX; count++) {
            if (LDPrinterHelper.checkBiggerString(leftSideDivision[DIVIDEND_INDEX], leftSideDivision[NUMBER_UNDER_DIVIDEND_INDEX])) {
                leftSideDivision[count] = LDPrinterHelper.createLineOfSymbol(2, SPACE) + leftSideDivision[count];
            } else {
                leftSideDivision[count] = SPACE + leftSideDivision[count];
            }
        }
        int maxStringLength = leftSideDivision[DIVIDEND_INDEX].length();
        int currentStringLength = leftSideDivision[NUMBER_UNDER_DIVIDEND_INDEX].length();
        for (int count = 3; count < leftSideDivision.length; count++) {
            if (count % 3 == 0 && currentStringLength < maxStringLength && !leftSideDivision[count].equals("0")) {
                if (LDPrinterHelper.checkEqualString(leftSideDivision[count-3], leftSideDivision[count-2])) {
                    currentStringLength += LDPrinterHelper.deleteUnderLine(leftSideDivision[count]).length();
                } else {
                    currentStringLength++;
                }
            }
            leftSideDivision[count] = String.format("%" + currentStringLength + "s", leftSideDivision[count]);
        }
        addRightSideOfDivision(leftSideDivision, rightSideDivision);
    }

    private void addRightSideOfDivision(String[] leftSideDivision, String[] rightSideDivision) {
        int maxStringLength = leftSideDivision[DIVIDEND_INDEX].length();
        String format = "%s%s%s";
        leftSideDivision[DIVIDEND_INDEX] = String.format(format, leftSideDivision[DIVIDEND_INDEX], VERTICAL_LINE, rightSideDivision[DIVISOR_INDEX]);
        leftSideDivision[NUMBER_UNDER_DIVIDEND_INDEX] = String.format(format, leftSideDivision[NUMBER_UNDER_DIVIDEND_INDEX], LDPrinterHelper.createLineOfSymbol(maxStringLength - 
                leftSideDivision[NUMBER_UNDER_DIVIDEND_INDEX].length(), SPACE) + VERTICAL_LINE, LDPrinterHelper.createLineOfSymbol(rightSideDivision[RESULT_INDEX].length(), DASH));
        leftSideDivision[DASH_UNDER_SECOND_NUMBER_INDEX] = String.format(format, leftSideDivision[DASH_UNDER_SECOND_NUMBER_INDEX], LDPrinterHelper.createLineOfSymbol(maxStringLength 
                - leftSideDivision[DASH_UNDER_SECOND_NUMBER_INDEX].length(), SPACE) + VERTICAL_LINE, rightSideDivision[RESULT_INDEX]);
        printArray(leftSideDivision);
    }

    private void printArray(String[] division) {
        for (String str : division) {
            System.out.println(str);
        }
    }
}
