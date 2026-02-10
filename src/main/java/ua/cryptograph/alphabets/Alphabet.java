package ua.cryptograph.alphabets;

public final class Alphabet {

    private final String name;
    private final char[] symbols;

    public Alphabet(String name, String symbols) {
        this.name = name;
        this.symbols = symbols.toCharArray();
    }

    public boolean contains(char ch) {
        for (char c : symbols) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    public char shift(char ch, int shift) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == ch) {
                int newIndex = (i + shift + symbols.length) % symbols.length;
                return symbols[newIndex];
            }
        }
        return ch;
    }

    public int length() {
        return symbols.length;
    }
}
