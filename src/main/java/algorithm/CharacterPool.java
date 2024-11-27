package algorithm;

public class CharacterPool {

    private CharacterPool() {}
    private static CharacterPool instance;

    public static CharacterPool getInstance() {

        if (instance == null) {
            instance = new CharacterPool();
        }
        return instance;
    }

    private static final char[] lowercasePool = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private static final char[] uppercasePool = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static final char[] digitPool = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private static final char[] symbolPool = {
            '`', '~', '!', '@', '#', '$', '%', '^', '&', '(', ')', '_', '-', '+',
            '=', '{', '}', '[', ']', '|', '.', ',', ':', ';', '<', '>', '?', '/'
    };

    public int lowercasePoolLength() { return lowercasePool.length;}
    public int uppercasePoolLength() { return uppercasePool.length;}
    public int digitPoolLength() { return digitPool.length;}
    public int symbolPoolLength() { return symbolPool.length;}

    public char getLowercase(int index) {

        if (index < 0 || index >= lowercasePool.length) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        return lowercasePool[index];
    }

    public char getUppercase(int index) {

        if (index < 0 || index >= uppercasePool.length) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        return uppercasePool[index];
    }

    public char getDigit(int index) {

        if (index < 0 || index >= digitPool.length) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        return digitPool[index];
    }

    public char getSymbol(int index) {

        if (index < 0 || index >= symbolPool.length) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        return symbolPool[index];
    }
}