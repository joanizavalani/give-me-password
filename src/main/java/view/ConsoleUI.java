package view;

import algorithm.PasswordCreation;
import java.util.Scanner;

public class ConsoleUI {

    Scanner scanner = new Scanner(System.in);
    PasswordCreation passwordCreation = PasswordCreation.getInstance();

    private ConsoleUI() {}
    private static ConsoleUI instance;

    public static ConsoleUI getInstance() {

        if (instance == null) {
            instance = new ConsoleUI();
        }
        return instance;
    }

    public void programInit() {

        System.out.println();
        System.out.println("""
                ╭── ⋅  ⋅ ── ~ ── ⋅  ⋅ ──╮
                                
                  ~ give-me-password ~
                                
                ╰── ⋅  ⋅ ── ~ ── ⋅  ⋅ ──╯
                """);

        delay(500);
        System.out.println("Welcome to the random password generator!");
        delay(1200);
        System.out.println("Press ENTER to continue.");
        scanner.nextLine();

        boolean running = true;

        while (running) {

            System.out.println("Insert password length:");
            int passwordLength = getPasswordLength();

            int excludedCharacterTypes;
            boolean includeLowercase, includeUppercase, includeDigits, includeSymbols;

            do {
                excludedCharacterTypes = 0;

                System.out.println("Include lowercase characters? (y/N)");
                includeLowercase = getYesOrNo();
                excludedCharacterTypes += iterateIfNotIncluded(includeLowercase);

                System.out.println("Include uppercase characters? (y/N):");
                includeUppercase = getYesOrNo();
                excludedCharacterTypes += iterateIfNotIncluded(includeUppercase);

                System.out.println("Include digits? (y/N):");
                includeDigits = getYesOrNo();
                excludedCharacterTypes += iterateIfNotIncluded(includeDigits);

                System.out.println("Include symbols? (y/N):");
                includeSymbols = getYesOrNo();
                excludedCharacterTypes += iterateIfNotIncluded(includeSymbols);

                if (excludedCharacterTypes == 4) {
                    System.out.println("At least one character type must be included. Please try again.");
                }

            } while (excludedCharacterTypes == 4);

            System.out.println("\n...Generating password with the following settings:");
            delay(200);
            System.out.println("Length: "+ passwordLength);
            delay(200);
            System.out.println("Lowercase: "+ includeLowercase);
            delay(200);
            System.out.println("Uppercase: "+ includeUppercase);
            delay(200);
            System.out.println("Digits: "+ includeDigits);
            delay(200);
            System.out.println("Symbols: "+ includeSymbols +"\n");

            StringBuilder password = passwordCreation.createPassword(passwordLength,
                    includeLowercase, includeUppercase, includeDigits, includeSymbols);

            delay(1000);
            System.out.println("YOUR PASSWORD: "+ password);
            delay(1000);
            System.out.println("\nGenerate another password? (y/N):");

            running = getYesOrNo();
        }

        System.out.println("Thank you for using the random password generator. Goodbye!");
    }

    private int getPasswordLength() {

        while (true) {
            String input = scanner.nextLine();

            try {
                int length = Integer.parseInt(input);

                if (length >= 4 && length <= 36) {
                    return length;
                } else {
                    System.out.println("Password length must be a positive between 4 and 36. Try again:");
                }

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
    }

    private boolean getYesOrNo() {

        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    private int iterateIfNotIncluded(boolean include) {

        if (!include) {
            return 1;
        }
        return 0;
    }

    private void delay(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}