package algorithm;

import java.util.Random;

public class PasswordCreation {

    Random random = new Random();
    CharacterPool characterPool = CharacterPool.getInstance();

    private PasswordCreation() {}
    private static PasswordCreation instance;

    public static PasswordCreation getInstance() {

        if (instance == null) {
            instance = new PasswordCreation();
        }
        return instance;
    }

    public StringBuilder createPassword(int passwordLength, boolean includeLowercase,
                                        boolean includeUppercase, boolean includeDigits, boolean includeSymbols) {

        char[] passwordAsArray = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {

            int poolChoice = random.nextInt(4);

            passwordAsArray[i] =
                    getNextPasswordCharacter(poolChoice, includeLowercase, includeUppercase, includeDigits, includeSymbols);
        }

        StringBuilder passwordAsStringBuilder = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {

            passwordAsStringBuilder.append(passwordAsArray[i]);
        }
        return passwordAsStringBuilder;
    }

    private char getNextPasswordCharacter(int poolChoice, boolean includeLowercase,
                                          boolean includeUppercase, boolean includeDigits, boolean includeSymbols) {
        while (true){
            switch (poolChoice) {

                case 0:
                    if (includeLowercase) {

                        int lowercaseChoice = random.nextInt(characterPool.lowercasePoolLength());
                        return characterPool.getLowercase(lowercaseChoice);
                    }
                    break;

                case 1:
                    if (includeUppercase) {

                        int uppercaseChoice = random.nextInt(characterPool.uppercasePoolLength());
                        return characterPool.getUppercase(uppercaseChoice);
                    }
                    break;

                case 2:
                    if (includeDigits) {

                        int digitChoice = random.nextInt(characterPool.digitPoolLength());
                        return characterPool.getDigit(digitChoice);
                    }
                    break;

                case 3:
                    if (includeSymbols) {

                        int symbolChoice = random.nextInt(characterPool.symbolPoolLength());
                        return characterPool.getSymbol(symbolChoice);
                    }
                    break;
            }
            poolChoice = random.nextInt(4);
        }
    }
}