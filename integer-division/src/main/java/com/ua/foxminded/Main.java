package com.ua.foxminded;
import java.util.Scanner;

import com.ua.foxminded.exceptions.DivisionByZeroException;
import com.ua.foxminded.exceptions.MissingPrintValueException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter two numbers to divide:\n(Press Ctrl+C to exit)");
        Scanner scanner = new Scanner(System.in);
        LongDivisionPrinter printer = new LongDivisionPrinter();
        while (true) {
            long dividend = readLongFromConsole(scanner);
            long divisor = readLongFromConsole(scanner);
            try {
                LongDivisionBuilder builder = new LongDivisionBuilder(dividend, divisor);
                printer.print(builder.build());
            } catch (DivisionByZeroException | MissingPrintValueException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("System error");
            }
        }
    }
    public static long readLongFromConsole(Scanner scanner) {
        long result;
        while (true) {
            try {
                String input = scanner.nextLine();
                result = Long.parseLong(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("It's not a number!");
            }
        }
        return result;
    }
}
